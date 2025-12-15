/**

Título de la Tarea: Implementación de Operaciones CRUD sobre Base de Datos H2.

Propósito:

Este programa/clase es la implementación de la Tarea 10 del módulo de Programación
(DAM/DAW, Curso 2023/24). El objetivo principal es practicar la conexión y manipulación
de datos en bases de datos relacionales (utilizando H2 en modo embebido) a través de un 
programa Java. La implementación incluye:

    >> Creación y relleno de tablas.
    >> Métodos para Consultar, Insertar, Actualizar y Eliminar registros (CRUD) de la base de datos.

@author Sergio García Butrón <contacto@bitgarcia.es>

*/

package ejemplo;

// jdbc:h2:./proyectobase.h2db
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import org.h2.tools.Server;
import static java.lang.System.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.stream.Collectors;
import utilidades.ES;

/**
 * Clase principal de inicio del programa.
 */
public class Aplicacion {

    /**
     * Nombre del archivo de base de datos local.
     */
    private static final String DB_NOMBRE = "proyectobase.h2db";
    /**
     * URL para la conexión a la base de datos.
     */
    private static final String URL_CONEXION = "jdbc:h2:./" + DB_NOMBRE;
    /**
     * Driver a utilizar para conectarse a la base de datos.
     */
    private static final String DRIVER = "org.h2.Driver";
    /**
     * Opciones de conexión.
     */
    private static final String PARAMS = ";MODE=MySQL;AUTO_RECONNECT=TRUE";

    /**
     * Path al archivo que contiene la estructura de la base de datos.
     */
    public final static String ESTRUCTURA_DB = "/resources/creaBD.sql";

    /**
     * Path al archivo que contiene la estructura de la base de datos.
     */
    public final static String INSERTA_DB = "/resources/cargaBD.sql";

