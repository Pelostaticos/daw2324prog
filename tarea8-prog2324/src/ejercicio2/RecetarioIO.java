package ejercicio2;

// Importo las librerías necesarias para el funcionamiento del programa
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase encargada de realizar la lectura y escritura de objetos Recetario en archivos binarios.
 * @author Sergio García Butrón <contacto@bitgarcia.es>
 */
public class RecetarioIO {
    
    // Ruta del archivo donde se lee y escribe el objeto Recetario
    private final String rutaArchivo;

    /**
     * Método constructor
     * @param archivo Ruta del archivo donde se lee y escribe el objeto Recetario
     */
    public RecetarioIO(String archivo) {
        this.rutaArchivo = archivo;
    }
    
 
    // -----------------------------------------------------
    // Ejercicio 2: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    
    /**
     * Método que lee, desde un archivo binario, un objeto Recetario serializado.
     * @return Objeto Recetario que estaba almacenado en el archivo binario.
     */
    public Recetario leer() {
        
        // Defino localmente una variable de tipo Recetario
        Recetario miRecetario=null;
        
        // Intento deserializar el objeto Recetario guardado en un fichero binario
        try (// Abro el fichero binario que contiene el recetario serializado
            FileInputStream fichero = new FileInputStream(this.rutaArchivo);
            // Creo un flujo de objeto para leer el objeto serializado del fichero
            ObjectInputStream flujoObjeto = new ObjectInputStream(fichero);) {
            
            // Recupero el recetario almacendo en el fichero desde el flujo de objeto
            miRecetario = (Recetario) flujoObjeto.readObject();
         
        } catch (FileNotFoundException e) {
            // Controlo la excepción cuando el fichero binario con el recetario serializado no se encuentra
            System.err.println(e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            // Controlo excepción cuando se produce un error de entrada/salida o la clase dle objeto no se encuentra disponible.
            System.err.println(e.getMessage());
        }
                
        // Devuelvo el recetario deserializado
        return miRecetario; // Sustituir este return por el código que resuelve el ejercicio 
    }
    
    /**
     * Método que escribe, en un archivo binario, un objeto Recetario serializable.
     * @param recetario Objeto Recetario serializable para almacenar en el archivo binario.
     */   
    public void escribir(Recetario recetario) {
                
        // Intento serializar el objeto recetario pasado como argumento
        try (// aAbro el fichero binario para guargar el recetario serializado
             FileOutputStream fichero = new FileOutputStream(this.rutaArchivo);
             // Creo el flujo de objeto para escritura
             ObjectOutputStream flujoObjeto = new ObjectOutputStream(fichero);) {
             // Guardo el objeto Recetario en el fichero binario
             flujoObjeto.writeObject(recetario);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
