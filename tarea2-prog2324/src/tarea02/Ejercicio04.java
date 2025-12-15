/* ESTUDIO DEL SIMULADOR DE UNA MÁQUINA TRAGAPERRAS.
*
*   ¿Qué simbolos tengo? => 5 símbolos
*	> Plátano = P
*	> Fresa = F
*	> Manzana = M
*	> Naranja = N
*	> Cereza = C
*   ¿Que contiene por jugada una secuencia? => 3 símbolos aleatorios.
*   ¿Cuántas jugadas realiza el simulador? => Hasta que obtenga premio. (n-intentos)
*   ¿Cuántos premios hay? => 5 premios
*	> Premio 1: PPP 
*	> Premio 2: FFF
*	> Premio 3: MMM
*	> Premio 4: NNN
*	> Premio 5: CCC
*   ¿Cuando termina la simulación? => Cuando se obtiene premio
*   ¿Que debo mostrar al usuario? => Todas las secuencias obtenidas durante la simulación y el premio conseguido.
*   ¿Qué bucles voy a usar? => 2 tipos de bucles (uno por contador y otro por eventos)
*	> Contador: Bucle for (Genera la secuencia de simbolo por cada jugada)
*	> Eventos: Bucle do-while (Controla la simulación hasta conseguir premio)
*   ¿Qué variables de entrada voy a tener a priori?
*	> simbolo (cadena) 		=> Guarda letra de la fruta
*	> secuencia (cadena) 		=> Guarda la secuencia de tres simbolos.
*	> numeroIntentos (entero)	=> Guarda el número de intentos hasta conseguir premio.
*	> otraJugada (booleano)		=> Bandera de control para finalizar la simulación de la tragaperras.
*   ¿Cómo genero aleatoriamente los símbolos? => r (objeto; Clase Random) = aleatorio[0, numero] por cada ejecución -> selector de casos multiples.
*	> Caso 0: Plátano 	=> P
*	> Caso 1: Fresa 	=> F
*	> Caso 2: Manzana 	=> M
*	> Case 3: Naranja	=> N
*	> Caso 4: Cereza	=> C
*	> Por defecto		=> No es necesario por que el número aleatorio de la clase Random estan comprendido entre los casos evaluados [0,numero_simbolos]
*   ¿Cómo compruebo que tengo premio? => selector de casos múltiples.
*	> Caso PPP		=> Premio-1; genero mensaje del premio;otraJugada=no
*	> Caso FFF		=> Premio-2; genero mensaje del premio;; otraJugada=no
*	> Caso MMM		=> Premio-3; genero mensaje del premio;; otraJugada=no
*	> Caso NNN		=> Premio-4; genero mensaje del premio;;otraJugada=no
*	> Caso CCC		=> Premio-5; genero mensaje del premio;;otraJugada=no
*	> Por defecto		=> No hay premio;no genero mensaje de premio; otraJugada=si
*   ¿Cómo muestro el resultado al usuario? => Guardandolo en variable salida resultados
*	> Muestro mensaje inicial explicando que se va a realizar
*	> Muestro el resultado al final del proceso porque la velocidad del programa puede impedir su lectura.
*	> El resultado contiene cada intento con su secuencia y termina con el mensaje del premio obtenido.
*   ¿Qué variables de salida necesito?
*	> resultado (cadena)	=> Guarda todas la secuencias de la simulación y el premio obtenido
*   ¿Qué variables auxiliares necesito?
*	> letra_secuencia (byte) => 
*
* ALGORITMO: ¿Qué pasos tiene el funcionamiento del simulador?
*
*	//Informo al usuario en que consiste la simulación de la tragaperras
*	muestra_linea_pantalla("Voy a generar secuencias de 3 frutas entre Plátano, Fresa, Naranja, Manzana y Cereza.");
*	muestra_linea_pantalla(" hasta conseguir 3 iguales y te diré qué premio has obtenido de los cinco:");
*
*	//Inicializo el contador de intentos
*	numeroIntentos = 0;
*
*	//Inicializo el contenido d elos resultados de la simulación
*	resultado="";
*
*	Hago simulación tragaperras {
*
*		//Incremento el contador de intentos
*		numeroIntentos++;
*
*		//Inicializo contenido de la secuencia de símbolos
*		secuencia="";
*
*		//Genero una secuencia de símbolos para jugada actual
*		Repito tres veces para obtener la secuencia (letra_secuencia=0; letra_secuencia<3;letra_secuencia++) {
*                       // Obtengo cada símbolo de la secuencia según el número aleatorio obtenido
*                       // El número aleatorio es: r.nextInt(5) donde 5 es el número de símbolos disponibles.
*                       // E rango de los número aleatorios a obtener es 0 a 4.
*			selecciona el caso (siguiente_numero_aleatorio(5)) { //Hay cinco símbolos de frutas
*				caso 0:
*					simbolo="P":
*					fin_caso;
*				caso 1:
*					simbolo="F";
*					fin_caso;
*				caso 2:
*					simbolo="M";
*					fin_caso;
*				caso 3:
*					simbolo="N";
*					fin_caso
*				caso 4:
*					simbolo="C";
*					fin_caso
*			}
*			//Agrego cada símbolo obtenido a la secuencia
*			secuencia += simbolo;
*		}
*
*		//Guardo el resultado de la jugada actual
*		resultado += intentos + "-" + secuencia + "\n";
*
*		//Compruebo que la secuencia tiene premio
*		seleccion el caso (secuencia) {
*			caso "PPP":
*				resultado += "Has conseguido el premio 1 en el intento " + intento + " con la secuencia: " + secuencia + "\n"
*				otraJugada = no;
*				fin_caso;
*			caso "FFF":
*				resultado += "Has conseguido el premio 2 en el intento " + intento + " con la secuencia: " + secuencia + "\n"
*				otraJugada = no;
*				fin_caso;
*			caso "MMM":
*				resultado += "Has conseguido el premio 3 en el intento " + intento + " con la secuencia: " + secuencia + "\n"
*				otraJugada = no;
*				fin_caso;
*			caso "NNN":
*				resultado += "Has conseguido el premio 4 en el intento " + intento + " con la secuencia: " + secuencia + "\n"
*				otraJugada = no;
*				fin_caso;
*			caso "CCC":
*				resultado += "Has conseguido el premio 5 en el intento " + intento + " con la secuencia: " + secuencia + "\n"
*				otraJugada = no;
*				fin_caso;
*			por defecto:
*				otaJugada=si;
*		}
*
*	} Mientras haya (otraJugada);
*
*	// Muestro por pantalla al usuario toda la información de la simulación 
*	muestra_linea_pantalla(resultado)
*/
package tarea02;

