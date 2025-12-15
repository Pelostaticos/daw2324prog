/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea02;

/**
 *
 * @author contacto@bitgarcia.es
 */
import java.util.Scanner;

public class Ejercicio02 {

    public enum Bebidas {
        COCACOLA, PEPSI, AGUA, ZUMO, OTRO
    };

    public static void main(String[] args) {

         //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Variables de entrada 
        int opcion;
        float precio = 0;
        boolean cancelarCompra = false;
        
        // Variables de salida
        float importeInsertado;
        float importeDevuelto;
        
        // Clase Scanner para petición de datos al usuario a través del teclado        
        Scanner teclado = new Scanner(System.in);
        Bebidas miBebida = null;
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 2: Máquina expendedora de Bebidas");
        System.out.println("----------------------------------------------------");      

        // Bloque 1: Sacamos por pantalla el menú de opciones y pedimos que introduzca una.
        //  En caso de introducir una opción inválida, debemos indicarlo y volver a pedirla.
        do {
            // Muestro por pantalla las opciones del menú
            System.out.println();
            System.out.println("Bienvenido a la Máqina Expendedora de Bebidas");
            System.out.println("Seleccione un bebida:");          
            System.out.println("1. COCACOLA - 1.50€");
            System.out.println("2. PEPSI - 1.50€");
            System.out.println("3. AGUA - 1.00€");
            System.out.println("4. ZUMO de naranja - 2.00€");
            System.out.println("0. Salir");
            System.out.println();            
            
            // Solicito al usuario la opción del menú que desea
            System.out.println("Seleccione una opción:");
            opcion = teclado.nextInt();
            
            // Proceso la información elegida por el usuario del menú
            switch (opcion) {
                case 0:
                    cancelarCompra = true;
                    break;
                case 1:
                    miBebida = Bebidas.COCACOLA;
                    precio = 1.50f;
                    break;
                case 2:
                    miBebida = Bebidas.PEPSI;
                    precio = 1.50f;
                    break;
                case 3:
                    miBebida = Bebidas.AGUA;
                    precio = 1.00f;
                    break;
                case 4:
                    miBebida = Bebidas.ZUMO;
                    precio = 2.00f;
                    break;
                default:
                    System.out.println("Opción no válida. Seleccione una bebida válida.");
            }       
            
        } while (opcion < 0 || opcion > 4);
        
        //----------------------------------------------
        //  Procesamiento y  Salida de resultados 
        //----------------------------------------------
        
        // Cuando haya introducido una opción válida, llevamos a cabo la acción oportuna
        //  -Si nos indica 'Salir', nos despedimos y terminamos
        //  -Si nos indica un producto
        //      -Decimos el producto seleccionado y su precio
        //      -Pedimos que introduzca el importe
        //          -Si el importe es suficiente
        //             -Imprimimos el producto obtenido (Equivale a la orden de suministrar el producto
        //             -Decimos el importe que ha sobrado
        //          -Si no, indicamos que el importe es insuficiente 

        // Si se canceló la compra se procede a generar el mensaje de despedida
        if (cancelarCompra) {
            System.out.println("Gracias por usar la Máquina expendedora. ¡Hasta luego!");
        } else {
            // Muestro por pantalla la información de productos elegido por el usuario
            System.out.printf("Ha seleccionado una %s. El precio es %.2f\n", miBebida, precio);
            
            // Solicito al usuario que inserte el dinero para pagar
            System.out.println("Ingrese la cantidad de dinero en euros: ");
            importeInsertado = teclado.nextFloat();
            
            // Válido si la cantidad de dinero insertada es correcta
            if (importeInsertado > precio) {
                // El importe es correcto calculo el cambio a devolver al usuario
                importeDevuelto = importeInsertado - precio;
                // Muestro el mensaje informando al usuario del cambio a devolver.
                System.out.printf("Compra exitosa. Su cambio es: %.2f\n", importeDevuelto);
                // Le digo al usuario que disfrute de su bebida
                System.out.printf("Disfrute de su %s!\n", miBebida);
            } else 
                // El importe es insuficiente entonces informo al usuario que se le devolverá su dinero.
                System.out.println("Dinero insuficiente. Su dinero será devuelto.");
        }

        //----------------------------------------------
        //             Salida de resultados 
        //----------------------------------------------
        //  Se produce durante el proceso
    }
}

