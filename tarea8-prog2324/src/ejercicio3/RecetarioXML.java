package ejercicio3;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite serializar un objeto Recetario al formato XML y 
 viceversa.
 *   
 * @author Sergio García Butrón <contacto@bitgarcia.es>
 */
public class RecetarioXML {
    
     // Ruta del archivo donde se lee y escribe el objeto Recetario
    private String rutaArchivo;
    
    
    // Objeto Xstream que permite la L/E con archivos XML
    private XStream xstream;

    /**
     * Método constructor
     * @param nombreArchivo Ruta del archivo donde se lee y escribe el objeto Recetario
     */
    public RecetarioXML(String nombreArchivo) {
        this.rutaArchivo = nombreArchivo;
        this.xstream = new XStream();
        //Permite asignar privilegios para poder operar con los archivos XML
        this.xstream.allowTypesByWildcard(new String[] { 
            "ejercicio3.**",
            "com.mydomain.utilitylibraries.**"
        });
    }

    
    // -----------------------------------------------------
    // Ejercicio 3: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    
    // 3.1. Método escribir()
    /**
     * Método que escribe, en un archivo de texto, un objeto Recetario serializable.
     * @param recetario Objeto Recetario serializable para almacenar en el archivo de texto.
     */    
    public void escribir(Recetario recetario) {
        
        // Obtengo la cadena de texto en formato XML del recetario serializado
        String recetarioXml = this.xstream.toXML(recetario);
        
        //Intento barir un fichero de textoi para guardar el XML del recetario serializado
        try (FileWriter fichero = new FileWriter(this.rutaArchivo);
            PrintWriter ficheroXml = new PrintWriter(fichero);) {
            // Imprimo el contenido del recetario en formato XML
            ficheroXml.println(recetarioXml);            
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }    

    
    // 3.2. Método leer()
     /**
     * Método que lee, desde un archivo de texto, un objeto Recetario serializado.
     * @return Objecto Recetario que estaba almacenado en el archivo de texto.
     */
    public Recetario leer() {
        
        // Defino cadena de texto para almacenar temporlmente las lineas leídas desde el fichero XML
        String lineasXml;
        
        // Defino cadena de texto para almacenar el fichero XML leido
        StringBuilder recetarioXml = new StringBuilder();
        
        // Defino localmente un objerto Recetario
        Recetario miRecetario=null;
        
        //Intento barir un fichero de textoi para leer el XML del recetario serializado
        try (//Creo el lector de ficheros de textos por caracteres
            FileReader lectorFichero = new FileReader(this.rutaArchivo);
            //Creo el lector de lineas del fichero de texto del recetario
            BufferedReader lectorLineas = new BufferedReader(lectorFichero);) {
            // Leo las lineas del fichero XML hasta llegar al final
            while ((lineasXml = lectorLineas.readLine()) != null) {
                recetarioXml.append(lineasXml);
            }
            // Convierto el texto XML que contiene serializado el recetario a un objeto
            miRecetario = (Recetario) this.xstream.fromXML(recetarioXml.toString());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return miRecetario; // Sustituir este return por el código que resuelve el ejercicio
    }
}
