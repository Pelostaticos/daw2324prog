package tarea03;

// Importo la liberia para manejo de fechas y su formatos con excepciones
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;

// Importo librerías necesarias para traducir nombrede los dias de la semana a español.
import java.time.format.TextStyle;
import java.util.Locale;

// Importo la libería para entrada de datos por teclado
import java.util.Scanner;

// Importo la libería de excepciones para entrada de datos erronea por teclado
import java.util.InputMismatchException;


/**
 * Ejercicio 3: Día de cumpleaños
 *
 * @author Sergio García Butrón <contacto@bitgarcia.es>
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int MES_ENERO = 1;
        final int MES_DICIEMBRE = 12;
        final int PRIMER_DIA_MES = 1;
        final int MINIMO_ANYO_NACIMIENTO = 1900;

        // Variables de entrada
        int diaCumple = 18;
        int mesCumple = 11;
        int anyoCumple = 1989;

        // Variables de salida
        String diaSemanaCumple;
        String resultados;

        // Variables auxiliares
        LocalDate unaFecha = LocalDate.now();
        int anyoActual = unaFecha.getYear();
        int ultimoDiaMes;
        boolean datosOk = false;    //Bandera de control de datos
        int anyo;
        int contadorCoincidencias = 0;
      
        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("DÍA DE CUMPLEAÑOS");
        System.out.println("-----------------");

        // 1. Entrada de datos: lectura de año de nacimiento
        // 1.1.- Leer y comprobar el año de nacimiento (entre 1900 y año actual)
        do {
            
            // Muestro por pantalla mensaje solicitando al usuario su año de nacmiento
            System.out.printf("Introduzca año de nacimiento (%d-%d):\n",MINIMO_ANYO_NACIMIENTO, anyoActual);            
            
            // Intento leer el año de nacimiento del usuario introducido por teclado
            try {
                // Leo desde el teclado el año de nacimiento del usuario.
                anyoCumple = teclado.nextInt();
                // Compruebo que el año de nacimiento del usuario está entre el limite aceptado.
                if (anyoCumple < MINIMO_ANYO_NACIMIENTO || anyoCumple > unaFecha.getYear())
                    // Lanzo excepción de usurio indicando que el año introducido es incorrecto
                    throw new InputMismatchException();
                else
                   // El año introducido es correcto doy por terminado el bucle do-while
                   datosOk = true;
            } catch (InputMismatchException errorTeclado) {
                // Muestro en l salida de errores por pantalla el mensaje de error
                System.err.println("Error de lectura: año incorrecto");
                // Creo un nuevo objeto Scanner para lectura por teclado porque el anterior dió error
                teclado = new Scanner(System.in);
            }
        } while (!datosOk);

        // Restablezco la bandera para controlar que los datos introducidos por teclado son correctos
        datosOk = false;
        
        // 1.2.- Leer y comprobar el mes de nacimiento 
        do {
            // Muestro por pantalla mensaje solicitando al usuario su mes de nacmiento
            System.out.printf("Introduzca mes de nacimiento (%d-%d):\n",MES_ENERO, MES_DICIEMBRE);
            
            // Intento leer el mes de nacimiento del usuario introducido por teclado
            try {
                // Leo desde el teclado el mes de nacimiento del usuario.
                mesCumple = teclado.nextInt();
                // Compruebo que el mes de nacimiento del usuario está entre el limite aceptado.
                if (mesCumple < MES_ENERO || mesCumple > MES_DICIEMBRE)
                    // Lanzo excepción de usurio indicando que el mes introducido es incorrecto
                    throw new InputMismatchException();
                else
                    // El mes introducido es correcto doy por terminado el bucle do-while
                    datosOk = true;
            } catch (InputMismatchException errorTeclado) {
                // Muestro por pantalla el mensaje de error del teclado
                System.err.println("Error de lectura: mes incorrecto");
                // Creo un nuevo objeto Scanner para lectura por teclado porque el anterior dió error
                teclado = new Scanner(System.in);                
            }
        } while (!datosOk);        

        // Restablezco la bandera para controlar que los datos introducidos por teclado son correctos
        datosOk = false;        
        
        // 1.3.- Averiguamos cuántos días tiene el mes de nacimiento
        ultimoDiaMes = LocalDate.parse(String.format("%4d-%02d-%02d", anyoCumple, mesCumple, PRIMER_DIA_MES)).lengthOfMonth();

        // 1.4.- Leer y comprobar el día de nacimiento 
        do {
            // Muestro por pantalla mensaje solicitando al usuario su dia de nacmiento
            System.out.printf("Introduzca dia de nacimiento (%d-%d):\n",PRIMER_DIA_MES, ultimoDiaMes);
                
            try {
                // Leo desde el teclado el dia de nacimiento del usuario.
                diaCumple = teclado.nextInt();
                // Compruebo que el mes de nacimiento del usuario está entre el limite aceptado.
                if (diaCumple < PRIMER_DIA_MES || diaCumple > ultimoDiaMes)
                    // Lanzo excepción de usurio indicando que el dia introducido es incorrecto
                    throw new InputMismatchException();
                else
                    // El dia introducido es correcto doy por terminado el bucle do-while
                    datosOk = true;                
            } catch (InputMismatchException errorTeclado) {
                // Muestro por pantalla el mensaje de error del teclado
                System.err.println("Error de lectura: dia incorrecto");
                // Creo un nuevo objeto Scanner para lectura por teclado porque el anterior dió error
                teclado = new Scanner(System.in);                 
            }
        } while (!datosOk);        

        //----------------------------------------------
        //    Procesamiento + Salida de resultados  
        //----------------------------------------------
        //2.- Cálculo del día de la semana en que cayó el nacimiento       
        unaFecha = LocalDate.of(anyoCumple, mesCumple, diaCumple);
        diaSemanaCumple = unaFecha.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es","ES"));
        resultados = String.format("El día que nacistes fue %s\n\n", diaSemanaCumple);
        
        // 3.- Recorremos desde el año posterior al año de nacimiento hasta el año actual (bucle)
        // Muestro por pantalla la cabecera del listado de fechas donde el cumpleaño cae en el día de la semana de nacimiento
        resultados = resultados + String.format("¿Cuántas veces ha caido tu cumpleaños en %s?\n", diaSemanaCumple);
        resultados = resultados + "-----------------------------------------------------\n";
        // Bloque con bucle for crear listado de fechas donde el día de la semana de nacimiento han coincidido.
        for (anyo = anyoCumple + 1; anyo <= anyoActual; anyo++) {
           // Intento crear unaFecha de cumpleaños
           try {
            // Creo unaFecha de cumpleaños mediante el méotdo "of" de la clase estática LocalDate
            unaFecha = LocalDate.of(anyo, mesCumple, diaCumple);
            // Activo la bandera de control "datosOk" para permitir que evalue coinciendia con el día de la semana de nacimiento
            datosOk = true;
           // Capturo excepción cuando el usuario nació en 29-febrero y la fecha de cumpleaños actual del bucle es en año no bisiesto
           } catch (DateTimeException anyoNoBisiesto) {
               // Conforme al Código Civil las personas que nacen en 29-febrero, en años no bisiestos cumplen el 28-febrero.
               // Entonces al día de cumpleaños oficial le resto un día.
               //unaFecha = LocalDate.of(anyo, mesCumple, diaCumple - 1);
               // Desactivo la bandera de control "datosOk" para NO permitir que evalue coinciendia con el día de la semana de nacimiento
               datosOk = false;
           } finally {
            // Compruebo si datosOk lo permite que el dia de la semana de unaFecha de cumpleaños coinciden con el día de nacimiento.
            if (diaSemanaCumple.equals(unaFecha.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es","ES"))) && datosOk) {
                // Incremento el contador de coincidencia
                contadorCoincidencias++;
                // Establezco el formato de fecha correcto a unaFecha de cumpleaños actual en el bucle
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                // Agrego la fecha del compleaño que coinciden con el día de la semana de nacimiento a los resultados
                resultados = resultados + String.format("%2d. %s\n", contadorCoincidencias, unaFecha.format(formato));
            }
           }
        }
        // Muestro por pantalla el númerio total de coincidencias que se han encontrado en las fechas de cumpleaños
        // con el día de la semana en la que nació el usuario.
        resultados = resultados + String.format("\nNumero total de coincidencia: %d\n", contadorCoincidencias);

        // 4.- Mostramos por pantalla el número de coincidencias
        System.out.println(resultados);
    }
}
