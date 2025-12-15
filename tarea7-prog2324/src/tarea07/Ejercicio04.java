package tarea07;

//Importo las librerias necesarias para el programa
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;


/** Ejercicio 4. Clasificación de especies de plantas coincidentes 
 * (con el mismo nombre y en la misma posición)
 * @author Sergio García Butrón <contacto@bitgarcia.es>sor
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------

        // Constantes
        final int CANTIDAD_ESPECIES_PLANTAS=20;
        
        // Variables de entrada
        ArrayList<String> listaPlantas1 = new ArrayList<>();
        ArrayList<String> listaPlantas2 = new ArrayList<>();
        
        // Variables auxiliares
        int contadorPlantas=0;
        String planta1;
        String planta2;
        Iterator<String> iteradorListaPlantas1;
        Iterator<String> iteradorListaPlantas2;
        ArrayList<Integer> listaPosiciones;
        
        // Variables de salida
        LinkedHashMap<String, ArrayList<Integer>> plantasClasificadas = new LinkedHashMap<>();

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        
        System.out.println("CLASIFICACIÓN DE COINCIDENTES");
        System.out.println("-----------------------------");

        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_ESPECIES_PLANTAS
        while (contadorPlantas < CANTIDAD_ESPECIES_PLANTAS) {
            listaPlantas1.add(Utilidades.especiePlantaAleatoria());
            listaPlantas2.add(Utilidades.especiePlantaAleatoria());
            contadorPlantas++;
        }
        
        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------
        //09) Inicializo el contador de plantas.
        contadorPlantas=0;
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
            if (planta1.equals(planta2)) {
                //A) Si la especie de planta no está clasificada.
                if (!plantasClasificadas.containsKey(planta1))
                    //Añado la planta como clave del diccionario y asigno una lista de enteros vacía
                    plantasClasificadas.put(planta1, new ArrayList<>());
                //Añado la posición de la especie de planta con coincidencia
                listaPosiciones = plantasClasificadas.get(planta1);
                listaPosiciones.add(contadorPlantas);
            }
            //2.4º) Incremento el contador de plantas
            contadorPlantas++;            
        }
        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.printf("Contenido inicial de la lista especies de plantas 1: %s\n", listaPlantas1);
        System.out.printf("Contenido inicial de la lista especies de plantas 2: %s\n\n", listaPlantas2);
        System.out.printf("Clasificación de coincidencias: %s\n",plantasClasificadas);

    }
}