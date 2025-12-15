/** Ejercicio 4: gestión de recursos hídricos
 * 
 * Diseña un programa en Java que permita monitorizar el nivel de agua de un 
 * embalse. El embalse tiene una capacidad fija máxima de 2.000 hm3 (hectómetros
 * cúbicos). 
 * 
 * El usuario deberá introducir por el teclado el volumen de agua embalsada en 
 * un momento determinado. A partir de esa cantidad, el programa calculará la 
 * cantidad de hectómetros cúbicos de agua que son necesarios para que el 
 * embalse se llene completamente. Igualmente, se calculará el porcentaje que 
 * corresponde la cantidad de agua embalsada respecto a la capacidad total del 
 * embalse.
 * 
 * Si el porcentaje actual de agua embalsada es superior al 95% de la capacidad 
 * total del embalse se realizará una liberación controlada de agua de un 10% d
 * el volumen de agua embalsada.
 * 
 * En este caso, se debe informar al usuario del porcentaje de liberación que se
 * ha realizado, de cuántos hectómetros cúbicos se han vaciado en esa operación, 
 * cual es el volumen actual del depósito, y cuál es el porcentaje actual. 
 * 
 * Por contra, si el porcentaje actual del embalse es inferior al 95% no se 
 * realizará ningún tipo de liberación. En este caso simplemente se mostrará el 
 * mensaje "No es necesario considerar la liberación controlada de agua en este 
 * momento."
 * 
 * IMPORTANTE: Recuerda que el uso de métodos o estructuras que NO se han visto 
 * aún en los contenidos de la Unidad 1 está prohibido (más adelante sí podremos 
 * utilizarlos, pero en esta unidad no está permitido ya que, en esta limitación, 
 * se encuentra parte de la dificultad del ejercicio).
 * 
 * Recomendación: Una vez se realice la evaluación del operador ternario para la
 * distinción de los posibles casos que se plantean en el problema te recomendamos 
 * guardar el mensaje que vaya a salir por pantalla, en una variable de tipo cadena
 * , en lugar de mostrarla directamente. Una vez terminados todos los posibles 
 * casos se presentará por pantalla dicha cadena resultado.
 * 
 * Nota: No es necesario que controles valores incoherentes (volumen actual n
 * egativo o superior a la capacidad máxima del embalse). En las próximas unidades 
 * dispondremos de más herramientas para controlar estas situaciones.
 *
 * @author Sergio Garcia Butron <contacto@bitgarcia.es>
 */

package tarea01;

import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class Ejercicio04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        final int CAPACIDAD_MAXIMA_EMBALSE = 2000;

        // Variables de entrada
        int aguaEmbalsada;
        
        // Variables de salida
        double aguaFaltaLlenarEmbalse;
        double porcentajeAguaEmbalsada;
        double aguaLiberada;

        // Variables auxiliares
        boolean liberarEmbalse;
        String mensajeEstadoEmbalse;
        String mensajeLiberacionEmbalse;
        

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 4: gestión de recursos hídricos ");
        System.out.println("------------------------------------------");
        System.out.println(" ");
        
        // Muestro el mensaje que le solicita al usuario la cantidad de agua almacenada actualmente en el embalse
        System.out.println("Inserte el volumen actual de agua almacenada en el embalse (hectómetros cúbicos): ");

        // Leo del teclado el volumeen de agua almacenada que el usuario ha introducido
        aguaEmbalsada = teclado.nextInt();
        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 1º) Calculo la cantidad de agua que le falta al embalse para llenarse complentamente
        aguaFaltaLlenarEmbalse = CAPACIDAD_MAXIMA_EMBALSE - aguaEmbalsada;
        
        // 2º)) Calcculo el porcentaje de agua embalsada
        porcentajeAguaEmbalsada =  ((double) aguaEmbalsada / (double) CAPACIDAD_MAXIMA_EMBALSE) * 100.0;
        
        // 3º) Genero el mensaje que informa del estado actual del embalse al usuario
        mensajeEstadoEmbalse = String.format("Faltan %.2f hectómetros cúbicos para llenar el embalse\n", aguaFaltaLlenarEmbalse);
        mensajeEstadoEmbalse = mensajeEstadoEmbalse + String.format("El embalse está a un %.2f", porcentajeAguaEmbalsada) + "% de su capacidad máxima\n";

        // Compruebo si es necesario liberar agua del embalse
        liberarEmbalse = porcentajeAguaEmbalsada > 95.0;
        
        // 4º) Calculo volumen de agua a liberar contrladamente del embalse
        aguaLiberada = 0.10 * (double) aguaEmbalsada;
        
        // 5º) Calcculo el porcentaje de agua embalsada tras liberación controlada del embalse
        porcentajeAguaEmbalsada = (((double) aguaEmbalsada - aguaLiberada) / (double) CAPACIDAD_MAXIMA_EMBALSE) * 100.0;
        
        // 6º) Genero el mensaje que informa acerca de la libreación controlada de agua del embalse
        mensajeLiberacionEmbalse = "Se ha realizado una liberacion del 10% " + String.format("vaciando un total de %.2f hectómetros cúbicos.\n", aguaLiberada);
        mensajeLiberacionEmbalse = mensajeLiberacionEmbalse + String.format("En el embalse quedan ahora %.2f que representa está a un %.2f", (aguaEmbalsada - aguaLiberada), porcentajeAguaEmbalsada);
        mensajeLiberacionEmbalse = mensajeLiberacionEmbalse + "% de su capacidad máxima\n";
        mensajeLiberacionEmbalse = liberarEmbalse == true ? mensajeLiberacionEmbalse : "No es necesario considerar la liberación controlada de agua en este momento.";
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println(mensajeEstadoEmbalse);   // Muestro el mensaje con  la información actual del embalse
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println(mensajeLiberacionEmbalse);   // Muestro el mensaje con  la información acerca de la liberación controlada de agua del embalse
        
        System.out.println ();
        System.out.println ("Fin del programa.");      
        
    }
    
}
