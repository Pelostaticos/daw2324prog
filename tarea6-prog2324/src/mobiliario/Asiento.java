/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase abstracta que representa un mueble de tipo <strong>Asiento</strong> para la gestión de productos en una tienda de muebles.
 * 
 * <p> Los objetos de esta clase disponen ademas de los atributos que le son propios de un mueble. Además incluye los atributo 
 * específicos de un mueble que sirve para sentarse son:</p>
  * <ul>
 *  <li><strong>Plazas</strong> del asiento (Valor entre en el rango {@value #MIN_PLAZAS}-{@value #MAX_PLAZAS})</li>
 *  <li><strong>Tapicería</strong> de asiento</li>
 *  <li><strong>Color</strong> del asiento</li>
 * </ul>
 * 
 * Se trata de una clase abstracta que contiene la información mínima sobre el mueble de tipo 
 * asiento pero no contiene información que depende del asiento concreto (si se trata de una 
 * silla, un sillón o un sofá). Para eso existen otras clases especializadas que heredarán de ésta
 * 
 * @author Sergio Garcia Butron
 */
public abstract class Asiento extends Mueble {
    
    //Atributos publicos constantes estáticos

    /**
     * Número mínimo de plazas permitidas: {@value #MIN_PLAZAS}
     */
    public static final int MIN_PLAZAS=1;
    
    /**
     * Número máximo de plazas permitidas: {@value #MAX_PLAZAS}
     */
    public static final int MAX_PLAZAS=9;
        
    //Atributos privados inmutables
    private final int numeroPlazas;
    private final String color;
    private final String tapiceria;
    
    /**
     * 
     * Crea un objeto de tipo <strong>Asiento</strong> heredado como un tipo de <strong>Mueble</strong>.
     * 
     * @param precio Precio actual del mueble (euros)
     * @param descripcion Descripción del mueble
     * @param plazas Número de plazas del asiento
     * @param color Color del asiento
     * @param tapiceria tapicería del asiento
     * @throws IllegalArgumentException Si alguno de los parámetros son incorrectos
     */
    public Asiento(double precio, String descripcion, int plazas, String tapiceria,String color)
        throws IllegalArgumentException {
            super(precio, descripcion);
            if (plazas < Asiento.MIN_PLAZAS || plazas > Asiento.MAX_PLAZAS)
                throw new IllegalArgumentException(String.format("El número de plazas no está en el rango permitido: %d",
                        plazas));
            else {
                this.numeroPlazas = plazas;
                this.tapiceria = tapiceria;
                this.color=color;                
            }
    }

    /**
     * Permite obtener el número de plazas del asiento.
     * 
     * @return Devuelve el número de plazas.
     */
    public int getNumPlazas() {
        return this.numeroPlazas;
    }

    /**
     * Permite obtener el color del asiento.
     * 
     * @return Devuelve el color.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Permite obtener la tapicería del asiento.
     * 
     * @return Devuelve la tapiceria.
     */
    public String getTapiceria() {
        return this.tapiceria;
    }
    
    /**
     * 
     * Representa una cadena con las caracterñisticas de un asiento
     * 
     * @return Devuelve cadena con las caracterñisticas de un asiento
     */
    @Override
    public String toString() {
        return String.format("%-90s Tapicería: %-14s Color: %-10s Número de plazas: %-2d",
                super.toString(),
                this.getTapiceria(),
                this.getColor(),
                this.getNumPlazas());
    }
}
