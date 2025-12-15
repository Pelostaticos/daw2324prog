/**
 * Ejercicio 1: cálculo del volumen de un cilindro.
 * 
 * Realiza un programa Java que permita la introducción de dos números reales. 
 * Estos números representarán el radio de la circunferencia y la altura del 
 * cilindro. Una vez introducidos los números por teclado, el programa calculará 
 * el volumen de dicho cilindro siguiendo la fórmula indicada y escribirá por 
 * pantalla el resultado (debes mostrar el resultado presentando únicamente 
 * dos decimales).
 * 
 * Volumen Cilindro = PI X radio^2 X altura
 * 
 * Recuerda que, aparte del código que resuelva cada uno de los ejercicios 
 * propuestos en esta tarea, debes incluir también los comentarios mínimos 
 * necesarios para que otra persona que analice el código pueda seguirlo con 
 * facilidad. Recuerda que se trata de un recurso fundamental para mejorar 
 * la legibilidad de tu código.

IMPORTANTE: No debes utilizar métodos, estructuras o constantes predefinidas que
* NO se hayan visto aún en los contenidos de la Unidad 1 (más adelante sí podremo
* s utilizarlos, pero en esta unidad no está permitido). Puedes definir PI como 
* una constante con el valor 3,1415927.

Nota: Por ahora no controlaremos que los valores introducidos tengan que ser 
* positivos o no (los valores negativos en nuestro ejemplo no tendrían sentido).
* Más adelante veremos cómo poder controlar estas cosas.

Ten en cuenta que debes mostrar las cantidades decimales de forma que muestren 
* únicamente 2 decimales. Para ello, puedes hacer uso del método printf, aunque 
* no se haya visto en esta unidad (busca información en internet sobre cómo hacerlo).

 * 
 * @author Sergio Garcia Butron <contacto@bitgarcia.es>
 */

package tarea01;

import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        final double PI = 3.1415927;

        // Variables de entrada
        double radioCilindro;
        double alturaCilindro;
        
        // Variables de salida
        double volumenCilindro;

        // Variables auxiliares

        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 1: Volúmen de un cilindro ");
        System.out.println("------------------------------------");
        System.out.println(" ");

        // Muestro mensaje que solicita al usuario que introduzca el valor del radio del cilindro.
        System.out.print("Inserte el radio de cilindro: ");
        
        // Leo del teclado el radio del cilindro introducido por el usuario
        radioCilindro = teclado.nextDouble();
        
        // Muestro mensaje que solicita al usuario la altura del cilindro. 
        System.out.print("Inserte el altura de cilindro: ");
  
        // Leo del teclado la altura del cilindro introducido por el usuario
        alturaCilindro = teclado.nextDouble();
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        // Calculo el volumen del cilindro con el radio y la altura dada por el usuario
        volumenCilindro = PI * radioCilindro * radioCilindro * alturaCilindro;
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.printf("El volumen de un cilindero de radio %.2f y altura %.2f es: %.2f\n", radioCilindro, alturaCilindro, volumenCilindro);
        
        
        System.out.println ();
        System.out.println ("Fin del programa.");        
    }
    
}
