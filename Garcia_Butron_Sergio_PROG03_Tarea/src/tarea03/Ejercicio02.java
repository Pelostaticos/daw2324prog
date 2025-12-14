package tarea03;

// importo la clase Dados de la librería libtarea3
import libtarea3.Dado;

// Importo la librería para generar números aleatorios
import java.util.Random;

/**
 * Ejercicio 2: Uso de la clase Dado
 *
 * @author Profe
 */
public class Ejercicio02 {

    public static void main(String[] args) {
       
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        //Constantes
        final int ALEATORIO_MINIMO = 30;
        final int ALEATORIO_MAXIMO = 60;
        
        // Variables de entrada (dados y puntuación máxima)
        Dado jugadorUno;
        Dado jugadorDos;
        Dado jugadorTres;
        int puntuacionMaxima;

        // Variables de salida
        byte lanzamientoJugadorUno;
        byte lanzamientoJugadorDos;
        byte lanzamientoJugadorTres;
        long puntosAcumulados;
        String resultados = "";
        
        // Variables auxiliares
        Random objetRandom = new Random();
        
        // Clase Scanner para petición de datos de entrada (no es necesario)
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //En realidad no hay entrada de datos como tal, pero podemos considerar
        //el número máximo como información de entrada ya que variará el
        //comportamiento del programa.

        //1. Cálculo del número aleatorio de puntos (entre 30 y 60)
        puntuacionMaxima = ALEATORIO_MINIMO + objetRandom.nextInt(ALEATORIO_MAXIMO - ALEATORIO_MINIMO + 1);
        
        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------  

        //2. Creación de 3 dados (jugadores) de 6 caras
        jugadorUno = new Dado();
        jugadorDos = new Dado();
        jugadorTres = new Dado();
        //NOTA: Por defecto el constructor sin parámetros crea un dado con seis caras
        
        //3. Lanzamiento de los dados y acumulación de las puntuaciones
        do {
        
            //3.1 Lanzamos cada uno de los dados y mostramos las puntuaciones
            //Utilizamos los métodos de la clase para contar los lanzamientos
            lanzamientoJugadorUno = jugadorUno.lanzar();
            lanzamientoJugadorDos = jugadorDos.lanzar();
            lanzamientoJugadorTres = jugadorTres.lanzar();
            //Añado a la cadena de texto el resultado por cada un de los lanzamientos
            resultados = resultados + String.format("Lanzamiento nº%3d:\t%d\t%d\t%d\n", Dado.getNumeroLanzamientosGlobal()/Dado.getNumeroDadosCreados(), lanzamientoJugadorUno, lanzamientoJugadorDos, lanzamientoJugadorTres);
                       
            //3.2 Utilizando los métodos de la clase, acumulamos las puntuaciones
            //de todos los dados en todos los lanzamientos.
            puntosAcumulados = jugadorUno.getSumaPuntuacionHistorica() + jugadorDos.getSumaPuntuacionHistorica() + jugadorTres.getSumaPuntuacionHistorica();
                        
        } while (puntosAcumulados <= puntuacionMaxima);

        //Añado a la cadena de texto del resultado el mensaje de que se ha terminado el juego
        resultados = resultados + String.format("\nJuego Terminado. La suma de los lanzamientos es: %d\n", puntosAcumulados);
        
        //4. Comprobación de cuál de los dados ha sido el ganador y consulta de
        //todas sus tiradas
        if (lanzamientoJugadorUno > lanzamientoJugadorDos && lanzamientoJugadorUno > lanzamientoJugadorTres) {
            resultados = resultados + String.format("El ganador es el dado 1 con %d puntos en la última jugada.\n", lanzamientoJugadorUno);
            resultados = resultados + String.format("El valor %d ha salido %d veces en todo el juego y se han realizado un total de %d lanzamientos.\n", lanzamientoJugadorUno, Dado.getNumeroVecesCaraGlobal(lanzamientoJugadorUno), Dado.getNumeroLanzamientosGlobal());
            resultados = resultados + String.format("Todos los lanzamientos del dado 1: %s\n", jugadorUno.getSerieHistoricaLanzamientos());
        } else if (lanzamientoJugadorDos > lanzamientoJugadorUno && lanzamientoJugadorDos > lanzamientoJugadorTres) {
            resultados = resultados + String.format("El ganador es el dado 2 con %d puntos en la última jugada.\n", lanzamientoJugadorDos);
            resultados = resultados + String.format("El valor %d ha salido %d veces en todo el juego y se han realizado un total de %d lanzamientos.\n", lanzamientoJugadorDos, Dado.getNumeroVecesCaraGlobal(lanzamientoJugadorDos), Dado.getNumeroLanzamientosGlobal());
            resultados = resultados + String.format("Todos los lanzamientos del dado 2: %s\n", jugadorDos.getSerieHistoricaLanzamientos());
        } else {
            resultados = resultados + String.format("El ganador es el dado 3 con %d puntos en la última jugada.\n", lanzamientoJugadorTres);
            resultados = resultados + String.format("El valor %d ha salido %d veces en todo el juego y se han realizado un total de %d lanzamientos.\n", lanzamientoJugadorTres, Dado.getNumeroVecesCaraGlobal(lanzamientoJugadorTres), Dado.getNumeroLanzamientosGlobal());
            resultados = resultados + String.format("Todos los lanzamientos del dado 3: %s\n", jugadorTres.getSerieHistoricaLanzamientos());
        }       
        
        //----------------------------------------------
        //      Salida de resultados
        //----------------------------------------------
        System.out.println("LANZAMIENTO DE DADOS");
        System.out.println("----------------------------------------");
        System.out.printf("Número máximo de puntos: %d\n\n",puntuacionMaxima);
        System.out.println("\t\t      DADO1   DADO2   DADO3\n");
        System.out.println(resultados);
        
    }
}
