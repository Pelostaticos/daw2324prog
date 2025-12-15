package tarea07;

//Importo las librerías necesarias para el programa
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Ejercicio 5. Ordenación de especies de plantas (por nombre y longitud)
 *
 * @author Sergio García Butrón <contacto@bitgarcia.es>sor
 */

// Creo la clase que implementa la interfaz Comparator para ordenar por nombres
class ComparadorDeNombres implements Comparator<String> {

    @Override
    public int compare(String cadena1, String cadena2) {
        return cadena1.compareTo(cadena2);
    }
}

//Creo la clase que implemnta la interfaz Comparator para ordenar por longuitudes
class ComparadorDeLongitudes implements Comparator<String> {

    @Override
    public int compare(String cadena1, String cadena2) {
        return cadena1.length() - cadena2.length();
    }
}

public class Ejercicio05 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int CANTIDAD_ESPECIES_PLANTAS = 5;
        final int NO_PRESENTE = -1;

        // Variables de entrada
        ArrayList<String> listaEspeciesPlantas = new ArrayList<>();

        // Variables auxiliares
        String planta;
        int posicionPlantaRepetida;
        int contadorPlantas = 0;

        // Variables de salida
        ArrayList<String> listaOrdenadaPlantas;

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("ORDENACIÓN DE ESPECIES DE PLANTAS");
        System.out.println("---------------------------------");

        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_ESPECIES_PLANTAS
        while (contadorPlantas < CANTIDAD_ESPECIES_PLANTAS) {
            planta = Utilidades.especiePlantaAleatoria();
            posicionPlantaRepetida = listaEspeciesPlantas.lastIndexOf(planta);
            if (posicionPlantaRepetida == NO_PRESENTE) {
                listaEspeciesPlantas.add(planta);
                contadorPlantas++;
            }
        }

        //----------------------------------------------
        //     Procesamiento + Salida de resultados
        //----------------------------------------------
        //Muestrro el listado de plantas original
        System.out.println("\nContenido inicial de la lista:\n");
        contadorPlantas = 0;
        for (String plantaLista : listaEspeciesPlantas) {
            contadorPlantas++;
            System.out.printf("%d. %s\n", contadorPlantas, plantaLista);
        }

        //Muestro el listado de especies de plantas ordenadas por nombre
        System.out.println("\nContenido de la list ordenada por nombre (alfabético):\n");
        listaOrdenadaPlantas = new ArrayList<>(listaEspeciesPlantas);
        Collections.sort(listaOrdenadaPlantas, new ComparadorDeNombres());
        contadorPlantas = 0;
        for (String plantaLista : listaOrdenadaPlantas) {
            contadorPlantas++;
            System.out.printf("%d. %s\n", contadorPlantas, plantaLista);
        }

        //Muestro el listado de especies de plantas ordenadas por longitud
        System.out.println("\nContenido de la list ordenada por longitud:\n");
        listaOrdenadaPlantas = new ArrayList<>(listaEspeciesPlantas);
        Collections.sort(listaOrdenadaPlantas, new ComparadorDeLongitudes());
        contadorPlantas = 0;
        for (String plantaLista : listaOrdenadaPlantas) {
            contadorPlantas++;
            System.out.printf("%d. %s\n", contadorPlantas, plantaLista);
        }

    }
}
