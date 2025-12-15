package tarea04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Tarea Online 4. Ejercicio 3: Días Festivos y Puentes
 * @author Sergio García Butrón
 * @version 1.0
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        final String CADENA_FESTIVOS = "12,8;12,25;1,1;1,6;5,1;5,18;10,12;11,1;12,6";
        final LocalDate[] FESTIVOS;
        final Locale LOCALE_ES = new Locale("ES","es"); // Para mostrar nombre días en español

        // DEFINICIÓN DE VARIABLES
        // Variable para almacenar año de calculo de los festivos
        int anyoCalculoFestivos;
        // Variable auxiliar para almacenar token que contiene un dia festivo del año
        String tokenFestivo;
        // Variable auxiliar para controlar que un día festivo próximo se ha encontrado
        boolean festivoEncontrado;
        // Variable auxiliar contador para los indices del array FESTIVOS.
        int indiceFestivos = 0;
        //Variable auxiliar para almacenar el dia de la semana en el que cae un festivo
        String diaSemanaFestivo;
        
        // Objeto tipo fecha con la fecha de hoy
        LocalDate hoy;
        
        // Obtejo tipo fecha con la fecha de navidad
        LocalDate navidad;
        
        // Objeto StringTokenizer para obtener los días festivos desde la cadena de festivos
        StringTokenizer listaFestivos;

        // Objeto de tipo StringBuilder para mostrar el resultado al final
        StringBuilder resultado = new StringBuilder("");

        /* ************************************************************************
         * PROCESAMIENTO
         * ***********************************************************************/

        // Si queremos hacer pruebas  podemos descomentar la siguiente línea y cambiar las fechas
        hoy=LocalDate.of(2025, 4, 12);
        
        // Obtención de la fecha actual (hoy)
        //hoy = LocalDate.now();
        
        // Obtención de la fecha de navidad (año actual)
        navidad = LocalDate.of(hoy.getYear(), 12, 25);
               
        
        /*
            Comprobamos si el día de hoy es posterior al 25 de Diciembre, en tal 
            caso debemos incrementar el año actual en una unidad. Ya que, el último día
            festivo del año es el 25 de Diciembre, y por tanto no tiene sentido calcular
            los festivos hasta final de años, ya que no habría ninguno. 
         */
        if (hoy.isAfter(navidad)) 
            anyoCalculoFestivos = hoy.getYear() + 1;
        else
            anyoCalculoFestivos = hoy.getYear();                

        /* Creamos un array con los festivos, para ello, utilizando la clase 
           StringTokenizer, dividimos en  tokens las fechas que nos han entregado 
           con la cadena constante CADENA_FESTIVOS. Por tanto, debemos obtener los
           diferentes tokens para la pareja de fechas día y mes, separados de las otras
           parejas, días y mes mediante ";". Y posteriormente, obtener el día y el mes
           de cada pareja, sabiendo que estos están separados por una coma ","
           Cargaremos cada una de las fechas creadas en el array constante de FESTIVOS
         */
        // A) Obtengo el listado de parejas dia-mes de los días festivos anuales.
        listaFestivos = new StringTokenizer(CADENA_FESTIVOS, ";");
        // B) Creo el array para almacenar los dias festivos
        FESTIVOS = new LocalDate[listaFestivos.countTokens()];
        // C) Proceso todos los tokens para generar el array con las fechas festivas
        for (int indiceListaFestivos=0;indiceListaFestivos<FESTIVOS.length;indiceListaFestivos++) {
            //C.1) Recupero un token del listado de festivos que contiene pareja mes-dia del fesitvo anual
            tokenFestivo = listaFestivos.nextToken();            
            /*C.2) Adapto el formato de la cadena tokenFestivo para que sea compatible con el formato fecha 
            utilizado en el método LocalDate.parse() para convertir una cadena fecha a objeto LocalDate*/
            //Si la longitud de token Festivo es 3: Necesito añadir ceros al token del mes y dia festivo
            if (tokenFestivo.length() == 3) {
                //C2.1A Añado un cero a la parte del token que codifica el mes festivo
                tokenFestivo = "0" + tokenFestivo ;
                //C2.1B Sustituyo el separador "," por el separador fecha "-" añadiendo un cero al dia festivo
                tokenFestivo = tokenFestivo.replace(",","-0");
            /*Si la longitud del token Festivo es 4  y separador "," del token esta en la posición 2 de la cadena, 
            sabiendo que la cadena empieza en la posición 0: Necesito añadir un cero al dia del token*/
            } else if (tokenFestivo.length() == 4 && tokenFestivo.indexOf(",") == 2) {
                //C2.1C Sustituyo el separador "," por el separador fecha "-" añadiendo un cero al dia festivo
                tokenFestivo = tokenFestivo.replace(",","-0");
            /*Si la longitud del token Festivo es 4 y el separador "," del token está en la posición 1 de la cadena,
            sabiendo que la cadena empieza en la posición 0: Necesito añadir un cero al mes del token.*/
            } else if (tokenFestivo.length() == 4 && tokenFestivo.indexOf(",") == 1) {                
                //C2.1D Añado un cero a la parte del token que codifica el mes fetsivo
                tokenFestivo = "0" + tokenFestivo ;
                //C2.1E Sustituyo el separador "," por el separador "-" de la fecha
                tokenFestivo = tokenFestivo.replace(",","-");                  
            /* Para el resto de caso sólo reemplazo el separador "," del token por el separador fecha "-" porque
            la longitud máxima del token Festivo sera cuando día y mes tengan cada uno dos digitos más el separador*/
            } else {
                //C2.1F Sustituyo el separador "," por el separador "-" de la fecha unicamente
                tokenFestivo = tokenFestivo.replace(",","-");                
            }
            
            /*C.3) Agrego al array de festivos el objeto LocalDate con la fecha del festivo recuperada.
            NOTA: El método parse convierte la cadena formada por el año de calculo del festivo y la 
            cadena tokenFestivo acondicionada para el formato fecha aceptado por LocalDate */
            FESTIVOS[indiceListaFestivos] = LocalDate.parse(anyoCalculoFestivos+"-" + tokenFestivo);                        
            
        }
        
        // Ordenamos el array
        Arrays.sort(FESTIVOS);
                
        /* 
           Calculamos el próximo día festivo que vamos a tener, para  ello recorremos
           el array de Festivos hasta que encontremos una fecha posterior a la actual
         */
        do {
            // A) Compruebo si el festivo actual del arrays es mi próximo día festivo
            festivoEncontrado = (FESTIVOS[indiceFestivos].compareTo(hoy) > 0);
            // B) Incremento el indice de los festivos si a´un no se ha encontrado mi día festivo
            indiceFestivos += !festivoEncontrado ? 1 : 0;
        } while(!festivoEncontrado);
        
        
        /* 
           A continuación, queremos saber si ese próximo festivo calculado, se encuentra
           en viernes o lunes, en cuyo caso se generaría un PUENTE
           ----->>>>
           Obtengo el siguiente de mis días festivos a partir de "indiceFestivo" encontrado en el bucle anterior,
           obtengo el día de la semana en texto con el método getDayWeek() de la clase LocalDate a la  que pertence
           los elementos del array FESTIVOS. El nombre devuelto está en inglkés y para pasarlo español, uso el método
           getDisoplayName() de la clase DayWeek a la que pertenece el objeto devuelto anterioremente. Con los parámetros
           que le paso a este mértodo le indico que quiero el nombre completo y en español, hciendo uso de la constante
           LOCALE_ES en la que he definido un objeto Locale con el páis e idioma configurados para España.
         */
         diaSemanaFestivo = FESTIVOS[indiceFestivos].getDayOfWeek().getDisplayName(TextStyle.FULL,  LOCALE_ES);
         switch (diaSemanaFestivo) {
             case "lunes":
             case "viernes":
                 resultado.append("El próximo festivo es: ");
                 resultado.append(FESTIVOS[indiceFestivos].toString());
                 resultado.append(" y TENEMOS PUENTE\n");
                 break;
             default:
                 resultado.append("El próximo festivo es: ");
                 resultado.append(FESTIVOS[indiceFestivos].toString());
                 resultado.append(" y NO TENEMOS PUENTE\n");                 
         }
        

        // Mostramos los festivos desde el día actual hasta el final de año que generan puente
        resultado.append("Festivos con puente hasta el final del año ");
        resultado.append(anyoCalculoFestivos);        
        // Generamos el formato de fecha que queremos
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd MMMM yyyy");                
        
        // Recorremos el array de festivos para ver qué festivos hasta final de año generan puente
        for (int indiceListaFestivos = indiceFestivos;indiceListaFestivos<FESTIVOS.length;indiceListaFestivos++) {
            // Objeto el día de la semana en qué cae el festivo indicasdo por el indice actual
            diaSemanaFestivo = FESTIVOS[indiceListaFestivos].getDayOfWeek().getDisplayName(TextStyle.FULL,  LOCALE_ES);
            // Compruebo si el dia de la semana del festiuvo cae en lunes o viernes para que haya puente
            if (diaSemanaFestivo.matches("lunes|viernes")) {
                resultado.append("\n    * En el festivo " );
                resultado.append(FESTIVOS[indiceListaFestivos].format(formato).toUpperCase());
                resultado.append(" genera PUENTE");
            }
        }


        /* ***********************************************************************
         * SALIDA de DATOS 
         *************************************************************************/
        System.out.println(resultado);
    }

}
