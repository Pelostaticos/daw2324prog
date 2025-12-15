/** Ejercicio 5: ¡vamos al parque acuático!
 * 
 * Escribe un programa en Java que permita calcular el importe a pagar por los 
 * clientes del Parque Acuático AquaTrass teniendo en cuenta los siguientes 
 * requisitos: 
 * 
 *  existirán dos tipos de entradas:
 * Infantil con un precio base de 10,00 €
 * Adulto con un precio base de 15,00 €.
 * 
 * en caso de que el coste total de las entradas sea superior a 50,00 € se aplicará 
 * automáticamente un 5% de descuento. Igualmente, si el importe base total es 
 * superior a 100,00 € el descuento será de un 15%.
 * Además, una vez realizados los descuentos pertinentes se deberá aplicar un 
 * IVA del 21% al importe resultante.
 * 
 * El programa solicitará la cantidad de entradas de cada tipo que se desean 
 * comprar, realizará todos los cálculos necesarios y mostrará por pantalla 
 * los siguientes resultados:
 * 
 *  el número de entradas de adulto y de entradas infantiles que comprará el cliente.
 *  el importe total de las entradas antes de aplicar (si procede) el descuento.
 *  el porcentaje de descuento que se aplicará o el texto "No procede descuento 
 *  en esta compra"en caso de que no se cumplan los requisitos para aplicar descuento
 *  el importe total aplicando el descuento (si procede) pero no el IVA.
 *  el importe total de la compra tras aplicar el descuento que corresponda 
 *  y el IVA indicado anteriormente.
 * 
 * Por último, el sistema mostrará la cantidad final que deberá pagar el cliente
 * la cual será la parte entera del importe total calculado anteriormente (por 
 * ejemplo, si el importe total fuera 32,67 € la cantidad final que debería pagar
 * el cliente sería 32 €).
 *
 * Importante: Debes mostrar las cantidades decimales de forma que muestren 
 * únicamente 2 decimales. Para ello, de nuevo, puedes hacer uso del método 
 * printf. Por ahora no controlaremos que la cantidad de entradas introducidas 
 * tenga que ser positiva (aunque una cantidad negativa de entradas en nuestro 
 * ejemplo no tendría sentido). Más adelante veremos cómo poder controlar estas cosas.
 * 
 * Recomendación: Puedes obtener la parte entera de un número realizando una 
 * operación de casting (los métodos matemáticos de redondeo aún no se han e
 * studiado, por lo que no podrán utilizarse para resolver este problema).
 * 
 * @author Sergio Garcia Butron <contacto@bitgarcia.es>
 */
package tarea01;

import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes
        final float ENTRADA_INFANTIL = 10.00f;
        final float ENTRADA_ADULTO = 15.00f;        

        // Variables de entrada
        int numeroEntradasInfantil;
        int numeroEntradasAdulto;
        
        // Variables de salida
        float importeTotalBase;
        float porcentajeDescuento;
        float importeDescuento;
        float importeTotalIva;

        // Variables auxiliares
        String mensajeDescuento;

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 5: ¡vamos al parque acuático!");
        System.out.println("---------------------------------------");
        System.out.println(" ");

        // Muestro por pantalla mensaje solicitando al usuario cantidad entradas adultas
        System.out.println("Inserte cantidad de entradas DE ADULTO que desea adquirir: ");
        
        // Leo del teclado la cantidad de entradas de adulto deseadas por el usuario
        numeroEntradasAdulto = teclado.nextInt();
    
        // Muestro por pantalla mensaje solicitando al usuario cantidad entradas adultas
        System.out.println("Inserte cantidad de entradas INFANTIL que desea adquirir: ");
        
        // Leo del teclado la cantidad de entradas de adulto deseadas por el usuario
        numeroEntradasInfantil= teclado.nextInt();        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 1º) Calculo el importe total de las entradas sin descuentos
        importeTotalBase = (ENTRADA_ADULTO * (float) numeroEntradasAdulto) + (ENTRADA_INFANTIL * (float) numeroEntradasInfantil);  
        
        // 2º) Establezco el porcentaje de descuento aplicable al cliente según el importe total base.
         porcentajeDescuento = importeTotalBase > 50.0 && importeTotalBase <= 100.0 ? 5.0f : (importeTotalBase > 100.0 ? 15.0f : 0.0f);
         
        // 3º) Caclulo el importe del descuento aplicable al cliente
        importeDescuento = (porcentajeDescuento / 100.0f) * importeTotalBase;
        
        // 4º) Genero mensaje informativo acerca del descuento aplicable al cliente
        mensajeDescuento = porcentajeDescuento > 0.0 ? String.format("Se le aplicará un descuento del %.2f", porcentajeDescuento) + "%" : "No procede descuento en esta compra";

        // 5º) Caclulos el importe total a pagar por las entradas con descuentos e IVA incluido.
        importeTotalIva = 1.21f * (importeTotalBase - importeDescuento);
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        
        // Muestro por pantalla los distinos resultados solicitados en el enunciado del problema
        System.out.printf("Se comprarían %d entradas de tipo ADULTO y %d entradas de tipo INFANTIL.\n", numeroEntradasAdulto,numeroEntradasInfantil);
        System.out.printf("El coste de las entradas antes de aplicar descuentos es de %.2f €\n", importeTotalBase);
        System.out.println(mensajeDescuento);
        System.out.printf("Tras aplicar posible descuentos el importe total de las entradas (sin IVA) es de %.2f €\n", importeTotalBase-importeDescuento);
        System.out.printf("El importe IVA incluido es de %.2f €\n", importeTotalIva);
        System.out.printf("La cantidad final a pagar por el cliente es de %d €\n", (int) importeTotalIva);
        
        System.out.println ();
        System.out.println ("Fin del programa.");        

    }
    
}
