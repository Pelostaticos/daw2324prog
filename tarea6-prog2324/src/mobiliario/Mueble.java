/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * 
 * Clase abstracta que representa un <strong>Mueble</strong> genérico para una tienda de muebles online.
 * 
 * <p>Los objetos de esta clase contienen los atributos siguientes:</p>
 * <ul>
 *  <li><strong>Id</strong> único del mueble.</li>
 *  <li><strong>Precio</strong> del mueble (valor real en el rango {@value #MIN_PRECIO}-{@value #MAX_PRECIO} euros)</li>
 *  <li><strong>Descripción</strong> del mueble.</li>
 * </ul>
 * 
 * <p>El precio de un mueble pude cambiar a lo largo del tiempo</p>
 * <p>Se trata de una clase abstracta que contiene la información mínima sobre un mueble pero no contiene información que depende del mueble concreto (si se trata de una silla, un armario, una estantería, etc). Para eso existen otras clases especializadas que heredarán de ésta.</p>
 * @author Sergio Garcia Butron
 */
public abstract class Mueble {
    
    //Defino los atributos estáticos constantes publicos
    
    /**
     * Mínimo precio permitido: {@value #MIN_PRECIO} euros.
     */
    public static final double MIN_PRECIO = 0.01;
    
    /**
     * Máximo precio permitido: {@value #MAX_PRECIO} euros.
     */    
    public static final double MAX_PRECIO = 10000.00;

    //defino los atributos de objeto protegidos.
    /**
     * Precio actual del mueble.
     */
    protected double precio;    
    
    //Defino los atributos de objeto privados.
    private final int identificador;
    private final String descripcion;    
       
    //Defino los atributos de clase privados
    private static int mueblesCreados;

    //Constructores de la clase Mueble.
        
    /**
     * 
     * Crea un objeto <strong>Mueble</strong> con un precio y texto descriptivo.
     * 
     * @param precio Precio del mueble. Rango permitido {@value #MIN_PRECIO}-{@value #MAX_PRECIO} euros.
     * @param descripcion Texto descriptivo del mueble.
     * @throws IllegalArgumentException Si algunos de parámetros es incorrecto.
     */
    public Mueble(double precio, String descripcion) 
        throws IllegalArgumentException {
            
        //Compruebo que el precio pasado por parametro estñá dentro del rango deseado
        if (precio < Mueble.MIN_PRECIO || precio > Mueble.MAX_PRECIO) 
            throw new IllegalArgumentException(String.format("El precio no está en el rango permitido: %.2f", precio));
        
        else {
            //Incremento el contador de Muebles creados
            Mueble.mueblesCreados++;
                
            //Asigno los valores a los atributos de objeto.
            this.identificador=Mueble.mueblesCreados;
            this.precio=precio;
            this.descripcion=descripcion;
        }
    }       

    
    /**
     * Permite obtener el identificador único del Mueble.
     * 
     * @return Devuelve identidicador del mueble
     */
    public int getId() {
        return identificador;
    }

    /**
     * Permite obtener la descripción del mueble.
     * 
     * @return Devuelve la descripción del mueble
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Permite obtener el precio actual del mueble.
     * 
     * @return Devuelve el precio actual del mueble.
     */
    public double getPrecio() {
        return precio;
    }
           
    /**
     * Devuelve una cadena que represeneta las características de un mueble.
     * 
     * @return Devuelve cadena que represeneta las características de un mueble
     */

    
    @Override
    public String toString() {
        return String.format("tipo:%-11s id:%2d precio:%8.2f descripción: %-20s",
                this.getClass().getSimpleName(), 
                this.getId(), 
                this.getPrecio(),
                this.getDescripcion()); 
    }

}
