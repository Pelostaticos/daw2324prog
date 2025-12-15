package tarea03;

// Importo la clase Teatro disponible en la librería libtarea3
import libtarea3.Teatro;

// Importo clases para trabajar con fecha y hora junto a su formato
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Ejercicio 1: Trabajo con teatros
 * @author Sergio García Butrón <contacto@bitgarcia.es>
 */

public class Ejercicio01 {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // 1.1. Declaración de constante para dar formato de fecha hora 
        final String CADENA_FORMATO_FECHA = "dd-MM-yyyy HH:mm:ss";
        
        /* NOTA: La cadena de formato fecha construida a partir de la información en:
        https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html */
        
        // 1.2. Declaración de tres variables referencia a objetos instancia de la clase Teatro
        Teatro teatroUno;
        Teatro teatroDos;
        Teatro teatroTres;
              

        // Clase Scanner para petición de datos de entrada (no es necesario)
        
        //----------------------------------------------
        //              Presentación
        //----------------------------------------------
        System.out.println("TRABAJO CON TEATROS");
        System.out.println("--------------------");
        System.out.println();

        //----------------------------------------------
        //               Análisis inicial
        //----------------------------------------------        
        // 2. Consulta de valores iniciales
        System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES");
        System.out.println("---------------------------------------");
        System.out.println();

        // 2.1. Número de teatros creados hasta el momento
        System.out.println("Número de teatros creados: " + Teatro.getTeatrosTotales());

        // 2.2. Número de obras que se están represenando en este momento en todos los teatros
        System.out.println("Número de obras que se están representando: " + Teatro.getObrasActivas());
        
        //2.3. Número de entradas vendidas en todos los teatros y para todas las obras que se han representado hasta el momento
        System.out.println("Número de entrads vendidas: " + Teatro.getEntradasVendidasTotales());
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        System.out.println("\n2.-CREACIÓN Y USO DE TEATROS");
        System.out.println("------------------------------\n");

        // 3.- Instanciación de tres objetos Teatro
        System.out.println("Creación de teatros (constructores)");
        System.out.println("-------------------------------------");

        // 3.1.- Intento de crear un teatro con un aforo inferior (hay que gestionar la posible excepción)
        try {
            System.out.println("Intentando crear un teatro con aforo inferior...");
            teatroUno = new Teatro("Mi Teatro", Teatro.AFORO_MIN - 1);
        } catch (IllegalArgumentException | NullPointerException errorInstanciacion) {
            System.out.printf("Error: %s \n\n", errorInstanciacion.getMessage());
        }
        // 3.2.- Intento de crear un teatro con un aforo superior (hay que gestionar la posible excepción)
        try {
            System.out.println("Intentando crear un teatro con aforo superior...");
            teatroDos = new Teatro("Mi Teatro", Teatro.AFORO_MAX + 1);
        } catch (IllegalArgumentException | NullPointerException errorInstanciacion) {
            System.out.printf("Error: %s \n\n",errorInstanciacion.getMessage());
        }        
        // 3.3.- Intento de crear un teatro con un nombre de teatro vacío y aforo por defecto
        try {
            System.out.println("Intentando crear un teatro nombre vacío y aforo por defecto...");
            teatroTres = new Teatro("");
        } catch (IllegalArgumentException errorInstanciacion) {
            System.out.printf("Error: %s \n\n",errorInstanciacion.getMessage());
        }
        // 3.4.- Creación de un primer teatro usando el constructor de dos parámetros
        System.out.println("Creando teatro con aforo válido con un constructor de dos parámetros...");
        teatroUno = new Teatro("Cervantes", Teatro.DEFAULT_AFORO + 100);
        System.out.printf("Teatro %d creado, estado: %s \n\n", Teatro.getTeatrosTotales(), teatroUno.toString());
        
        // 3.5.- Creación de un segundo teatro con un aforo por defecto usando el constructor de un parámetro
        System.out.println("Creando teatro con aforo por defecto usando constructor de un parámetro...");
        teatroDos = new Teatro("Apolo");
        System.out.printf("Teatro %d creado, estado: %s \n\n", Teatro.getTeatrosTotales(), teatroDos.toString());
        
        // 3.6.- Creación de un tercer teatro usando el constructor sin parámetros  
        System.out.println("Creando un teatro con valores por defecto usando el constructor sin parámetros...");
        teatroTres = new Teatro();
        System.out.printf("Teatro %d creado, estado: %s \n\n", Teatro.getTeatrosTotales(), teatroTres.toString());
        
        // NOTA: Uso el método estático "getTeatrosTotales" de la Clase Teatro para poner el número de 
        // teatro que he creado. Podía haberlo escrito de forma fija con un literal en el printf.
        
        
        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        // Dado que se va a ir mostrando información de salida a la vez que 
        // se van realizando operaciones, podemos considerar en este caso
        // que el procesamiento y la salida de resultado van unidos y "mezclados"
        
        // 4.- Operaciones con teatros
        
        System.out.println("Manipulación de teatros (métodos)");
        System.out.println("-----------------------------------");
        
        // 4.1.- Intento de terminar de representar una obra a un teatro que no tiene obra asignada (debemos capturar el error)
        try {
            System.out.println("Terminando de representar obra en el primer teatro...");
            teatroUno.terminarObra();
        } catch (IllegalStateException erroresMiTeatro) {
            System.out.printf("Error: %s \n\n",erroresMiTeatro.getMessage());
        }
        
