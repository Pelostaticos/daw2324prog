/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase que representa un <strong>Mueble</strong> del tipo <strong>Mesa</strong> para la gestión de productos en una tienda de muebles.
 * 
 * <p>Los atributos específicos de una Mesa, son:</p>
 * <ul>
 *  <li><strong>Forma</strong> de la mesa (Cuadrada, Redonda, Ovalada, etcétera)</li>
 *  <li>Número de <strong>comensales</strong> de la mesa (valor entero en el rango: {@value #MIN_COMENSALES}-{@value #MAX_COMENSALES})</li>
 * </ul>
 * 
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la información propia de un mueble.
 * 
 * @author Sergio Garcia Butron
 */
public final class Mesa extends Mueble {
    
    //Atributos estáticos constantes públicos
    /**
     * Número mínimo de comensales permitidos en la mesa: {@value #MIN_COMENSALES}
     */
    public static final int MIN_COMENSALES=4;
    
    /**
     * Número máximo de comensales permitidos en la mesa: {@value #MAX_COMENSALES}
     */
    public static final int MAX_COMENSALES=16;

    
    //Atributos privados
    private final String forma;
    private final int numeroComensales;

    /**
     * 
     * Crea un objeto Mesa con su precio, descripción, forma y número de comensales.
     * 
     * @param forma Forma que tiene la mesa
     * @param numeroComensales Número de comensales que tiene la mesa
     * @param precio Precio de la mesa (euros)
     * @param descripcion Descripcion de la mesa
     * @throws IllegalArgumentException Si alguno de los argumentos es incorrecto
     */
    public Mesa(double precio, String descripcion, String forma, int numeroComensales) throws IllegalArgumentException {
        //Llamada al constructor de la clase padre: Mueble
        super(precio, descripcion);
        
        //Compruebo si el número de numeroComensales está dentro del rango permitido
        if (numeroComensales < Mesa.MIN_COMENSALES || numeroComensales > Mesa.MAX_COMENSALES)
            throw new IllegalArgumentException(String.format("El número de comensales no está dentro del rango permitido: %d",
                    numeroComensales));
        else {
            //Actualizo los atributos: Forma y número de numeroComensales
            this.forma = forma;
            this.numeroComensales = numeroComensales;           
        }

    }

    /**
     * Devuelve el número de comensales que permite la mesa.
     * 
     * @return Número de comensales que permite la mesa
     */
    public int getComensales() {
        return this.numeroComensales;
    }

    /**
     * Devuelve la forma que tiene la mesa.
     * @return Forma que tiene la mesa
     */
    public String getForma() {
        return this.forma;
    }

    /**
     * Representa una cadena de texto con las caractertísticas de la mesa.
     * 
     * @return Cadena de texto con las caractertísticas de la mesa
     */
    @Override
    public String toString() {
        return String.format("%-90s Forma: %-18s Número de comensales: %-10d",
                super.toString(),
                this.getForma(),
                this.getComensales());
    }
      
}
