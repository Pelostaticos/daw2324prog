/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

//Librerias importadas requeridas por clase Almacenaje
import java.util.Arrays;

/**
 * 
 * Clase abstracta que representa un <strong>Mueble</strong> de tipo <strong>Almacenaje</strong> para la gestión de productos en una tienda de muebles. 
 * 
 * <p>Los atributos específicos de este mueble que sirve para almacenar, son:</p>
 * <ul>
 *  <li><strong>Anchura</strong> del mueble (en cm).</li>
 *  <li><strong>Altura</strong> del mueble (en cm).</li>
 *  <li><strong>Número máximo de módulos que se pueden añadir</strong> al mueble (valor entero: {@value #MIN_MODULOS}-{@value #MAX_MODULOS})</li>
 *  <li><strong>Número de módulos que se han añadido</strong> al mueble.</li>
 * </ul>
 * 
 * Los objetos de esta clase contienen atributos propios que le permiten guardar la información de un mueble.
 * 
 * <p>Se trata de una clase abstracta que contiene la información mínima sobre el mueble 
 * de tipo almacenaje pero no contiene información que depende del almacenaje concreto 
 * (si se trata de una estantería o un armario). Para eso existen otras clases especializadas 
 * que heredarán de ésta.</p>
 * 
 * Dado que implementa la interfaz Personalizable, contiene la información necesaria para poder cumplir los requisitos de esta interfaz.
 * 
 * @author Sergio Garcia Butron
 */
public abstract class Almacenaje extends Mueble implements Personalizable {
    
    //atributos estáticos constantes públicos
    
    /**
     * Mínimo número de módulos de un mueble de almacenaje: {@value #MIN_MODULOS}
     */
    public static final int MIN_MODULOS=1;
    
    /**
     * Máximo número de módulos de un mueble de almacenaje: {@value #MAX_MODULOS}
     */
    public static final int MAX_MODULOS=20;
    
    //Atributos protegidos
    
    /**
     * Contador del número de módulos añadidos al mueble de almacenaje.
     */
    protected int numeroModulosAgergados;
    
    //Atributos privados
    private Modulo[] modulos;
    private double anchura;
    private double altura;
    private final int numeroMaximoModulosAgregar;

    
    /**
     * 
     * Crea un mueble del tipo Almacenaje con su precio, descripción, número máxmo de módulos agregables, anchura y altura.
     * 
     * @param anchura Anchura del mueble de almacenaje (en cm)
     * @param altura Altura del mueble del almacenaje (en cm)
     * @param numeroMaximoModulosAñadir Número máximo de módulos que se le pueden añadir
     * @param precio Precio de mueble de almacenaje (euros)
     * @param descripcion Descripción del mueble de almacenaje
     * @throws IllegalArgumentException  Si alguno de los argumentos es incorrecto
     */
    public Almacenaje(double anchura, double altura, int numeroMaximoModulosAñadir, double precio, String descripcion) throws IllegalArgumentException {
        //Llamo al constructor de la clse padre: Mueble
        super(precio, descripcion);
        //Compruebo que el número máximo de módulos añadibles está dentros del rango aceptado
        if (numeroMaximoModulosAñadir < Almacenaje.MIN_MODULOS || numeroMaximoModulosAñadir > Almacenaje.MAX_MODULOS) 
            // Lanzo exception porque el argumento del número máximo de módulo de Almacenaje es incorrecto
            throw new IllegalArgumentException(String.format("ERROR: No se puede crear el mueble de Almacenaje. El número de módulos no está en el rango permitido: %d",
                        numeroMaximoModulosAñadir));
        else {
            //Actualizo el atributo anchura de Almacenaje
            this.anchura = anchura;
            //Actualizo el atributo altura de Almacenaje
            this.altura = altura;
            //Actulizo el atributo para el número máximo de módulos añadibles a Almacenaje.
            this.numeroMaximoModulosAgregar = numeroMaximoModulosAñadir;
            //Inicializo el array que contiene los módulos añadibles al Almacenaje.
            this.modulos = new Modulo[this.numeroMaximoModulosAgregar];
            //Añado el primer módulo de Almacenaje: BALDA
            this.modulos[0] = Modulo.BALDA;
            //Actualizo el contador de módulos agregados a Almacenaje.
            this.numeroModulosAgergados++;
        }
        
    }

