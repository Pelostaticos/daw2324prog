/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mobiliario;

/**
 * Interfaz que ofrece a un objeto la capacidad de ajustar su posición.
 *
 * @author Sergio Garcia Butron
 */
public interface Ajustable {
    
    //Todos los métodos definidos en la interfces son por omisión publicos y abstractos
    //Por este motivo he decido no incluir los modificadores, aunque puedan hacerse.
    
    /**
     * Devuelve un entero con la <strong>posición actual</strong> del obbjeto ajustable.
     * @return Posición del objeto ajustable.
     */
    int obtenerPosicion();
    
    /**
     * 
     * <strong>Sube una posición</strong> del objeto ajustable y la devuelve.
     * 
     * @return Posición del objeto ajustable.
     * @throws IllegalStateException Si no pudo bajarse la posición del objeto ajustable.
     */
    int subirPosicion() throws IllegalStateException;
    
    /**
     * 
     * <strong>Baja una posición</strong> del objeto ajustable y la devuelve.
     * 
     * @return Posición del objeto ajustable.
     * @throws IllegalStateException Si no pudo bajarse la posición del objeto ajustable.
     */
    int bajarPosicion() throws IllegalStateException;
    
}
