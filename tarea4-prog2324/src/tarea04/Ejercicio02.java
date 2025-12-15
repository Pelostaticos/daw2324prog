
package tarea04;

import java.util.Random;
import java.util.Scanner;

/**
 * Tarea Online 4. Ejercicio 2: Campo de regalos
 * @author Sergio García Butrñon
 * @version 1.0
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        final int DIMENSION_TABLERO_JUEGO = 6;          //Número de casilla del tablero de juego cuadrado
        final int RANGO_VALORES_ALEATORIOS = 100;       //Valor máximo del numero aleatrorio a generar sobre 100 para tener 200
        
        // DEFINICIÓN DE VARIABLES
        // Variable que contiene un objeto tipo Random para generar valores aleatorios
        Random valorAleatorio;

        // Matriz de enteros para gestionar la partida de juego
        int[][] tableroJuego;                
      
        // Variable para almacenar la fila y columna actuales en el juego
        int filaActual, columnaActual;
        
        // Variable para almacenar el valor de la bolsa de premios conseguidos
        int bolsaPremios=0;
        
        // Variable auxiliar para controlar si la parida ha llegado a su fin
        boolean finPartida;
        
        //Variable auxiliar para almacenar el mapa del tablero d ejuego
        String mapaJuego;
        
        //Variable auxiliar para almacenar expresión regular con las direcciones posibles
        String direccionesPosibles;
        
        //Variable auxiliar para almacenar la direccion de avance en el juego elegida.
        String direccionAvance;
        
        //Variable auxiliar para controlar si la dirección de avance deseada es correcta
        boolean avanceIncorrecto;

        // Variable que contiene un objeto tipo Scanner para gestionar la entrada de datos
        Scanner teclado = new Scanner(System.in);        
     

        /* ************************************************************************
         * PROCESAMIENTO
         * ***********************************************************************/
        
        /*
         0. Presentación del autor y del programa (apartado añadido por mi)
         Creo un mensaje que me identifique como autor de programas y exponga un
         titulo de la actividad solicitada
        */
        System.out.println("JUEGO CAMPO DE REGALOS");
        System.out.println("======================");
        System.out.println("Autor: Sergio García Butrón\n");
        
        /* 
         1. Creación de la Matriz
         Creamos una matriz bidimensional de 6x6 que será nuestro mapa, donde
         iremos recorriendo entre los premios
        */
        tableroJuego = new int[DIMENSION_TABLERO_JUEGO][DIMENSION_TABLERO_JUEGO];       
        
         /* 
           2. Generación de Premios 
           Se generan números aleatorios entre 100 y 200, que se asignarán a cada una
           una de las casillas, un premio aleatorio para cada casilla. Debemos recorrer
           la matriz y asignar los premios.
         */
         // Creo el objeto para crear valores númericos aleatorios.
         valorAleatorio = new Random();
         
         // Bucle for para recorrer la filas del tablero de juego.
         for (int fila=0;fila<DIMENSION_TABLERO_JUEGO;fila++) {
             // Bucle for para recorrer las columnas del tablero de juego.
             for (int columna = 0;columna<DIMENSION_TABLERO_JUEGO;columna++) {
                 tableroJuego[fila][columna] = 100 + valorAleatorio.nextInt(RANGO_VALORES_ALEATORIOS + 1);
             }
         }

         /* 
           3. Asignación de CEROS
           A partir de la segunda fila, elegimos aleatoriamente una posición entre 0 y 
            el número de columnas de cada fila. En esa posición para cada fila, 
           sobreescribimos el valor existente y asignamos un cero
         */
         for (int fila=1;fila<DIMENSION_TABLERO_JUEGO;fila++) {
             tableroJuego[fila][valorAleatorio.nextInt(DIMENSION_TABLERO_JUEGO)] = 0;
         }

        /*
         4.1 Elección de columna de partida en la primera fila.
         Al igual que antes elegimos una posición aleatoria entre 0 y 
         el número de columnas de esa primera fila.
        */
        filaActual=0;
        columnaActual=valorAleatorio.nextInt(DIMENSION_TABLERO_JUEGO);        
                
        /*
         4.2 Sumar el premio existente en la casilla elegida a la bolsa de premios
        */
        bolsaPremios += tableroJuego[filaActual][columnaActual];
        
        /*
         4.3 Cambiamos el valor de la casilla elegida "3", para posteriormente 
        poder mostrar una "A" en dicha casilla
        */
        tableroJuego[filaActual][columnaActual] = 3;        
        
        /* 5. Para realizar la  jugada mostraremos el mapa, así como la posición en la que se encuentra (fila y columna). 
           Posteriormente, se muestra al usuario los posibles movimientos que puede realizar
                - Si se está en la primera columna (0), evidemente sólo se podrá ir de frente o a la derecha
                - Si se está en la úlitma columna (longitud-1), evidemente sólo se podrá ir de frente o a la izquierda
                - Si se está en una columna intermedia, se podrá avanzar a cualquiera de las tres posiciones (frente, derecha o izquierda)
           Se pregunta al usuario la dirección de su avance en función de sus posibilidades.
           Si el desplazamiento introducido no es correcto se volverá a repetir la solicitud de dirección           
         */
        do {                        
                                   
            /*
             5.1 Mostrar el mapa actualmente
             Para recorrer el mapa por filas, se irá descubiendo cada una de las casillas
             El valor mostrado dependerá de si la casilla está descubierta o no, 
             presentando dos posibles casos, 
             - si la fila de la casilla es menor o igual a la que estamos mostraremos 
               la información según los cógigos establecidos en el enunciado.
             - Si la fila de la casilla es mayor a que estamos actualmente, mostraremos una "X"
             
            */
            //Inicializo el contenido del mapa actual del juego
            mapaJuego = "";
            // Titulo cabecera del mapa actual del juego
            System.out.println();
            System.out.println("Mapa ACTUAL:");
            // Pareja de bucles for anidados para recorrer el tablero y dibujarlo en pantalla
            for (int fila=0;fila<DIMENSION_TABLERO_JUEGO;fila++) {
                for (int columna = 0;columna<DIMENSION_TABLERO_JUEGO;columna++) {
                    if (fila <= filaActual) {
                        switch (tableroJuego[fila][columna]) {
                            case 0:
                                //Esta figura indica un "CERO NO DESCUBIERTO"
                                mapaJuego += " C \t";
                                break;
                            case 1:
                                //Esta figura indica "CERO DESCUBIERTO"
                                mapaJuego += " B \t";
                                break;
                            case 2:
                                //Esta figura muestra las casillas descubiertas
                                mapaJuego += " I \t";
                                break;
                            case 3:
                                //Esta figura muestra que estamos en una casilla sin CERO.
                                mapaJuego += " A \t";
                                break;
                            default:
                                //Muestro el valor del premio de esta casilla
                                mapaJuego += tableroJuego[fila][columna];
                                //Añado un tabulador para ajustar texto a la pantalla
                                mapaJuego += "\t";
                        }
                    } else {
                        //Muestro la figura "X" para indicar casillas que no hemos pasado aún
                        mapaJuego += " X \t";
                    }
                }
                //Agrego un carácter de nueva linea para genrar una nueva fila del mapa de juego
                mapaJuego += "\n";
            }
            // Muestro por pantalla el mapa de juego generado
            System.out.println(mapaJuego);            

            /* 5.2 Se muestra el premio actual */
            System.out.printf("Tu premio actual es de: %d\n", bolsaPremios);
            
            /* 5.3 Se muestra la fila y columnas actuales*/
            System.out.printf("Te encuentras en la fila %d y en la posicion %d\n",filaActual+1,columnaActual+1);
            
            /* 5.4 Se genera un bucle para validar la entrada y elegir un valor 
               correcto, entre IZQUIERDA, DERECHA  o FRENTE. Sólo se mostrarán los 
               posibles movimientos en función de las posibilidades*/
            do {
            
                /* 5.4.1 Mostramos las posibilidades según la posición horizontal
                    *  - Si se está en la primera columna (0), evidentemente sólo se podrá ir de frente o a la derecha
                    *  - Si se está en la últi  ma columna (longitud-1), evidentemente sólo se podrá ir de frente o a la izquierda
                    *  - Si se está en una columna intermedia, se podrá avanzar a cualquiera de las tres direcciones (frente, derecha o izquierda)
                 */
                // Muestro por pantalla el mensaje que le solicita al usuario la dirección de avance en el juego
                System.out.println("Elige posición en la que avanzar");
                // Compruebo la posición para mostrar las posibles direcciones de avance
                if (columnaActual == 0) {
                    //Muestro por pantalla que las direcciones posibles de avance son: FRENTE o DERECHA
                    System.out.println("Puedes avanzar de frente o hacia la derecha (FRENTE o DERECHA)");
                    //Inicializo expresion regular para comprobar validez de la dirección elegida
                    direccionesPosibles = "frente|derecha";
                } else if (columnaActual > 0 && columnaActual < tableroJuego[filaActual].length - 1) {
                    //Muestro por pantalla que las direcciones posibles de avance son: IZQUIERDA, FRENTE o DERECHA
                    System.out.println("Puedes avanzar hacia la izquierda, de frente o hacia la derecha (IZQUIERDA, FRENTE o DERECHA)");
                    //Inicializo expresion regular para comprobar validez de la dirección elegida
                    direccionesPosibles = "izquierda|frente|derecha";                    
                } else {
                    //Muestro por pantalla que las direcciones posibles de avance son: IZQUIERDA o FRENTE
                    System.out.println("Puedes avanzar hacia la izquierda o de frente (IZQUIERDA o FRENTE)");
                    //Inicializo expresion regular para comprobar validez de la dirección elegida
                    direccionesPosibles = "izquierda|frente";                    
                }
                

                /* 5.4.2 Leemos los valores de teclado. Para simplificar errores, 
                   hacemos que la entrada NO sea case sensitive 
                */
                direccionAvance = teclado.nextLine().toLowerCase();
                
                /* 5.4.3 El bucle sólo debe salir si la opción elegida es correcta 
                   en función de la posición
                 */
                avanceIncorrecto = direccionAvance.matches(direccionesPosibles);
                
            } while (!avanceIncorrecto);
          
                
            /* 5.5 Según la elección de desplazamiento, nos posicionamos en 
               casilla correspondiente */

            switch (direccionAvance) {
            
                /*  5.5.1 Si se ha elegido la dirección izquierda, las fila del 
                   mapa se avanza, pero la columna se decrementa en una unidad para
                   desplazarnos hacia nuestra izquierda. 
                   Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
                */
                case "izquierda":
                    // Compruebo si la casilla a visitar es un cero
                    if (tableroJuego[filaActual+1][columnaActual-1] == 0) {
                        //Reinicio la bolsa de premios
                        bolsaPremios = 0;
                        //Modifico la casilla de visita para mostrar una "B".
                        tableroJuego[filaActual+1][columnaActual-1] = 1;
                    } else {
                        //Acumulo el premio encontrado en nuestra bolsa de premios
                        bolsaPremios += tableroJuego[filaActual+1][columnaActual-1];
                        //Modifico la casilla actual para mostrar una "I".
                        tableroJuego[filaActual][columnaActual] = 2;
                        //cambio de casilla en avance a la izquierda
                        columnaActual--;
                        //Modifico la casilla de visita para mostrar una "A".
                        tableroJuego[filaActual+1][columnaActual] = 3;
                    }
                    
                    
                    break;
                                                                               
                /* 5.5.2 Si se ha elegido la dirección derecha, las fila del mapa se avanza,
                   pero la columna se incrementa en una unidad para desplazarnos hacia 
                   nuestra derecha. 
                   Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
                 */
                case "derecha":
                    // Compruebo si la casilla a visitar es un cero
                    if (tableroJuego[filaActual+1][columnaActual+1] == 0) {
                        //Reinicio la bolsa de premios
                        bolsaPremios = 0;
                        //Modifico la casilla de visita para mostrar una "B".
                        tableroJuego[filaActual+1][columnaActual+1] = 1;
                    } else {
                        //Acumulo el premio encontrado en nuestra bolsa de premios
                        bolsaPremios += tableroJuego[filaActual+1][columnaActual+1];
                        //Modifico la casilla actual para mostrar una "I".
                        tableroJuego[filaActual][columnaActual] = 2;
                        //cambio de casilla en avance a la izquierda
                        columnaActual++;
                        //Modifico la casilla de visita para mostrar una "A".
                        tableroJuego[filaActual+1][columnaActual] = 3;
                    }
                    
                    break;
                                                                
                /*  5.5.3 En cualquier otro caso se avanza de frente, con lo que la
                    fila se incrementa en una unidad, pero la columna se mantiene igual. 
                    Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
                 */
                default:
                    // Compruebo si la casilla a visitar es un cero
                    if (tableroJuego[filaActual+1][columnaActual] == 0) {
                        //Reinicio la bolsa de premios
                        bolsaPremios = 0;
                        //Modifico la casilla de visita para mostrar una "B".
                        tableroJuego[filaActual+1][columnaActual] = 1;
                    } else {
                        //Acumulo el premio encontrado en nuestra bolsa de premios
                        bolsaPremios += tableroJuego[filaActual+1][columnaActual];
                        //Modifico la casilla actual para mostrar una "I".
                        tableroJuego[filaActual][columnaActual] = 2;
                        //Modifico la casilla de visita para mostrar una "A".
                        tableroJuego[filaActual+1][columnaActual] = 3;
                    }
                    
            }                
                
            /* 5.5.4 Incrementamos la fila"*/ 
            filaActual++;
            
            /*
                Se comprueba si la nueva posición obtenida permite seguir jugado o no,
                así como si hemos llegado a la fila final del trayecto.
                Si permite seguir se repetirá el bucle. Sino, saldremos del bucle.
             */
            //A) La partida termina si la casilla de visita es cero y nuestra bolsa de premios es Cero.
            finPartida = (bolsaPremios == 0);                        
            //B) La partida tambien termina cuando la filaActual ha llegado a la última fila del tablero de juego
            finPartida = finPartida || (filaActual == tableroJuego.length - 1);

        } while (!finPartida);            
            
        /* 6. Si se ha llegado a la fila final sin problemas, habremos ganado, 
          en caso contrario se habrá perdido     
         */
        System.out.println();
        if (filaActual >= 0 && filaActual < tableroJuego.length - 1)
            /* 6.1 Imprimir mensaje correspondiente de haber perdido */
            System.out.println("Has PERDIDO");
        else             
            /* 6.2 Imprimir mensaje correspondiente de haber ganado */
            System.out.printf("Has ganado %d€\n", bolsaPremios);           

        
        /* 7. Mostrar el mapa FINAL de la PARTIDA */
        System.out.println();
        System.out.println("Mapa al FINAL de la PARTIDA");
        System.out.println(mostrarMapaJuego(filaActual, tableroJuego));
        
    }

    /* 7. BIS. Para mostrar el mapa se puede realizar un método estático para ver 
       el mapa de situación. Para mostrar el mapa vamos generando por filas cada  
       uno de los valores de las columnas. A este método estático se le debería pasar
       el número actual de fila, y el array bidimensional, devolviendo un String
            
     */
   
    static private String mostrarMapaJuego(int filaActual, int[][] tableroJuego) {
        // Defino las variables locales al método estatico para mostrar el mapa de situación del juego
        String mapaJuego="";
        // Pareja de bucles for anidados para recorrer el tablero y dibujarlo en pantalla
        for (int fila=0;fila<tableroJuego.length;fila++) {
            for (int columna = 0;columna<tableroJuego.length;columna++) {
                if (fila <= filaActual) {
                    switch (tableroJuego[fila][columna]) {
                        case 0:
                            //Esta figura indica un "CERO NO DESCUBIERTO"
                            mapaJuego += " C \t";
                            break;
                            case 1:
                                //Esta figura indica "CERO DESCUBIERTO"
                                mapaJuego += " B \t";
                                break;
                            case 2:
                                //Esta figura muestra las casillas descubiertas
                                mapaJuego += " I \t";
                                break;
                            case 3:
                                //Esta figura muestra que estamos en una casilla sin CERO.
                                mapaJuego += " A \t";
                                break;
                            default:
                                //Muestro el valor del premio de esta casilla
                                mapaJuego += tableroJuego[fila][columna];
                                //Añado un tabulador para ajustar texto a la pantalla
                                mapaJuego += "\t";
                        }
                    } else {
                        //Muestro la figura "X" para indicar casillas que no hemos pasado aún
                        mapaJuego += " X \t";
                    }
                }
                //Agrego un carácter de nueva linea para genrar una nueva fila del mapa de juego
                mapaJuego += "\n";        
        }
        
        // Devuelvo el mapa de situación
        return mapaJuego;
    }
    
}
