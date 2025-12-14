/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea02;

import java.util.Scanner;

/**
 *
 * @author sergio.garciabutron@gmail.com
 */
public class Ejercicio03 {

    public static void main(String args[]) {
        //----------------------------------------------
        //               Declaración de variables y constantes
        //----------------------------------------------
        
        // Variables de entrada
        int numeroSoldados;
        String formacionSoldados;
        
        // Variables de salida
        String resultado="";
        
        // Variables auxiliares
        Scanner teclado = new Scanner(System.in);               // Lectura de datos por la entrada estandar.
        int soldadosFormados = 0, soldadosSobrantes = 0;             // Cantidad de soldados en la formación elegida y aquellos que sobran de los indicados por el usuario.
        int fila, filas, columna, columnas;                        // Fila, filas, columna y columnas de la formación
        boolean dibujarTriangulo = false;                            // Bandera para controlar el dibujo de una formación en triangulo. Desactivado por defecto
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio03: Formación romana a partir de un número de soldados.");
        System.out.println("----------------------------------------------------------------");

        // Bloque 1. Solicitud del número de soldados
        // Validación de entrada: Deberíamos comprobar que es mayor o igual que uno. En caso contrario volvemos solicitar el número de soldados
        // Se supone que nos introducen un número entero. En caso que no sea así saltará una excepción, cuyo tratamiento veremos en uinidades posteriores

        do {
            
            // Muestro por pantalla el mensaje que le solicita al usurio el número de soldados de la formación
            System.out.println("Inserte el número de soldados de la formación (Debe ser mayor que cero) : ");
            // Leo del teclado el número de soldados deseados por el usuario para la formación
            numeroSoldados = teclado.nextInt();
            
        } while (numeroSoldados <= 0);
        
        // Bloque 2. Solicitud del tipo de formación. 
        // Indicaremos que tiene que ser LINEA, CUADRADO o TRIANGULO
        // Leemos una cadena, puede que no sea una de las anteriores.
        
        // Muestro por pantalla que le solicita al usuario el tipo de formación de los soldados.
        System.out.println("Inserte el tipo de formación deseado: LINEA, CUADRADO o TRIANGULO ");
        // Leo del teclado el tipo de formación deseado por el usuario.
        formacionSoldados = teclado.next();
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Creamos una cadena de texto para ir almacenando el resultado, que sacaremos por pantalla al final
        // Sólo si la entrada ha sido válida simulamos la formación representando cada soldado con un *
        // No olvides que Si al hacer la mayor formación posible del tipo indicado con los soldados introducidos sobran soldados, se debe indicar cuantos."
        // Si el tipo de formación que nos han indicado y que hemos leído como String no coincide con una de las contempladas, indicamos este error almacenando el mensaje oportuno en el String resultado

        // Proceso el tipo de formación de los soldados introducido por el usuario
        switch (formacionSoldados) {
            /* Estudio de los casos para dibujar una formación de LINEA o CUADRADO.
               ¿Cómo calculo el número de filas de la formación?
                       + Linea => filas=1
                       + Cuadrado => filas = raiz_cuadrda(numeroSoldados)
               ¿Qué numero de soldados tengo por cada fila?
                       + Linea => columnas = numeroSoldados
                       + Cuadrado => columnas = filas
               ¿Por qué valor debe empezar fila? 0
               ¿Cuál es el límite de fila? fila < filas
               ¿Qué contienen las columnas? => Sólo incluyen soldados
               ¿Por qué valor debe empezar a priori columna? => 0
               ¿Cuál es el límite de columna? => columna < columnas
               ¿Qué tipo de bucle usaré? For

               Linea; numSoldados=14; Fil=1; Cols=14;
               ==============================================================
               0:>*************

               Cuaddo; numSoldados=14; Fil=entero(raiz_cuadrada(14))=3; Cols=3;
               ==============================================================
               0:>***
               1:>***
               2>:***                        
            */
            case "LINEA":
                // Asigno el número de filas de la formación en LINEA.
                filas = 1;
                // Asigno el número de columnas de la formación.
                columnas = numeroSoldados;
                // Salgo del bloque switch al finalizar el caso de formación en LINEA.
                break;
            case "CUADRADO":
                // Asigno el número de filas de la formación en CUADRADO.
                filas = (int) Math.sqrt(numeroSoldados);
                // Asigno el número de columnas de la formación que debe ser igual al número de filas.
                columnas = filas;
                // Salgo del bloque switch al finalizar el caso de formación en CUADRADO.                
                break;
                
            /* Estudio de los casos para dibujar una formación de TRIÁNGULO.  
               ========================================================================================================================================
           
             ¿Cómo calculo el número de filas de la formación? => filas = ((Math.sqrt(1 + 8 * numSoldados) - 1) / 2)            
             ¿Qué número de soldados para la primera fila? => el mismo que filas
             ¿Cómo calculo el número de soldados por fila? => numero_soldados_fila = (filas - fila) [SF]
                    + soldados@fila1 = filas - 0;
                    + soldados@fila2 = filas - 1;
                    + soldados@fila3 = filas - 2;
                    + ...
                    + soldados@fila-n= filas - n; (donde n es el número de fila)
             ¿Por qué valor debe empezar fila? => 0
             ¿Cuál es el límite de fila? => fila < filas ---> Recuerda [0, filas-1] = numero %filas% elementos.
             A priori: ¿Qué contienen las columnas? => soldados si es impar y espacios si es par.
             A priori: ¿Por qué valor debe empezar a priori columna? => 1
             ¿Cuántas columnas tengo que dibujar por cada fila? => 2 * numero_soldados_fila - 1 (CF)
             ¿Cuántos espacios tengo que dejar al inicio de cada fila? => fila (EIF)
             A posteriori: ¿Qué contienen las columnas? => espacios de inicio de fila (EIF) + soldados si es impar y espacios si es par (CF).
             A posteriori: ¿Por qué valor debe empezar a priori columna? => 0
             Número total de elementos a dibujar por cada fila (ETD) = EIF + CF.
             ¿Cómo dibujo por fila cada elemento en su columna?
                    + Si columna tiene un valor en el intervalo [fila, CF) genero la formación de soldados => ¿Cómo la genero?
                            + Si (columna - fila + 1) % 2 = 0 (par) 	=> Añado un espacio.
                            + Si no se cumple lo anterior (impar) 	=> Añado un soldado.
                    + Si columna tiene un valor en el intervalo [0, fila) añado los espacio de inicio de fila.
             ¿Qué tipo de bucle usaré? For

             Trianggulo; numSoldados=14; Fil=5; Col=5;
             ================================================================================
             0:>* * * * *	EIF=0; SF=(5-0)=5; CF=(2*(5-0))-1 = 9; ETD=9+0=9; (columnas)
             1:> * * * *	EIF=1; SF=(5-1)=4; CF=(2*(5-1))-1 = 7; ETD=7+1=8; (columnas)
             2:>  * * * 	EIF=2; SF=(5-2)=3; CF=(2*(5-2))-1 = 5; ETD=5+2=7; (columnas)
             3:>   * *		EIF=3; SF=(5-3)=2; CF=(2*(5-3))-1 = 3; ETD=3+3=6; (columnas)
             4:>    *		EIF=4; SF=(5-4)=1; CF=(2*(5-4))-1 = 1; ETD=1+4=5; (columnas)

             ¿Qué expresión tengo para calcular por cada fila el número de columnas?

                columnas = EIF + CF = fila + CF = fila + (2 * numero_soldados_fila - 1);
                columnas = fila + ((2 * (filas - fila)) - 1);

             ¿Qué expresión tendría para el resultado de procesar cada columna?

                Resultado += (columna > 0 && columna < fila) ? " " : (columna >= fila && columna < CF) ? ((columna - fila + 1) % 2 == 0) ? " " : "*"  : ""

             ¿Puedo simplificar la expresión anterior? => Sí, pues tanto limite inferior como superior del valor de columna están especificado en el bucle for [0, ETD)
                + Primer supuesto de simplificación: La propia definicion del bucle for para columna garantiza que nunca va a ser negativo.
                + Segundo supuesto de simplificación: La propia definicion del bucle for para columna garantiza que nunca va a ser mayor que ETD
                + Tercer supuesto de simplificación: Entonces si la columna estápor debajo de filas son espacios inicales y si está por encima es el dibujo de la formación.

             ENTONCES: Resultado += (columna < fila) ? " " : ((columna - fila + 1 ) % 2 == 0) ? " " : "*";            
            */                
            case "TRIANGULO":
                 // Asigno el número de filas de la formación en TRIANGULO.
                filas = (int) ((Math.sqrt(1 + 8 * numeroSoldados) - 1) / 2);
                // Inicializo el valor de columnas a cero porque se calcula dinamicamente en el bucle for
                columnas = 0;
                // Acttivo la bandera para dibujar una formación en triangulo
                dibujarTriangulo = true;
                // Salgo del bloque switch al finalizar el caso de formación en TRIANGULO.               
                break;
                
            // Caso por defecto cuando se introduce una formación a dibujar no soportada .
            default:
                // Inicializo a ceros el número de filas y columnas de la formación al ser una formación incorrecta
                filas = 0;
                columnas = 0;
                // Genero el mensaje de error al elegir un tipo de formación no válido
                resultado = "Opción NO CORRECTA";
        }

        // Genero el resultado de la formación deseada por el usuario
        // Si no tengo que dibujar TRIANGULO: Uso un métoodo común para LINEA o CUADRADO.
        if (!dibujarTriangulo) {
            // Bucle for para dibujar las filas de la formación de soldados
            for (fila=0;fila<filas;fila++) {
                // Bucle for para dibujar las columnas de la formación de los soldados
                for (columna=0;columna<columnas;columna++) {
                    // Voy añadiendo soldados a la fila de formación actual.
                    resultado += "*";
                }
                // Añado el simbolo de nueva linua con cada fila nueva de la formación
                resultado += "\n";
            }
            // Calculo de número total de soldados incorporados a la formación                        
            soldadosFormados = filas * columnas;        
        } 
        // De lo contrario, uso el método especifico para la formación en triangulo.
        else {
            // Bucle for para dibujar las filas de una formación en triangulo-
            for (fila=0;fila<filas;fila++) {
                // Calculo dinamicamente el valor de columnas a dibujar por cada fila
                columnas = fila + ((2 * (filas - fila)) - 1);
                // Bucle for para dibujar las columnas de una formación en triangulo
                for (columna=0;columna<columnas;columna++) {
                    // Voy añadiendo un espacio si la columna es par y un soldado si es impar.
                    resultado += (columna < fila) ? " " : ((columna - fila + 1 ) % 2 == 0) ? " " : "*"; 
                }
                // Añado el simbolo de nueva linua con cada fila nueva de la formaxción
                resultado += "\n";
                // Calculo de número total de soldados incorporados a la formación en trianfgulo.
                soldadosFormados += (filas - fila);
            }
        }

        // Si hay soldados formados y sobran soldados: Añado el mensaje de la cantidad de soldados que sobran
        if (soldadosFormados > 0 && (numeroSoldados - soldadosFormados) > 0) {
            resultado += "\nDe los " + numeroSoldados + " soldados asignados, una vez hecha ";
            resultado += "la mayor formación posible del tipo indicado, ";
            resultado += "sobran " + (numeroSoldados - soldadosFormados) + " soldados.\n";
        }
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println(resultado);
        //----------------------------------------------
    }
}