    /**
     * Método principal de la aplicación. En él se realiza la preparación del
     * entorno antes de empezar. A destacar:
     *
     * - Se carga el driver (Class.forName). - Se establece una conexión con la
     * base de datos (DriverManager.getConnection) - Se crean las tablas, si no
     * están creadas, invocando el método createTables. - Se ejecuta una
     * consulta de prueba
     *
     * @param args
     */
    public static void main(String[] args) {
        boolean driverCargado = false;

        //Carga del driver de la base de datos.
        try {
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            driverCargado = true;
        } catch (ClassNotFoundException e) {
            err.printf("No se encuentra el driver de la base de datos (%s)\n", DRIVER);
        } catch (InstantiationException | IllegalAccessException ex) {
            err.printf("No se ha podido iniciar el driver de la base de datos (%s)\n", DRIVER);
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Si el driver está cargado, aseguramos que podremos conectar.
        if (driverCargado) {
            //Conectamos con la base de datos.
            //El try-with-resources asegura que se cerrará la conexión al salir.
            String[] wsArgs = {"-baseDir", System.getProperty("user.dir"), "-browser"};
            try ( Connection con = DriverManager.getConnection(URL_CONEXION + PARAMS, "", "")) {

                // Iniciamos el servidor web interno (consola H2 para depuraciones)
                Server sr = Server.createWebServer(wsArgs);
                sr.start();

                // Presentamos información inicial por consola
                out.println("¡¡Atención!!");
                out.println();
                out.println("Mientras tu aplicación se esté ejecutando \n"
                        + "puedes acceder a la consola de la base de datos \n"
                        + "a través del navegador web.");
                out.println();
                out.println("Página local: " + sr.getURL());
                out.println();
                out.println("Datos de acceso");
                out.println("---------------");
                out.println("Controlador: " + DRIVER);
                out.println("URL JDBC: " + URL_CONEXION);
                out.println("Usuario: (no indicar nada)");
                out.println("Password: (no indicar nada)");

                // Creamos las tablas y algunos datos de prueba si no existen
                // y continuamos
                if (crearTablas(con)) {

                    // Insertar los datos en las tablas de la BD
                    insertarDatosTablas(con);

                    boolean continuar = true;

                    do {
                        System.out.println("\n\n");
                        System.out.println("\n --------------------------------------------------------------------------------");
                        System.out.println("| MENU DE LA APLICACIÓN                                                          |");
                        System.out.println(" --------------------------------------------------------------------------------");
                        System.out.println("  1 - Mostrar Peliculas");
                        System.out.println("  2 - Borrar Plataforma");
                        System.out.println("  3 - Modificar Plataforma");
                        System.out.println("  4 - Mostrar Peliculas por plataformas");
                        System.out.println("  0 - Salir");
                        System.out.println(" --------------------------------------------------------------------------------\n\n");

                        // Leer la opción correspondiente a ejecutar.
                        int opcion = ES.leeEntero("Escriba opción: ", 0, 4);
                        switch (opcion) {
                            case 0:
                                continuar = false;
                                break;
                            case 1:
                                mostrarPeliculas(con);
                                break;
                            case 2:
                                borrarPlataforma(con);
                                break;
                            case 3:
                                modificarPlataforma(con);
                                break;
                            case 4:                                
                                mostrarPeliculasPorPlataformas(con);
                                break;
                        }
                    } while (continuar);

                    // Esperar tecla
                    ES.leeCadena("Antes de terminar, puedes acceder a la "
                            + "consola de H2 para ver y modificar la base de "
                            + "datos. Pulsa cualquier tecla para salir.");

                } else {
                    System.out.printf("Problema creando las tablas: ");
                }

                sr.stop();
                sr.shutdown();

            } catch (SQLException ex) {
                System.out.printf("No se pudo conectar a la base de datos (%s): %s\n", DB_NOMBRE, ex.getMessage());
            }
        }

    }

    /**
     * Dada una conexión válida, lleva a cabo la creación de la estructura de la
     * base de datos, usando como SQL para la creación el contenido en la
     * constante ESTRUCTURA_DB
     *
     * @param con conexión a la base de datos.
     * @see ESTRUCTURA_DB
     * @return true si se creo la estructura y false en caso contrario.
     */
    public static boolean crearTablas(Connection con) {
        boolean todoBien = false;

        try ( Statement st = con.createStatement()) {

            String sqlScript = loadResourceAsString(ESTRUCTURA_DB);
            if (sqlScript != null) {
                st.execute(sqlScript);
                todoBien = true;
            } else {
                System.out.printf("Problema cargando el archivo: %s \n", ESTRUCTURA_DB);
                System.out.printf("Para ejecutar este proyecto no puede usarse 'Run File'\n");
            }

        } catch (SQLException ex) {
            System.out.printf("Problema creando la estructura de la base de datos: %s\n", ex.getMessage());
        }
        return todoBien;
    }

    /**
     * Dada una conexión válida, lleva a cabo la inserción de datos de la base
     * de datos, usando como SQL para la creación el contenido en la constante
     * INSERTA_DB
     *
     * @param con conexión a la base de datos.
     * @see INSERTA_DB
     * @return true si se creo la estructura y false en caso contrario.
     */
    private static boolean insertarDatosTablas(Connection con) {
        boolean todoBien = false;

        try ( Statement st = con.createStatement()) {

            String sqlScript = loadResourceAsString(INSERTA_DB);
            if (sqlScript != null) {
                st.execute(sqlScript);
                todoBien = true;
            } else {
                System.out.printf("Problema cargando el archivo: %s \n", INSERTA_DB);
                System.out.printf("Para ejecutar este proyecto no puede usarse 'Run File'\n");
            }

        } catch (SQLException ex) {
            System.out.printf("Problema insertando datos en la base de datos: %s\n", ex.getMessage());
        }
        return todoBien;
    }

    /**
     * Carga un recurso que estará dentro del JAR como cadena de texto.
     *
     * @param resourceName Nombre del recurso dentro del JAR.
     * @return Cadena que contiene el contenido del archivo.
     */
    public static String loadResourceAsString(String resourceName) {
        String resource = null;
        InputStream is = Aplicacion.class.getResourceAsStream(resourceName);
        if (is != null) {
            try ( InputStreamReader isr = new InputStreamReader(is);  BufferedReader br = new BufferedReader(isr);) {
                resource = br.lines().collect(Collectors.joining("\n"));
            } catch (IOException ex) {
                System.out.printf("Problema leyendo el recurso como cadena: %S\n ", resourceName);
            }
        }
        return resource;
    }

    /**
     * Muestra por consola las películas de la BD.
     *
     * @param con Conexión a la BD
     */
    private static void mostrarPeliculas(Connection con) {
        //Si existe conexión: Ejecutamos la consulta sobre la tabla peliculas y mostramos su contenido.
        if (con != null) {
            // Intento realizar la consulta a la tabla Peliculas
            try (Statement consulta = con.createStatement()) {
                
                // Obtengo los resultado de la consulta a la tabla Peliculas
                ResultSet resultados = consulta.executeQuery("SELECT codigo,titulo,sinopsis,fEstreno FROM Peliculas");
                
                // Muestro la cabecera de los resultados obtenidos
                System.out.println();
                System.out.print(" -------- Listado de Peliculas ----------------- \n");
                System.out.print("| Código - título - Sinopsis - Fecha de estreno |\n");
                System.out.print(" ----------------------------------------------- \n");
                
                //Bucle para recuperar y mostrar los datos del resultado de la consulta SQL
                while (resultados.next()) {
                    int codigo = resultados.getInt("codigo");
                    String titulo = resultados.getString("titulo");
                    String sinopsis = resultados.getString("sinopsis");
                    String fEstreno = resultados.getDate("fEstreno").toString();
                    System.out.printf("%d - %s - %s - %s.\n", codigo, titulo, sinopsis, fEstreno);
                }
                                
            } catch (SQLException ex) {
                System.out.printf("Se ha producido un error al ejecutar la consulta SQL.");
            }
        }
    }

    /**
     * 
     * Muestra el listado de las plataformas disponibles
     * 
     * @param con conexión a la base de Datos
     */
    private static void mostrarPlataformas(Connection con) {
        //Si existe conexión: Ejecutamos la consulta sobre la tabla Plataformas y mostramos su contenido.
        if (con != null) {
            // Intento realizar la consulta a la tabla Plataformas
            try (Statement consulta = con.createStatement()) {
                
                // Obtengo los resultado de la consulta a la tabla Plataformas
                ResultSet resultados = consulta.executeQuery("SELECT codigo,nombre FROM Plataformas");
                
                // Muestro la cabecera de los resultados obtenidos
                System.out.println();
                System.out.print(" -------- Listado de Plataformas---------------- \n");
                System.out.print("| Código - nombre                               |\n");
                System.out.print(" ----------------------------------------------- \n");
                
                //Bucle para recuperar y mostrar los datos del resultado de la consulta SQL
                while (resultados.next()) {
                    int codigo = resultados.getInt("codigo");
                    String nombre = resultados.getString("nombre");
                    System.out.printf("%d - %s.\n", codigo, nombre);
                }
                                
            } catch (SQLException ex) {
                System.out.printf("Se ha producido un error al ejecutar la consulta SQL.");
            }
        }        
    }
    
    /**
     * Modificar el nombre de una plataforma de la BD
     *
     * @param con Conexión a la BD
     */
    private static void modificarPlataforma(Connection con) {
        
        // Si existe conexión entonces:
        if (con != null) {
            //Mostramos las plataformas disponibles.
            mostrarPlataformas(con);
            //Pediremos el código de la plataforma y el nuevo nombre.
             int codigoPlataforma = ES.leeEntero("\n\nEscribe el código de la plataforma a modificar:");
             String nuevoNombre = ES.leeCadena("Introduzca el nuevo nombre de la plataforma:");
            // Ejecutamos la sentencia SQL de actualización
            // A) Defino la cadena con la petición para actualizar una plataforma
            String peticionActualizar = "UPDATE Plataformas SET nombre=? WHERE codigo=?;";
            // B) Intento actualizar el nombre de la plataforma deseada
            try ( PreparedStatement consulta = con.prepareStatement(peticionActualizar)) {
                // Establezco los parámetros de la consulta preparada para actualizar la plataforma deseada
                consulta.setString(1, nuevoNombre);
                consulta.setInt(2, codigoPlataforma);
                // Ejecuto la consulta preparada para actualizar la plataforma deseada
                int registrosAfectados = consulta.executeUpdate();
                // Muestro el mensaje del resultado según el resultado obtenido de la consulta ejecutada
                if (registrosAfectados>0)
                {
                    System.out.println("Modificación correcta");
                } else {
                    System.out.println("No se realizó ninguna modificación en las plataformas.");
                }              
            } catch (SQLException ex) {
                System.out.printf("Se ha producio un error al ejecutar la consulta SQL.");
            }
            
        }
    }

    /**
     * Borrar plataforma de la BD
     *
     * @param con Conexión a la BD
     */
    private static void borrarPlataforma(Connection con) {
        // Si existe conexión entonces:
        if (con != null) {
            //Mostramos las plataformas disponibles.
            mostrarPlataformas(con);
            //pedimos el código de la plataforma a borrar
            int codigoPlataforma = ES.leeEntero("\n\nEscribe el código de la plataforma a borrar:");
            // Ejecutamos la sentencia SQL de borrado
            // A) Defino la cadena de la petición SQL para el borrado
            String peticionBorrado = "DELETE FROM Plataformas WHERE codigo=?";
            // B) Intento borrar la plataforma deseada
            try ( PreparedStatement consultaBorrado = con.prepareStatement(peticionBorrado)) {
                // Establezco el valor del código de plataforma que deseo eleminar en la consulta SQL
                consultaBorrado.setInt(1, codigoPlataforma);
                //Ejecuto la consulta preparada para realizar el borrado d ela plataforma deseada
                int registrosAfectados = consultaBorrado.executeUpdate();
                if (registrosAfectados > 0) {
                    System.out.println("Borrado de plataforma correcto.");
                } else {
                    System.out.println("Borrado d eplataforma incorrecto, porque no existe.");
                }                
                // 
            } catch (SQLException ex) {
                System.out.printf("Se ha producio un error al borrar plataforma: %s\n.", ex.getMessage());
            }
        }
        
    }

    /**
     * Muestra el nombre de todas las películas existentes en cada plataforma de la BD
     *
     * @param con Conexión a la BD
     */
    private static void mostrarPeliculasPorPlataformas(Connection con) {
        /*Para cada plataforma existente en la tabla Plataformas, debes mostrar el nombre de la 
          plataforma en la consola y buscar las películas asociadas a la plataforma en la tabla Disponible_en. 
          Para cada película, usando el código de la película buscar el nombre para mostrarlo en la consola. */
              
        // Defino aquellas vairables locales requeridas por el método
        LinkedHashMap<Integer, String> plataformas = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> peliculas = new LinkedHashMap<>();
        
        // Si existe conexión entonces
        if (con != null) {
            // Primero intento generar un mapa clave-valor con las plataformas disponibles
            try ( Statement consulta = con.createStatement()) {
                // Ejecuto una consulta SQL sencilla
                ResultSet resultados = consulta.executeQuery("SELECT codigo, nombre FROM Plataformas");
                // Bucle para recuperar el nombre de todas las plaatformas disponibles y agregarlas al mapa
                while (resultados.next()) {
                    int codigoPlataforma = resultados.getInt("codigo");
                    String nombrePlataforma = resultados.getString("nombre");
                    plataformas.put(codigoPlataforma,nombrePlataforma);
                }
            }  catch (SQLException ex) {
                System.out.printf("Se ha producido un error al ejecutar la consulta SQL.");
            }
           
            // Segundo intento generar un mapa clave-valor con las peliculas disponibles
            try ( Statement consulta = con.createStatement()) {
                // Ejecuto una consulta SQL sencilla
                ResultSet resultados = consulta.executeQuery("SELECT codigo, titulo FROM Peliculas");
                // Bucle para recuperar el titulo de todas las peliculas disponibles y agregarlas al mapa
                while (resultados.next()) {
                    int codigoPelicula = resultados.getInt("codigo");
                    String tituloPelicula = resultados.getString("titulo");
                    peliculas.put(codigoPelicula,tituloPelicula);
                }
            }  catch (SQLException ex) {
                System.out.printf("Se ha producido un error al ejecutar la consulta SQL.");
            }
            
            // Tercero muestro el listado de peliculas disponibles por cada plataforma
            // A) Defino la cadena con la petición preparada para buscar las peliculas de cada plataforma
            String peticionPeliculas = "SELECT codPelicula FROM Disponible_en WHERE codPlataforma=?";

            // B) Muestro la cabecera de las Peliculas por plataformas
            System.out.println(" -------------------------------------------------------------------------------- ");
            System.out.println("| PELICULAS POR PLATAFORMAS                                                      |");
            System.out.println(" -------------------------------------------------------------------------------- ");
            
            // C) Si existen plataformas intento recuperar para cada plataforma su listado de peliculas disponibles
            if (!plataformas.isEmpty()) {
                try ( PreparedStatement consulta = con.prepareStatement(peticionPeliculas)) {
                    // Bucle para ejecutar la consulta por cada plataforma disponible
                    for(int codigoPlataforma: plataformas.keySet()) {
                        // Muestro el nombre de la plataforma la usuario
                        System.out.printf(" Plataforma: %s\n", plataformas.get(codigoPlataforma));
                        //Establezco el código de la plataforma cuyas peliculas quiero consultar
                        consulta.setInt(1, codigoPlataforma);
                        // Si la ejecución de la consulta devuelve resultados
                        if (consulta.execute()) {
                            // Obtengo todos los resultados obtenidos por la consulta
                            ResultSet resultados = consulta.getResultSet();
                            // Bucle para listar todas las peliculas encontradas para la plataforma actual
                            while (resultados.next()) {
                                // Recupero el cñódigo de la pelicula de los resultados de la consulta SQL
                                int codigoPelicula = resultados.getInt("codPelicula");
                                // Muestro al usuario el titulo d ela pelicula correspondiente
                                System.out.printf("   %s\n", peliculas.get(codigoPelicula));
                            }

                        }
                        // Linea de cierre listado de peliculas para plataforma actual
                        System.out.println(" -------------------------------------------------------------------------------- ");                        
                    }
                } catch (SQLException ex) {
                    System.out.printf("Se ha producido un error al ejecutar la consulta SQL.");
                }                
            } else {
                System.out.println(" No hay plataformas disponibles");
                System.out.println(" -------------------------------------------------------------------------------- ");
            }
        }
    }
}
