/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase que representa un <strong>Mueble</strong> del tipo <strong>Armario</strong> para la gestión de productos en una tienda de muebles.
 * 
 * <p>Un Armario es un mueble de almacenaje que puede aceptar módulos de cualquier tipo y que contiene una cantidad de puertas.</p>
 * 
 * <p>Los atributos específicos de una Armario, son:</p>
 * <ul>
 *  <li>Número de <strong>puertas</strong> del armario (valor entero en el rango: {@value #MIN_PUERTAS}-{@value #MAX_PUERTAS})</li>
 * </ul>
 * 
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la información propia de un mueble de almacenaje.
 * 
 * @author Sergio Garcia Butron
 */
public final class Armario extends Almacenaje {
    
    //Atributos estáticos constantes público
    /**
     * Número mínimo de puertas permitido para el armario: {@value  #MIN_PUERTAS}
     */
    public static final int MIN_PUERTAS=1;
    
    /**
     * Número máximo de puertas permitido para el armario: {@value  #MAX_PUERTAS}
     */    
    public static final int MAX_PUERTAS=6;
    
    //Atributos privados
    private int numeroPuertas;

    /**
     * 
     * Crea un objeto de tipo Aramario con su precio, descripción, anchiura, altura, número máximo de módulos añadibles y el número de puertas.
     * 
     * @param numeroPuertas Número de puertas que contiene el armario
     * @param anchura Anchura del armario (en cm)
     * @param altura Altura del armario (en cm)
     * @param numeroMaximoModulosAñadir Número máximo de módulos que pueden añadise al armario
     * @param precio Precio del armario (euros)
     * @param descripcion Descripción del armario
     * @throws IllegalArgumentException Si alguno de los argumentos es incorrecto.
     */
    public Armario(double precio, String descripcion, double anchura, double altura, int numeroMaximoModulosAñadir,int numeroPuertas) throws IllegalArgumentException {
        //Llamo al constructor de la clase padre: Almacenaje
        super(anchura, altura, numeroMaximoModulosAñadir, precio, descripcion);
        
        //Compruebo si el número de puertas deseado se encuentra dentro del rango permitido
        if (numeroPuertas < Armario.MIN_PUERTAS || numeroPuertas > Armario.MAX_PUERTAS)
            //Lanzo excepción porque el argumento número de puertas no se encuentra dentro del rango permitido.
            throw new IllegalArgumentException(String.format("No se puede crear el Armario. El número de puertas no está en el rango permitido: %s", numeroPuertas));
        else
            //Actualizo el atributo número de puertas con el valor de su argumento
            this.numeroPuertas = numeroPuertas;
    }

    /**
     * Devuelve el número de puertas que tiene el armario.
     * 
     * @return Número de puertas que tiene el armario
     */
    public int getNumPuertas() {
        return this.numeroPuertas;
    }

    /**
     * Representa una cadena de texto con las características del armario.
     * 
     * @return Cadena de texto con las características del armario
     */
    @Override
    public String toString() {
        return String.format("%-170s Número de puertas: %-10d",
                super.toString(),
                this.getNumPuertas());
    }
    
}
