/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase que representa un <strong>Mueble</strong> de asiento del tipo <strong>Sofá</strong> para la gestión de productos en una tienda de muebles.
 * 
 * <p>Un Sofa es un mueble de tipo asiento que puede contener más de una plaza.</p>
 * 
 * <p>Los atributos específicos de un Sofá, son:</p>
 * <ul>
 *  <li><strong>composición</strong> del sofá ("3+2", "2+CHAISELONGUE", "3+2+CHAISELONGUE",..., etcétera)</li>
 * </ul>
 * 
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la información propia de un mueble de tipo asiento.
 * 
 * @author Sergio Garcia Butron 
 */
public final class Sofa extends Asiento {
    
    //Atributos privados
    private final String composicion;
    
    /**
     * 
     * Crea un objeto sofá con su precio, descripción, número de plazas, tapicería, color y composición.
     * 
     * @param composicion Composición del sofá
     * @param precio Precio del sofá (euros)
     * @param descripcion Descripción del sofá
     * @param plazas Número de plazas del sofá
     * @param color Color del sofá
     * @param tapiceria Tapicería del sofá
     * @throws IllegalArgumentException Si alguno de los argumentos es incorrecto.
     */
    public Sofa(double precio, String descripcion, int plazas, String color, String tapiceria, String composicion) throws IllegalArgumentException {
        super(precio, descripcion, plazas, color, tapiceria);
        this.composicion = composicion;
    }

    /**
     * Devuelve la composición del sofá.
     * 
     * @return Composición del sofá
     */
    public String getComposicion() {
        return composicion;
    }

    /**
     * Representa una cadena de texto con las características del sofá.
     * 
     * @return Cadena de texto con las características del sofá
     */
    @Override
    public String toString() {
        return String.format("%-161s Composición: %-15s", super.toString(),
                this.getComposicion());
    }
            
}
