package tarea07;

//Importo las librerias necesarias para el programa
import java.time.LocalDate;
import java.util.LinkedHashMap;

/** Ejercicio 3. Calendario de especies de plantas
 * @author Sergio García Butrón <contacto@bitgarcia.es>sor
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
        final int UNA_SEMANA=7; //dias
        
        // Variables de entrada
        LocalDate fechaHoy = LocalDate.now();
        
        // Variables auxiliares
        int contadorDias=0;
        String planta;
        
        // Variables de salida
        LinkedHashMap<LocalDate, String> calendarioBotanico = new LinkedHashMap<>();
        

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        
        System.out.println("CALENDARIO DE ESPECIES DE PLANTAS");
        System.out.println("---------------------------------");
        
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        while (contadorDias < UNA_SEMANA) {
            planta = Utilidades.especiePlantaAleatoria();
            if (!calendarioBotanico.containsValue(planta)) {
                calendarioBotanico.put(fechaHoy.plusDays(contadorDias), planta);
                contadorDias++;                
            }
        }
   
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        System.out.println("Contenido final del mapa de especies de plantas organizado por fechas:\n");
        for (LocalDate fechaCalendario: calendarioBotanico.keySet()) {
            System.out.printf("Fecha %s: %s\n",
                    fechaCalendario, 
                    calendarioBotanico.get(fechaCalendario));
        }
 
    }
}