package ejercicio1;

// Importo las librerias necesarias para el programa
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Ejercicio 1: Lectura/escritura de un recetario en ficheros de texto.
 *
 * @author Sergio Garcia Butron
 */
public class Ejercicio1 {

    //Atributos de clase constantes
    public static final String SEPARADOR_PASOS_RECETA = "&";
    public static final String PUNTO_FINAL = ".";
    
    /**
     * Método principal.
     *
     * @param args argumentos que recibe el método
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final String RUTA_RECETAS = System.getProperty("user.dir") + "/recursos/ListadoRecetas.txt";
        final String RUTA_RECETARIO = System.getProperty("user.dir") + "/recursos/Recetario.txt";   
        final String INICIO_RECETA = "#";
        final String SEPARADOR_SECCION_RECETA = ";";
        final String SEPARADOR_DATOS_SECCION = ",";
        final String SEPARADOR_LINEAS_RECETAS = "\n";
        final String CARACTERES_LIMPIAR_RECETAS = "[\\#\\[\\]]";
        final int NOMBRE_RECETA = 0;
        final int TIPO_PLATO = 1;
        final int FECHA_CREACION = 2;
        final int LISTADO_INGREDIENTES = 3;
        final int INSTRUCCIONES = 4;
        // Variables de entrada
        String lineaFicheroTexto;                       // Almacena temporalmente cada línea leida del fichero de textp
        String[] datosReceta;                           // Almacenas los datos de una receta descompuestos en sus secciones
        // Variables de salida
        Recetario miRecetario;                          // Un objeto de clase Recetario para guardar las recetas leídas del fichero de texto.
        StringBuilder contenidoLibroRecetas;            // Cadena de texto avanzada para generar el contenido de salida del libro de recetas.
        // Variables auxiliares
        String textoRecetario;                          // Almacena temporalmente el texto del recetario generado desde fichero
        ArrayList<String> listadoIngredientes;          // Almacena el listado de ingredientes de la receta generado desde los datos del ficheros
        Receta unaReceta;                               // Almacena temporalmente un objeto de clase Receta que se genera con los datos de su receta del fichero.

        //----------------------------------------------
        //       Entrada de datos + Procesamiento
        //----------------------------------------------
        // 1º) Creo el objeto recetario para guardar las recetas del fichero de texto
        miRecetario = new Recetario();

        // Intento leer el archivo de texto ListadoRecetas.txt con las recetas
        System.out.println("Abriendo archivo de recetas...");
        try (//Creo el lector de ficheros de textos por caracteres
                FileReader lectorFichero = new FileReader(RUTA_RECETAS); //Creo el lector de lineas del fichero de texto del recetario
                BufferedReader lectorFicheroTexto = new BufferedReader(lectorFichero);) {

            //2º) Leo las lineas del recetario hasta llegar al final
            while ((lineaFicheroTexto = lectorFicheroTexto.readLine()) != null) {
                /* Elimino de la linea de texto que contiene los datos de la receta todos aquellos
                caracteres de la cadena que so inncesarios como # de inicio de lnea de receta y los
                corchetes [] que representa una lista cuando de convierte a cadena de texto */    
                lineaFicheroTexto = lineaFicheroTexto.replaceAll(CARACTERES_LIMPIAR_RECETAS, "");
                //3º) Extraigo los datos de las receta desde la linea de texto que la contiene
                datosReceta = lineaFicheroTexto.split(SEPARADOR_SECCION_RECETA);                
                //4º) Obtengo el listado de ingredientes
                listadoIngredientes = new ArrayList<>();
                listadoIngredientes.addAll(Arrays.asList(datosReceta[LISTADO_INGREDIENTES].split(SEPARADOR_DATOS_SECCION)));
                // 5º) Creo una receta con los datos actualmente disponibles
                unaReceta = new Receta(datosReceta[NOMBRE_RECETA],
                        datosReceta[TIPO_PLATO],
                        LocalDate.parse(datosReceta[FECHA_CREACION]),
                        listadoIngredientes,
                        datosReceta[INSTRUCCIONES]);
                // 6º) Añado la receta creada al recetario 
                miRecetario.add(unaReceta);                
            }

        } catch (FileNotFoundException e) {
            // Controlo excepción cuando el fichero de recetario no se encnuetra
            System.err.printf("El fichero %s no encontrado!!!", RUTA_RECETAS);
        } catch (IOException e) {
            // Controlo excepción cuando se produce un error de entrada salida
            System.err.println("Error de entrada y salida");
        } catch (Exception e) {
            // Controlo cualquier otra excepción que pueda surgir            
            System.err.println(e.getMessage());
        } finally {

            // Muestro por pantalla información del resultado de procesar el fichero de texto
            System.out.printf("Se han cargado %d recetas en el recetario...\n", miRecetario.numRecetas());
            System.out.print(miRecetario.toString());
            System.out.println("Cerrando archivo de recetas...");
            System.out.println();

        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        // Abrimos el archivo de la agenda Recetario.txt
        System.out.println("Abriendo archivo del recetario...");
        // Creo una instancia de la cadena de texto que contendrá al libro de recetas
        contenidoLibroRecetas = new StringBuilder();
        // Inserto el encabezado del libro de recetas
        contenidoLibroRecetas.append("**********************************************************************************************************************************\n");
        contenidoLibroRecetas.append("LIBRO DE RECETAS\n");
        contenidoLibroRecetas.append("**********************************************************************************************************************************\n");
        /* Obtengo el texto representativo del objeto miRecetario con su contenido actual
            elimino todos aquellos caracteres inncesarios para el posterior procesado */
        textoRecetario = miRecetario.toString().replaceAll(INICIO_RECETA, "");
        // Proceso el texto representativo del objeto Recetario para crear el contenido del libro de recetas
        for (String lineaReceta : textoRecetario.split(SEPARADOR_LINEAS_RECETAS)) {
            // Obtengo los datos de la recetas disponible en la línea de texto actual
            datosReceta = lineaReceta.split(SEPARADOR_SECCION_RECETA);
            contenidoLibroRecetas.append(String.format("NOMBRE DE LA RECETA: %s\n", datosReceta[NOMBRE_RECETA]));
            contenidoLibroRecetas.append(String.format("TIPO DE PLATO: %s\n", datosReceta[TIPO_PLATO]));
            contenidoLibroRecetas.append(String.format("FECHA CREACION: %s\n", datosReceta[FECHA_CREACION]));
            contenidoLibroRecetas.append(String.format("INGREDIENTES: %s\n", datosReceta[LISTADO_INGREDIENTES]));
            /* Añado las instrucciones de la receta paso a paso de forma correcta.
                He dedcido hacerlo con un método estático auxiliar para hacerlo más claro*/
            contenidoLibroRecetas.append(Ejercicio1.extraerInstruccionesReceta(datosReceta[INSTRUCCIONES]));
            //Añado la línea de cierre de cada receta en el libro               
            contenidoLibroRecetas.append("**********************************************************************************************************************************\n");
        }     
        /* Intdnto abrir el fichero de salida para guardar el libro de recetas 
        la sentencia try-with-resource abre los recursos neecarios y los cierra automaticamente */
        try (FileWriter fichero = new FileWriter(RUTA_RECETARIO);
            PrintWriter ficheroTexto = new PrintWriter(fichero);) {
            // 7º) Guardo la represntacion textual del libro de recetas al fichero de texto
            ficheroTexto.println(contenidoLibroRecetas.toString());
            // Controlo excepción cuando el fichero no se encuentra
        } catch (FileNotFoundException e) {
            System.err.printf("El fichero %s no encontrado!!!", RUTA_RECETARIO);
            // Controlo excepción cuando se produce un error de entrada salida
        } catch (IOException e) {
            System.err.println("Error de entrada y salida");
            // Controlo cualquier otra excepción que pueda surgir    
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {

            // Muestro al usuario por consola información acerca del final del proceso
            System.out.println(contenidoLibroRecetas.toString());
            System.out.println("Cerrando archivo del recetario...");

            System.out.println();
            System.out.println("Archivos cerrados y procesamiento finalizado");
            System.out.println("---------");
            System.out.println();
            System.out.println("Fin del programa.");

        }

    }
    
    /**
     * 
     * Método estático para generar las instrucciones de la receta paso a paso
     *
     * @param datosInstruccionesReceta Cadena de texto que contiene instrucciones de la recetas
     * @return Cadena de texto con las instrucciones de la receta paso a paso
     */
    private static  String extraerInstruccionesReceta(String datosInstruccionesReceta) {

        /* Convierto la cadena con los datos de las instrucciones de la receta a un
        formato que me permita detectar los pasos de la misma: ¿Cómo lo hago?
        Cada punto final es una linea nueva y un nuevo paso en la receta por tanto
        sustituyo este carácter en la cadena original por un punto final y un caracter
        separador de los pasos de la receta, que he decidido usar el Ampersand*/ 
        String lasInstrucciones = datosInstruccionesReceta.replace(Ejercicio1.PUNTO_FINAL,
                Ejercicio1.PUNTO_FINAL+Ejercicio1.SEPARADOR_PASOS_RECETA);
        
        // defino variable local para guardar el texto con las instrucciones de la receta
        StringBuilder instruccionesReceta = new StringBuilder("INSTRUCCIONES:\n");

        // Defino array de cadenas local para almacenar los pasos de la receta extraidos de sus datos
       String[] pasosReceta = lasInstrucciones.split(Ejercicio1.SEPARADOR_PASOS_RECETA);
        
        //Redacto las instrucciones de la receta paso a paso
        for (int i = 0; i < pasosReceta.length; i++) {
            instruccionesReceta.append(String.format("%d. %s\n", i + 1, pasosReceta[i]));
        }

        // Devuelvo la cadena de texto con las instrucciones de la freceta paso a paso.
        return instruccionesReceta.toString();
    }    
    
}