        //4.2.- Asignamos una obra al teatro1 y lo llenamos (debemos comprobar antes si podemos asignarla)
        System.out.println("Asignando una obra de teatro...");
        // Si el teatro No tiene obra asignada entonces:
        if (!teatroUno.tieneObra()) {
           // Asigno la obra "La vida es sueño".
           teatroUno.asignarObra("La vida es sueño");
           // Lleno el teatro vendiendo todas las entradas.
           teatroUno.llenarTeatro();
           // Muestro por pantalla la información sobre la acción realizada
           System.out.printf("Se ha asignado la obra '%s' al teatro '%s'\n",teatroUno.getObra(), teatroUno.getNombreTeatro());
           System.out.printf("Teatro lleno. Se han vendido %d entradas.\n\n", teatroUno.getAforo());

        }
        
        //4.3.- Devolvemos 50 entradas del teatro1 (puesto que acabamos de llenar el teatro, no es necesario comprobar si podemos devolver entradas)
        System.out.println("Devolviendo 50 entradas del teatro 1...");
        teatroUno.devolverEntradas(50);
        System.out.printf("El teatro %s tiene %d de entradas vendidas para la obra '%s'.\n\n", teatroUno.getNombreTeatro(), teatroUno.getEntradasVendidas(), teatroUno.getObra());             
        
        //4.4.- Intentamos traspasar la representación de la obra del teatro1 al teatro2 (hay que gestionar la posible excepción)
        try {
            System.out.println("Intentando traspasr una obra de un teatro a otro");
            teatroUno.traspasarObra(teatroDos);
            System.out.println("Traspaso realizado con éxito");
        } catch (NullPointerException | IllegalStateException errorTeatroUno) {
            System.out.printf("Error: %s\n\n", errorTeatroUno.getMessage());
        }
        
        //4.5.- Devolvemos otras 50 entradas del teatro1 (no es necesario comprobar si podemos devolver entradas)
        System.out.println("Devolviendo otras 50 entradas del teatro 1...");
        teatroUno.devolverEntradas(50);
        System.out.printf("El teatro %s tiene %d de entradas vendidas para la obra '%s'.\n\n", teatroUno.getNombreTeatro(), teatroUno.getEntradasVendidas(), teatroUno.getObra());                    
        
        
        //4.6.- Volvemos a intentar traspasar la obra del teatro1 al teatro2 (ahora no debe dar excepción)
        try {
            System.out.println("Vuelvo a intentar el traspaso de una obra de un teatro a otro");
            teatroUno.traspasarObra(teatroDos);
            System.out.println("Traspaso realizado con éxito");
        } catch (NullPointerException | IllegalStateException errorTeatroUno) {
            System.out.printf("Error: %s\n", errorTeatroUno.getMessage());
        }        
        
        //4.7.- Devolver una entrada del teatro2
        System.out.println("\nDevolviendo una entrada del teatro 2...");
        teatroDos.devolverEntrada();
        System.out.printf("El teatro %s tiene %d de entradas vendidas para la obra '%s'.\n\n", teatroDos.getNombreTeatro(), teatroDos.getEntradasVendidas(), teatroDos.getObra());                    
        
        
         //5.- Obtención de información del segundo teatro creado
        System.out.println ("\nPrueba de los getters del segundo teatro creado:");
        System.out.println ("----------------------------------------------------");     
        // Doy formato a la fecha de la prueba solicitada en este apartado
        LocalDateTime fechaPrueba = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(CADENA_FORMATO_FECHA);
        // Muestro por pantalla la fecha a la que se ha generado el informe solicitado
        System.out.printf("Fecha de realización de la prueba: %s\n\n", fechaPrueba.format(formatoFecha));
        // Muestro por pantalla la cabecera del informe con la información solicitada
        System.out.print("Teatro 2");
        // Muestro por pantalla el código y nombre del segundo teatro.
        System.out.printf("\n  Código del teatro: %s Nombre del teatro: %s", teatroDos.getCodigoTeatro(), teatroDos.getNombreTeatro());
        // Muestro por pantalla el aforo del segundo teatro.
        System.out.printf("\n  Aforo: %d", teatroDos.getAforo());
        // Muestro por pantalla la sección "Estado" con: Obra que se representa y entradas vendidas en el segundo teatro
        System.out.print("\n  Estado:");
        System.out.printf("\n    Se está representando la obra de teatro: \"%s\"", teatroDos.getObra());
        System.out.printf("\n    Entradas vendidas: %d\n\n", teatroDos.getEntradasVendidas());
        
        //----------------------------------------------
        //               Análisis Final
        //----------------------------------------------        
        // 6. Consulta de valores finales
        System.out.println("3.-CONSULTA FINAL DE VALORES GLOBALES");
        System.out.println("-------------------------------------");
        System.out.println();

        // 6.1. Número de teatros creados hasta el momento
        System.out.println("Número de teatros creados: " + Teatro.getTeatrosTotales());

        // 6.2. Número de obras que se están represenando en este momento en todos los teatros
        System.out.println("Número de obras que se están representando: " + Teatro.getObrasActivas());
        
        //6.3. Número de entradas vendidas en todos los teatros y para todas las obras que se han representado hasta el momento
        System.out.println("Número de entrads vendidas: " + Teatro.getEntradasVendidasTotales());
        
    }
    
}