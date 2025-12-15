/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase que representa un <strong>Mueble</strong> del tipo <strong>Estantería</strong> para la gestión de productos en una tienda de muebles.
 * 
 * <p>Una Estanteria es un muble de almacenaje que sólo puede contener módulos de tipo BALDA.</p>
 * 
 * <p>Los atributos específicos de una Estanteria, son:</p>
 * <ul>
 *  <li><strong>Tipo</strong> de estantería (de pared, de suelo, de encastre, etcétera)</li>
 * </ul>
 * 
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la información propia de un mueble de almacenaje.
 * 
 * @author Sergio Garcia Butron
 */
public final class Estanteria extends Almacenaje {
    
    //Atributos privados
    private final String tipo;
 
    /**
     * 
     * Crea un objeto Estanteria con su precio, descripcion, anchura, altura, número máximo de baldas añadibles y su tipo.
     * 
     * @param tipo Tipo de estantería que es el mueble de almacenaje
     * @param anchura Anchura de la estantería (en cm)
     * @param altura Altura de la estantería (en cm)
     * @param numeroMaximoModulosAñadir Número máximo de baldas que se le pueden aladir a la estantería.
     * @param precio Precio de la estantería (euros)
     * @param descripcion Descripción de la estantería.
     * @throws IllegalArgumentException Si alguno de los argumentos es incorrecto
     */
    public Estanteria(double precio, String descripcion, double anchura, double altura, int numeroMaximoModulosAñadir,String tipo) throws IllegalArgumentException {
        super(anchura, altura, numeroMaximoModulosAñadir, precio, descripcion);
        this.tipo = tipo;
    }

    /**
     * Devuelve el tipo de estantería.
     * 
     * @return Tipo de estantería
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Representa una cadena de texto con las características de la estantería.
     * 
     * @return Cadena de texto con las características de la estantería
     */
    @Override
    public String toString() {
        return String.format("%-170s Tipo: %-10s", super.toString(),
                this.getTipo());
    }

    /**
     * Añade una nueva balda a la estantería.
     * 
     * @param modulo Módulo que se añade a la estantería
     * @throws IllegalStateException Si no se puede añadir más módulos a la estantería
     * @throws NullPointerException Si modulo es nulo
     * @throws IllegalArgumentException  Si el argumento módulo es incorrecto.
     */
    @Override
    public void anyadirModulo(Modulo modulo) throws IllegalStateException, NullPointerException, IllegalArgumentException {
        //Compruebo si el modulo a añadir es de tipo BALDA o nulo
        if (modulo == Modulo.BALDA || modulo==null)
            //El método padre comprueba si el objeto es nulo y lanza su respectiva exception.
            super.anyadirModulo(modulo);
        else
            throw new IllegalArgumentException("Una estantería sólo admite modulos tipo balda");
                            
    }        
            
}