    /**
     * Devuelve el número de módulos añadidos al mueble de almacenaje.
     * 
     * @return Número de módulos añadidos al mueble de almacenaje
     */
    public int getModulosAnyadidos() {
        return numeroModulosAgergados;
    }

    /**
     * Devuelve la anchura del mueble de almacenaje.
     * 
     * @return Anchura del mueble de almacenaje
     */
    public double getAnchura() {
        return anchura;
    }

    /**
     * Devuelve la altura del mueble de almacenaje.
     * 
     * @return Altura del mueble de almacenaje
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Devuelve el número mácimo de módulos que le se pueden añadir al mueble de almacenaje. 
     * 
     * @return Número mácimo de módulos que le se pueden añadir al mueble de almacenaje
     */
    public int getNumModulos() {
        return numeroMaximoModulosAgregar;
    }

    /**
     * Representa una cadena de texto con las caracteristicas de un mueble de almacenaje.
     * 
     * @return Cadena de texto con las caracteristicas de un mueble de almacenaje
     */
    @Override
    public String toString() {
        return String.format("%-90s Anchura: %-16.2f Altura: %-9.2f Modulos máximo: %-10d Módulos añadidos: %-10d",
            super.toString(),
            this.getAnchura(),
            this.getAltura(),
            this.getNumModulos(),
            this.getModulosAnyadidos());
    }

    /**
     * Devuelve cadena de texto con los módulos añadidos al mueble de almacenaje.
     * 
     * @return Cadena de texto con los módulos añadidos al mueble de almacenaje
     */
    @Override
    public String obtenerModulos() {
        return Arrays.deepToString(this.modulos);
    }

    /**
     * 
     * Añade un módulo al mueble de almacenaje.
     * 
     * @param modulo Tipo del módulo que se le añade al mueble de almacenaje
     * @throws IllegalStateException Si el módulo indicado es incorrecto.
     * @throws NullPointerException Si modulo es nulo.
     * 
     */
    @Override
    public void anyadirModulo(Modulo modulo) throws IllegalStateException, NullPointerException {
        //Compruebo si el argumento módulo es nulo
        if (modulo==null)
            throw new NullPointerException("Error: el módulo a añadir no puede ser nulo");
        
        //Compruebo si puedo extraer más modulos a Almacenaje
        if (this.getModulosAnyadidos()+1 > this.getNumModulos())
            throw new IllegalStateException(String.format("Error: no se puede añadir el módulo %s. El número de módulos no puede superar el máximo permitido: %d",
                    modulo,
                    this.getNumModulos()));
        
        //Incremento el contador de módulos de almacenaje añadidos
        this.numeroModulosAgergados++;
        
        //Añado el módulo de Almacenaje deseado
        this.modulos[this.getModulosAnyadidos()-1] = modulo;
        
    }

    /**
     * Extrae del mueble de almacenaje un módulo y lo devuelve.
     * 
     * @return Módulo del mueble de almacenaje extraido
     * @throws IllegalStateException Si no se puede extraer un módulo del mueble de almacenaje
     */
    @Override
    public Modulo extraerModulo() throws IllegalStateException {
        //Compruebo si puedo extraer más modulos a Almacenaje
        if (this.getModulosAnyadidos()-1 < Almacenaje.MIN_MODULOS)
            throw new IllegalStateException(String.format("Error: no se puede quitar el módulo. El número de módulos no puede ser inferior a %s",
                    Almacenaje.MIN_MODULOS));
        
        //Obtengo el módulo de Almacenaje de la última posición que quiero extraer
        Modulo moduloExtraido = this.modulos[this.getModulosAnyadidos()-1];

        //Establezco a nulo la posición del módulo de almacenaje extraido
        this.modulos[this.getModulosAnyadidos()-1] = null;
        
        //Decremento el contador de módulos de Almacenaje añadidos
        this.numeroModulosAgergados--;        
        
        //Devuelvo el módulo extraido
        return moduloExtraido;
    }
           
}
