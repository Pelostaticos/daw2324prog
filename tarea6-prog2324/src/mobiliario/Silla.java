/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * 
 * Clase que representa un <strong>Mueble</strong> de asiento de tipo <strong>Silla</strong> para la gestión de productos en una tienda.
 * 
 * <p>Una <strong>Silla</strong> es un mueble de tipo asiento qué sólo puede contener una plaza</p>
 * <p>Los atributos específicos de una silla son</p>
 * <ul>
 *  <li><strong>Posición del respaldo de la silla (valor entero en el rango {@value #MIN_POSICION}-{@value #MAX_POSICION})</strong></li>
 * </ul>
 * 
 * <p>Además los objetos de esta clase contienen atributos que son propios de un mueble de tipo asiento</p>
 * 
 * Dado que implementa la interfaz Ajustable, contiene la información necesaria para poder cumplir los requisitos de esta interfaz.
 * 
 * @author Sergio Garcia Butron
 */
public final class Silla extends Asiento implements Ajustable {
    
    //atributos estáticos constantes público de la Clase Silla
    
    /**
     * Posición mínima del respaldo permitida: {@value #MIN_POSICION}
     */
    public static final int MIN_POSICION=1;
    
    /**
     * Posición máxima del respaldo permitida: {@value #MAX_POSICION}
     */
    public static final int MAX_POSICION=4;
    
    //Atributos privados de la clase Silla
    private int posicionRespaldoSilla;
       
    /**
     * 
     * Crea un objeto Silla con su precio, descripcón, tipo de tapicería y color.
     * 
     * @param precio Precio de la silla (euros)
     * @param descripcion  Descripción de la silla
     * @param color Color de la silla
     * @param tapiceria tapicería de la silla
     * @throws IllegalArgumentException Si alguno de los parámetros es incorrecto
     */
    public Silla(double precio, String descripcion, String color, String tapiceria) 
            throws IllegalArgumentException {
   
            //Inicializo los atributos de Silla mediante el constructor padre: Asiento.
            super(precio, descripcion, Asiento.MIN_PLAZAS, color, tapiceria);        
        
            //Inicializo los atributos especificos de la clase Silla
            this.posicionRespaldoSilla = Silla.MIN_POSICION;
            
    }    
    
    /**
     * Devuelve la <strong>posición del respaldo</strong> de la silla.
     * 
     * @return Número de la posición del respaldo de la silla: {@value #MIN_POSICION}-{@value #MAX_POSICION}
     */
    @Override
    public int obtenerPosicion() {
        //Devuelvo la posición actual del respaldo de la silla.
        return this.posicionRespaldoSilla;
    }
    
    /**
     * 
     * Sube en una posición el respaldo de la silla.
     * 
     * @return Devuelve la posición del respaldo de la silla tras subirlo.
     * @throws IllegalStateException Si no puedo subirse el respaldo de la silla.
     */
    @Override
    public int subirPosicion()
        throws IllegalStateException {
        //Compruebo que la posición nueva del respaldo de la Silla supera el limite superior establecido.
        if (this.obtenerPosicion()+1 > Silla.MAX_POSICION)
            //Lanzo excepcion porque la nueva posicion no es posible para nuestra Silla
            throw new IllegalStateException(String.format("Error: no se puede subir a la posición %d, ya que la posición máxima es %d",
                this.obtenerPosicion()+1,
                Silla.MAX_POSICION));
        else
            //Actualizo el atributo con la nueva posicion del respaldo de nuestrs Silla
            this.posicionRespaldoSilla++;
        
        //Devuelvo la nueva posición del respaldo
        return this.obtenerPosicion();
    }
    
    /**
     * 
     * Baja en una posición el respaldo de una silla
     * 
     * @return Devuelve la posición del respaldo de la silla tras bajarlo.
     * @throws IllegalStateException Si no puedo bajarse el respaldo de la silla.
     */
    @Override
    public int bajarPosicion()
      throws IllegalStateException {
        //Compruebo que la posición nueva del respaldo de la Silla supera el limite superior establecido.
        if (this.obtenerPosicion()-1 < Silla.MIN_POSICION)
            //Lanzo excepcion porque la nueva posicion no es posible para nuestra Silla
            throw new IllegalStateException(String.format("Error: no se puede bajar a la posición %d, ya que la posición mínima es %d",
                this.obtenerPosicion()-1,
                Silla.MIN_POSICION));
        else
            //Actualizo el atributo con la nueva posicion del respaldo de nuestrs Silla
            this.posicionRespaldoSilla--;
        
        //Devuelvo la nueva posición del respaldo
        return this.obtenerPosicion();        
    }
    
    /**
     * Devuelve cadena de texto que representa las carácteristicas de la silla.
     * @return Cadena de texto que representa las carácteristicas de la silla.
     */
    @Override
    public String toString () {
        //Devuelvo la cadena de estado del objeto Padre: Asiento
        //y le añado la infotmración de estado especifica de la clase Silla.
        return String.format("%-161s Posicion actual del respaldo: %-15d",
                super.toString(),
                this.obtenerPosicion());
    }
    
}
