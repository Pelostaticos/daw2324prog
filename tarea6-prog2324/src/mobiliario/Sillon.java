/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase que representa un <strong>Mueble</strong> de asiento de tipo <strong>Sillón</strong> para la gestión de productos en una tienda.
 *
 * <p>Un sillón es un mueble de tipo asiento que sólo puede contener una plaza.</p>
 * 
 * <p>Los atributos específicos de un sillos son:</p>
 * <ul>
 *  <li><strong>Posición de los pies</strong> del sillón (valor entero: {@value #POS_BAJADO} (bajado) - {@value #POS_BAJADO} (subido)</li>
 * </ul>
 * 
 * <p>Además los objetos de esta clase contienen los atributos propios de un mueble de tipo asiento.</p>
 * 
 * <p>Dado que implementa la interfaz Ajustable, contiene la información necesaria para poder cumplir los requisitos de esta interfaz.</p>
 * 
 * @author Sergio Garcia Butron
 */
public final class Sillon extends Asiento implements Ajustable {
    
    //Atributos estáticos constantes públicos de la Clase Sillón.
    public static final int POS_SUBIDO=1;
    public static final int POS_BAJADO=0;
    
    //Atributos privados de la Clase Sillón.
    private int posicionPiesSillon;

    /**
     * 
     * Crea un objeto Sillón con su precion, descripción, tipo d etapicería y color
     * 
     * @param precio Precio del sillón
     * @param descripcion Descripción del sillón
     * @param color Color del sillón
     * @param tapiceria Tapicería del sillón
     * @throws IllegalArgumentException Si alguno de los argumentos es incorrecto
     */
    public Sillon(double precio, String descripcion, String color, String tapiceria) 
            throws IllegalArgumentException {
        
        //Inicializo los atributos de Silla mediante el constructor padre: Asiento.
        super(precio, descripcion, Asiento.MIN_PLAZAS, color, tapiceria);
            
        //Inicializo los atributos especificos de la clase Sillón 
        this.posicionPiesSillon = Sillon.POS_BAJADO;

            
    }
    
    /**
     * 
     * Devuelve la <strong>posición actual del reposapiés</strong> del sillón
     * 
     * @return Número <strong>posición de los pies</strong> del sillón (valor entero: {@value #POS_BAJADO} (bajado) - {@value #POS_BAJADO} (subido)
     */
    @Override
    public int obtenerPosicion() {
        //Devuelvo la posición actual del reposapie del Sillon.
        return this.posicionPiesSillon;
    }
    
    /**
     * 
     * Sube la posición del reposapiés del sillón.
     * 
     * @return Devuelve la posición del reposapiés tras subirlo.
     * @throws IllegalStateException Si no ha podido subirse el reposapiés del sillón.
     */
    @Override
    public int subirPosicion()
         throws IllegalStateException {
        
        //Compruebo si la posición del reposapies está ya subido
        if (this.posicionPiesSillon==Sillon.POS_SUBIDO)
            //Lanzo excepción para indicar que el reposapies ya está subido
            throw new IllegalStateException("Error: no se pueden subir los pies del sillón. Ya están subidos");
        else {
            //Actualizo la posición del reposapies para el sullón: Subido.
            this.posicionPiesSillon=Sillon.POS_SUBIDO;
        }
        
        //Devuelvo la nueva posición del reposapies
        return this.obtenerPosicion();
        
    }
    
    /**
     * 
     * Baja la posición del reposapiés del sillón.
     * 
     * @return Devuelve la posición del reposapiés tras bajarlo.
     * @throws IllegalStateException Si no ha podido bajarse el reposapiés del sillón.
     */
    @Override
    public int bajarPosicion()
         throws IllegalStateException {
        
        //Compruebo si la posición del reposapies está ya subido
        if (this.posicionPiesSillon==Sillon.POS_BAJADO)
            //Lanzo excepción para indicar que el reposapies ya está subido
            throw new IllegalStateException("Error: no se pueden subir los pies del sillón. Ya están bajados");
        else {
            //Actualizo la posición del reposapies para el sullón: Subido.
            this.posicionPiesSillon=Sillon.POS_BAJADO;
        }
        
        //Devuelvo la nueva posición del reposapies
        return this.obtenerPosicion();
        
    }
    
    /**
     * 
     * Representa una cadena de texto con las carñácteristicas del sillón.
     * 
     * @return Cadena de texto con las carñácteristicas del sillón.
     */
    @Override
    public String toString() {
        //Devuelvo la cadena de estado del objeto Padre: Asiento
        //y le añado la infotmración de estado especifica de la clase Sillón
        return String.format("%-161s Posicion actual de los pies: %-14s",
                super.toString(),
                this.obtenerPosicion() == Sillon.POS_BAJADO ? "bajado" : "subido");
    }
    
}
