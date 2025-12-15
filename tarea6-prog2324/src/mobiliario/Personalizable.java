/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mobiliario;

/**
 * Interfaz que define el comportamiento comun del mobiliario con
 * capacidades de ser personalizable.
 * 
 * @author Sergio Garcia Butron
 */
public interface Personalizable {
    
    //Todos los métodos definidos en la interfces son por omisión publicos y abstractos
    //Por este motivo he decido no incluir los modificadores, aunque puedan hacerse.
    
    /**
     * Devuelve cadena de textos con los módulos que se le han añadido al 
     * mueble personalizable.
     * 
     * @return cadena de texto con los módulos añadidos al mueble personalizable
     */
    String obtenerModulos();
    
    /**
     * Añade un modulo a un mueble personalizable
     * 
     * @param modulo modulo que se desea añadir al modulo personalizable
     * @throws IllegalStateException
     * @throws NullPointerException 
     */
    void  anyadirModulo(Modulo modulo) throws IllegalStateException, NullPointerException;
    
    /**
     * 
     * Devuelve del mueble personalizable un módulo
     * 
     * @return modulo del mueble personalizable
     * @throws IllegalStateException 
     */
    Modulo extraerModulo() throws IllegalStateException;
    
}
