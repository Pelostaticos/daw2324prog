/**
 * Ejercicio 2: Operadores aritméticos
 * 
 * Realiza un programa Java que permita la introducción de tres números enteros. 
 * El programa realizará los cálculos necesarios para determinar:
 * un tercio del primer número más la mitad del tercer número.
 * el cuadrado de la mitad de la suma del segundo número más el tercero.
 * si el triple de la suma del segundo más el tercer número menos el primero es par.
 * la suma del primero más el segundo, multiplicado por la diferencia del tercero 
 * menos el primero y todo ello partido por el segundo número.
 * 
 * Para realizar estas comprobaciones dispones de operadores relacionales tales 
 * como igual (==), menor que (<), mayor que (>), etc. Ten en cuenta que el 
 * resultado de la aplicación de operadores relacionales será un valor de tipo 
 * boolean, es decir un valor que será true o false.
 * 
 * Recuerda también que puedes obtener el resto de una división entera entre dos 
 * números utilizando el operador módulo (%). Este operador también te puede a
 * yudar para determinar si un número es divisible entre otro (si el resultado 
 * de la división a%b es igual a 0, significará que a es divisible entre b).
 * 
 * Recomendación:  Recuerda que, en Java, si en una división el numerador y el 
 * denominador son valores enteros el resultado de la operación será otro valor 
 * entero (sin decimales). Así, por ejemplo, la división del valor 7 entre el 
 * valor 2 dará un resultado 3 que corresponde al cociente entero de dicha división. 
 * Si queremos obtener el resultado exacto de la división (con todos sus decimales) 
 * será necesario aplicar operaciones de conversión de tipos. Para obtener más 
 * información consulta el apartado 12 en los contenidos de la Unidad.
 * 
 * Nota: Ten en cuenta que para resolver el ejercicio solo podrás utilizar 
 * operadores que hayamos visto durante esta unidad. No podrás utilizar métodos 
 * de otras clases que aún no hemos visto en los contenidos. En el caso de las 
 * divisiones, no es necesario que tengas en cuenta y controles los errores que 
 * pueden ocurrir al dividir entre 0, símplemente usa otros números (más adelante 
 * nos ocuparemos de eso).
 * 
 * @author Sergio Garcia Butron <sergio.garciabutron@gmail.com>
 */

package tarea01;

import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class Ejercicio02 {

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
        int numeroEntero1;
        int numeroEntero2;
        int numeroEntero3;
        
        // Variables de salida
        float calculo1;
        float calculo2;
        boolean calculo3;
        float calculo4;

        // Variables auxiliares
        

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 2: Cálculos aritméticos ");
        System.out.println("----------------------------------");        
        System.out.println(" ");
        System.out.println("Introduzca tres número enteros: ");
        
        // Muestro mensaje por pantalla para solicitar el primero número entero
        System.out.println("Primer número entero: ");
        // Solicito al usuario que iserte por teclado el primer número entero
        numeroEntero1 = teclado.nextInt();
        
        // Muestro mensaje por pantalla para solicitar el segundo número entero
        System.out.println("Segundo número entero: ");
        // Solicito al usuario que iserte por teclado el segundo número entero
        numeroEntero2 = teclado.nextInt(); 

        // Muestro mensaje por pantalla para solicitar el tercero número entero
        System.out.println("Tercer número entero: ");
        // Solicito al usuario que iserte por teclado el tercer número entero
        numeroEntero3 = teclado.nextInt();
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        // 1º) Un tercio del primer número más la mitad del tercer número.
        calculo1 =  ((float) numeroEntero1 / 3) + ((float) numeroEntero3 /2);
        
        // 2º) El cuadrado de la mitad de la suma del segundo número más el tercero.
        calculo2 = (float) 0.25 * (numeroEntero2 + numeroEntero3) * (numeroEntero2 + numeroEntero3);
        
        // 3º) Si el triple de la suma del segundo más el tercer número menos el primero es par.
        calculo3 = (3 * (numeroEntero1 + numeroEntero2 - numeroEntero3))%2 == 0;
        
        // 4º) La suma del primero más el segundo, multiplicado por la diferencia del tercero menos el primero y todo ello partido por el segundo número
        calculo4 = (float) ((numeroEntero1 + numeroEntero2) * (numeroEntero3 - numeroEntero1)) / numeroEntero2;
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ();
        
        // Muestro por pantalla el resultado de los calculos realizados
        System.out.println("Valor del tercio del primer número más la mitad del segundo número: " + calculo1);
        System.out.println("Valor del cuadrado de la mitad de la suma del segundo número más el tercero: " + calculo2);
        System.out.println("Comprbamos si el triple de la suma del segundo más el tecrer número menos el primero es par: " + calculo3);
        System.out.println("Valor de la suma del primero más el segundo, multiplicado por la diferencia del tercero menos el primero y todo ello partidos por el segundo número: " + calculo4);
        
        System.out.println ();
        System.out.println ("Fin del programa.");
        
    }
    
}
