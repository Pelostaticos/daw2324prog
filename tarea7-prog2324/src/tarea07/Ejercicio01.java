package tarea07;

//Librerias importandas necesarias para el programa
import java.util.LinkedHashSet;

/**
 * Ejercicio 1. Creando jardín botánico
 * @author Sergio García Butrón <contacto@bitgarcia.es>sor
 */
public class Ejercicio01 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
        final int NUMERO_CONJUNTOS=2;
        final int CANTIDAD_ESPECIES_PLANTAS = 5;       
        
        // Variables de entrada
        /*Los conjuntos (Set) no admiten dupliacdos, pero el LinkedHashSet permite mostrar
        cuando se liste su cointenido, las plantas en el orden que se han insertado */
        LinkedHashSet<String> conjuntoPlantasC1 = new LinkedHashSet<>();
        LinkedHashSet<String> conjuntoPlantasC2 = new LinkedHashSet<>();
        
        // Variables auxiliares
        boolean plantaAgregada;
        int contadorLista=0;
        int contadorPlantas=0;
        
        // Variables de salida
        LinkedHashSet<String> unionConjuntos;
        LinkedHashSet<String> interseccionConjuntos;
        LinkedHashSet<String> diferenciaConjuntos;
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        // No hay, pues se usa un número fijo de elementos aleatorios
        
        System.out.println("CONJUNTOS DE ESPECIES DE PLANTAS");
        System.out.println("--------------------------------");        

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        // Rellenamos los conjuntos con especies de plantas aleatorias hasta que haya CANTIDAD_ESPECIES_PLANTAS
        while (contadorLista < NUMERO_CONJUNTOS) {
            //Selecciono el conjunto de plantas a rellenar
            switch (contadorLista) {
                case 0:     //Relleno el primer conjunto con plantas aleatorias
                    plantaAgregada = conjuntoPlantasC1.add(Utilidades.especiePlantaAleatoria());
                    break;
                default:    //Por defecto relleno el último conjunto con plantas aleatorias
                    plantaAgregada = conjuntoPlantasC2.add(Utilidades.especiePlantaAleatoria());
            }
            //Compruebo si el conjunto actual se completó
            if (contadorPlantas < CANTIDAD_ESPECIES_PLANTAS)
                //Incremento el contador de plantas añadidas al conjunto actual cuando se agregue una planta
                contadorPlantas += plantaAgregada ? 1 : 0;
            else {
                contadorPlantas=0;  //Reinicio el contador de plantas
                contadorLista++;    //Cambio de lista a rellenar
            }
                
        }

        // Unión de los dos conjuntos 
        unionConjuntos =  new LinkedHashSet<>(conjuntoPlantasC1);
        unionConjuntos.addAll(conjuntoPlantasC2);
        
        // Intersección de los conjuntos
        interseccionConjuntos = new LinkedHashSet<>(conjuntoPlantasC1);
        interseccionConjuntos  .retainAll(conjuntoPlantasC2);
        
        // Diferencia de los conjuntos
        diferenciaConjuntos = new LinkedHashSet<>(conjuntoPlantasC2);
        diferenciaConjuntos.removeAll(conjuntoPlantasC1);
        
        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        
        // Recorremos el conjunto y mostramos su contenido por pantalla
        System.out.printf("Conjunto C1: %s\n",conjuntoPlantasC1.toString());
        System.out.printf("Conjunto C2: %s\n",conjuntoPlantasC2.toString());
        System.out.printf("Unión C1 y C2: %s\n", unionConjuntos.toString());
        System.out.printf("Intersección C1 y C2: %s\n",interseccionConjuntos.toString());
        System.out.printf("Diferencia C2-C1: %s\n",diferenciaConjuntos.toString());
    }
}