import java.util.Random;

/**
 *
 * @author contacto@bitgarcia.es
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        //----------------------------------------------
        //               Declaración de variables
        //----------------------------------------------
        // Variables de entrada.
        String simbolo = "";
        String secuencia;
        int numeroIntentos;
        boolean otraJugada = false;
        
        // Variables auxiliares.
        byte numeroSimboloSecuencia;
        
        // Variables de salida.
        String resultado;

        /* La clase Random es una clase de Java que nos sirve para generar elementos aleatorios
            en este caso el objeto "r", consigue a través de su método nextInt(número), generar
            un número aleatorio entero entre 0 y número-1, por ejemplo r.nextInt(5), generará 
            un número entero entre 0 y 4, es decir, podrá devolver 0,1,2,3 o 4 cada vez que se 
            utilice.
         */

        Random r = new Random();
        //----------------------------------------------
        //              Entrada de datos
        //----------------------------------------------
        // En este caso no hay entrada de datos. 
        System.out.println("Ejercicio 4. Simulador de Máquina Tragaperras.");
        System.out.println("----------------------------------------------------");
        
        //Informo al usuario en que consiste la simulación de la tragaperras
        System.out.println("Voy a generar secuencias de 3 frutas entre Plátano, Fresa, Naranja, Manzana y Cereza.");
        System.out.println("Hasta conseguir 3 iguales y te diré qué premio has obtenido de los cinco:");
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------

        /* Hemos de generar una secuencia de 3 frutas
        * Las frutas son: Plátano, Fresa, Manzana, Naranja, Cerezas 
        * Representamos cada fruta con un caracter: P,F,M.N,C
        * Para elegir una de las cinco frutas podemos asociar cada una con un número
        * Para ello podemos generar un número aleatorio */
	
        //Inicializo el contador de intentos
	numeroIntentos = 0;

	//Inicializo el contenido de los resultados de la simulación
	resultado="";
        
        //El proceso debe hacerse hasta que se obtengan 3 iguales, cosa que suponemos que se producirá en x intentos. Hemos de llevar la cuenta de los intentos.
        do {

            //Incremento el contador de intentos
            numeroIntentos++;

            //Inicializo contenido de la secuencia de símbolos
            secuencia="";
            
            //Genero una secuencia de símbolos para jugada actual
            for (numeroSimboloSecuencia=0;numeroSimboloSecuencia<3;numeroSimboloSecuencia++) {
                // Obtengo cada símbolo de la secuencia según el número aleatorio obtenido
                // El número aleatorio es: r.nextInt(5) donde 5 es el número de símbolos disponibles.
                // E rango de los número aleatorios a obtener es 0 a 4.
                switch (r.nextInt(5)) {
                    case 0:
                        simbolo = "P";
                        break;
                    case 1:
                        simbolo = "F";
                        break;
                    case 2:
                        simbolo = "M";
                        break;
                    case 3:
                        simbolo = "N";
                        break;
                    case 4:
                        simbolo = "C";
                        break;                    
                }
		//Agrego cada símbolo obtenido a la secuencia
		secuencia += simbolo;             
                
            }
            
            //Guardo el resultado de la jugada actual
            resultado += numeroIntentos + "-" + secuencia + "\n";
            
            //Compruebo que la secuencia tiene premio
            switch (secuencia) {
                case "PPP":
                    resultado += "Has conseguido el premio 1 en el intento " + numeroIntentos + " con la secuencia: " + secuencia + "\n";
                    otraJugada = false;
                    break;
                case "FFF":
                    resultado += "Has conseguido el premio 2 en el intento " + numeroIntentos + " con la secuencia: " + secuencia + "\n";
                    otraJugada = false;
                    break;
                case "MMM":
                    resultado += "Has conseguido el premio 3 en el intento " + numeroIntentos + " con la secuencia: " + secuencia + "\n";
                    otraJugada = false;
                    break;
                case "NNN":
                    resultado += "Has conseguido el premio 4 en el intento " + numeroIntentos + " con la secuencia: " + secuencia + "\n";
                    otraJugada = false;
                    break;
                case "CCC":
                    resultado += "Has conseguido el premio 5 en el intento " + numeroIntentos + " con la secuencia: " + secuencia + "\n";
                    otraJugada = false;
                    break;
                default:
                    otraJugada = true;
            }
            
        } while (otraJugada);
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        //Además de los intentos en los que se ha obtenido el premio, hay que decir qué premio hemos tenido de entre los posibles.
        System.out.println(resultado);
    }
}
