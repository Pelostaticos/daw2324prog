package tarea07;

//Librerías importadas necesarias para el programa
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/** Ejercicio 2. Búsqueda de especies de plantas populares
 * @author Sergio García Butrón <contacto@bitgarcia.es>sor
 */
public class Ejercicio02 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
        final int CANTIDAD_ESPECIES_PLANTAS=10;
        
        // Variables de entrada

        /*Utilizo un ArrayList porque predomina las operaciones de inserción y
        consulta y está colección ofrece mejor rendimiento en estos casos. Y
        decido asignarle el tipo base StringBuilder ya que ahorrá espacio de
        memoria al no utilizar  el tipo inmutable String que por cada cadena
        nueva, ocupa espacio adicionak en memoria*/
        ArrayList<StringBuilder> listaPlantas1 = new ArrayList<>();
        ArrayList<StringBuilder> listaPlantas2 = new ArrayList<>();
        
        // Variables auxiliares
        int contadorPlantas=0;
        StringBuilder planta1;
        StringBuilder planta2;        
        Iterator<StringBuilder> iteradorListaPlantas1;
        Iterator<StringBuilder> iteradorListaPlantas2;

       
        // Variables de salida
        ArrayList<StringBuilder> listaFinalPlantas1;
        ArrayList<StringBuilder> listaFinalPlantas2;
        ArrayList<StringBuilder> listaEspeciePlantasPopulares = new ArrayList<>();
        ArrayList<Integer> listaPosicionesPopulares = new ArrayList<>();
        
        /*Utilizo un cojunto tipo HashSet porque no veo requisitos sobre el orden de inswrción, a pesar
        de que estos ocupen más recurso. Lo he pensado para variar de tipo de conjunto que ofrece Java*/
        HashSet<String> conjuntoPlantasPopulares = new HashSet<>();
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        System.out.println("BÚSQUEDA DE ESPECIES DE PLANTAS POPULARES");
        System.out.println("-----------------------------------------");
        
        
        // No hay, pues se usa un número fijo de elementos aleatorios

        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_ESPECIES_PLANTAS
        while (contadorPlantas < CANTIDAD_ESPECIES_PLANTAS) {
            listaPlantas1.add(new StringBuilder(Utilidades.especiePlantaAleatoria()));
            listaPlantas2.add(new StringBuilder(Utilidades.especiePlantaAleatoria()));      
            contadorPlantas++;
        }
        
        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------


        // Recorremos a la vez las dos listas
        //09) Inicializo el contador de plantas y listas finales de plantas
        contadorPlantas=0;
        listaFinalPlantas1 = new ArrayList<>(listaPlantas1);
        listaFinalPlantas2 = new ArrayList<>(listaPlantas2);
        //1º) Obtengo los iteradores de las listas iniciales de plantas
        iteradorListaPlantas1 = listaPlantas1.iterator();
        iteradorListaPlantas2 = listaPlantas2.iterator();
        //2º) Recorro el bucle mientras exista siguiente elementos en ambos iteradores
        while (iteradorListaPlantas1.hasNext() && iteradorListaPlantas2.hasNext()) {
            //2.1º) Recupero una planta del iterador para la primera lista de plantas
            planta1 = iteradorListaPlantas1.next();
            //2.2º) Recupero una planta del iterador para la segunda lista de plantas
            planta2 = iteradorListaPlantas2.next();
            //2.3º) Compruebo si coinciden el elemento actual de cada una de las listas
            if (planta1.toString().equals(planta2.toString())) {
               //A) Almaceno la especie de planta en el listado de plantas populares tomanado planta1 como valor
               listaEspeciePlantasPopulares.add(new StringBuilder(planta1));
               //B) Almaceno la especie de planta en el conjunto de plantas populares.
               conjuntoPlantasPopulares.add(planta1.toString());
               //C) Almaceno la posición de la planta popular localizada.
               listaPosicionesPopulares.add(contadorPlantas);
               //D) Marco la planta popular con asteriscos al principio y final de su nombre
               planta2 = new StringBuilder(planta1);          //Empleo la variable planta2 para marcar el nombre de la planta popular "planta1" ya que coinciden
               planta2.insert(0, "*");                  //Primer asterisco al principio de la cadena del nombre de la planta popular
               planta2.insert(planta2.length(), "*");   //Segundo asterisco al final de la cadena del nombre de la planta popular
               listaFinalPlantas1.set(contadorPlantas, new StringBuilder(planta2));
               listaFinalPlantas2.set(contadorPlantas, new StringBuilder(planta2));
               
            }
            //2.4º) Incremento el contador de plantas
            contadorPlantas++;
        }

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.printf("1. Contenido inicial de la lista 1: %s\n", listaPlantas1);
        System.out.printf("2. Contenido inicial de la lista 2: %s\n\n", listaPlantas2);
        System.out.printf("1. Contenido final de la lista 1: %s\n", listaFinalPlantas1);
        System.out.printf("2. Contenido final de la lista 2: %s\n", listaFinalPlantas2);
        System.out.printf("3. Contenido final de la lista de especies de plantas populares: %s\n", listaEspeciePlantasPopulares);
        System.out.printf("4. Contenido final de la lista de posiciones populares: %s\n",listaPosicionesPopulares);
        System.out.printf("5. Contenido final del conjunto de especies de plantas populares: %s\n",conjuntoPlantasPopulares);

    }
}