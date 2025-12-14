/** Ejercicio 3: Palabras circulares
 * Realiza un programa en Java que permita introducir por teclado tres palabras. 
 * Una vez introducidas las palabras, se realizarán las comprobaciones necesarias 
 * para determinar:
 * 
 *      1. Si las dos primeras palabras introducidas tienen menos de 6 caracteres 
 *         o la tercera palabra tiene más de 8 caracteres.
 *      2. Si la segunda palabra es la de mayor longitud de las tres.
 *      3. Si las tres palabras están encadenadas (la última letra de una palabra 
 *         es igual a la primera letra de la palabra siguiente) o no.
 *      4. Si se trata de palabras circulares (palabras encadenadas en la que la 
 *         última letra de la última palabra también coincide con la primera letra 
 *         de la primera palabra) o no.
 * 
 * Observa que las respuestas a cada una de las 4 cuestiones anteriores debe ser 
 * SI o NO (según se cumpla o no la situación descrita en cada apartado). Puedes 
 * conseguir este comportamiento apoyándote en uno de los operadores vistos en 
 * la unidad.
 * 
 * IMPORTANTE: No debes utilizar estructuras de selección (if-else) puesto que 
 * aún no se han tratado en esta Unidad (más adelante sí podremos utilizarlos, 
 * pero en esta unidad no está permitido).
 * 
 * Nota: para la determinación de palabras encadenadas o circulares no tengas en 
 * cuenta si los caracteres están escritos en mayúsculas o minúsculas. Así, por 
 * ejemplo, las palabras Ordenador -> Ratón se considerarían palabras encadenadas 
 * aunque en la primera palabra la 'r' sea minúscula y en la segunda palabra 
 * la 'R' sea mayúscula.
 *
 * @author Sergio Garcia Butron <sergio.garciabutron@gmail.com>
 */

package tarea01;

import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        // NO se precisan

        // Variables de entrada
        String palabra1;
        String palabra2;
        String palabra3;
        
        // Variables de salida
        String comprobacion1;
        String comprobacion2;
        String comprobacion3;
        String comprobacion4;

        // Variables auxiliares
        boolean comprobacionIntermedia;    // Comprobaciones lógicas medias en palabras encadenadas y circulares.

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 3: Palabras circulares ");
        System.out.println("---------------------------------");
        System.out.println(" ");
        System.out.println();
        
        System.out.println("Introduce tres palabras: ");
        
        // Muestro por pantalla mensaje solicitando al usuario la primera palabra
        System.out.println("Primera palabra: ");
        // Leo del teclado la primera palabra introducida por el usuario
        palabra1 = teclado.nextLine();
        
        // Muestro por pantalla mensaje solicitando al usuario la segunda palabra
        System.out.println("Segunda palabra: ");
        // Leo del teclado la segunda palabra introducida por el usuario
        palabra2 = teclado.nextLine();        

        // Muestro por pantalla mensaje solicitando al usuario la tercera palabra
        System.out.println("Tercera palabra: ");
        // Leo del teclado la tercera palabra introducida por el usuario
        palabra3 = teclado.nextLine();        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        // 0º) Convierto todas las palabras a mínusculas para las comprobaciones
        palabra1 = palabra1.toLowerCase();
        palabra2 = palabra2.toLowerCase();
        palabra3 = palabra3.toLowerCase();
        
        // 1º) Si las dos primeras palabras introducidas tienen menos de 6 caracteres o la tercera palabra tiene más de 8 caracteres.
        comprobacion1 = (palabra1.length() < 6 && palabra2.length() < 6) || palabra3.length() > 8 ? "SI" : "NO";
        
        // 2º) Si la segunda palabra es la de mayor longitud de las tres.
        comprobacion2 = palabra2.length() > palabra1.length() && palabra2.length() > palabra3.length() ? "SI" : "NO";
        
        // 3º) Si las tres palabras están encadenadas (la última letra de una palabra es igual a la primera letra de la palabra siguiente) o no.
        comprobacionIntermedia = palabra1.charAt(palabra1.length()-1) == palabra2.charAt(0);
        comprobacion3 = comprobacionIntermedia && (palabra2.charAt(palabra2.length()-1) == palabra3.charAt(0)) ? "SI" : "NO";
        
        // 4º) Si se trata de palabras circulares (palabras encadenadas en la que la última letra de la última palabra también coincide con la primera letra de la primera palabra) o no
        comprobacionIntermedia = palabra1.charAt(palabra1.length()-1) == palabra2.charAt(0);
        comprobacionIntermedia = comprobacionIntermedia && (palabra2.charAt(palabra2.length()-1) == palabra3.charAt(0));
        comprobacion4 = comprobacionIntermedia && (palabra3.charAt(palabra3.length()-1) == palabra1.charAt(0)) ? "SI" : "NO";
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        
        // Muestro por pantalla el resultado de las comprobaciones solicitadas
        System.out.println("La longitud de las dos primeras palabras es menor de 6 o la longitud de la tercera es mayor de 8 caracteres: " + comprobacion1);
        System.out.println("La segunda palabra es la palabra de mayor longitud: " + comprobacion2);
        System.out.println("Las tres palabras introducidas son palabras encadenadas: " + comprobacion3);
        System.out.println("Las tres palabras introducidas son palabras circulares: " + comprobacion4);
        
        System.out.println ();
        System.out.println ("Fin del programa.");       
        
    }
    
}
