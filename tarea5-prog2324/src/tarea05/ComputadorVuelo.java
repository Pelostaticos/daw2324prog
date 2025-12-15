//Paquete al que pertenece la clase ComputadorVuelo
package tarea05;

//Importación de librerías requeridas por la clase
//No se ha precisado ninguna

//Cabecera de la clase
/** 
 * Tarea Online 5: Clase que representa la <strong>simulación básica de un computador de vuelo</strong> ultraligero
 * <p>Los objetos de esta clase contienen atributos que pemriten almacenar información sobre:</p>
 * <ul>
 * <li>Matricula de la aeronave que una vez establecida ya no se puede modificar</li>
 * <li>Modelo de la aeronave que una vez establecido ya no se puede modificar</li>
 * <li>Si esta volando el avión o en tierra</li>
 * <li>nombre del piloto de la aerona</li>
 * <li>Tipo de vuelo que realiza la aeronave</li>
 * <li>El tiempo total de vuelo de la propia aeronave</li>
 * <li>Un mensaje informativo que indicará el estado de la aeronave en un momento dado</li>
 * <li>El rumbo, lka velocidad y altitud de la aeromnave en un momento dado</li>
 * </ul>
 * 
 * Además existe los siguientes atributos de clases que pueden consultarse sin necesidad de instancias de objeto de la clase.
 * <ul>
 * <li>Cantidad total de aeronables creadas</li>
 * <li>Totsl de horas de vuelos de todas las aeronaves</li>
 * <li>Cantidad de aeronaves volando</li>
 * </ul>
 * 
 * Se dispone de una serie de constantes con el objerto de realizar asignaciones por omisión o comprobaciones
 * <ul>
 * <li>Nombre del piloto por omisión</li>
 * <li>Matricula de la aeronave por omisión</li>
 * <li>Modelo de aeronave por omisión</li>
 * <li>Altitud mínima y máxima de la aeronave conforme a normativa</li>
 * <li>Tipos de vuelos que realiza la aeronave: ESCUELA o PRIVADO/li>
 * </ul>
 * 
 * Las acciones que se puede realizar con los objetos instanciados de esta clase, son realizar el despegue y aterrizaje. Además,
 * se premite crear entre 1 y 10 aeronaves en una misma acción.
 * 
 * @author Sergio García Butrón
 * @version 1.0
 *  
 */

public class ComputadorVuelo {
    
    //definición de atributos
    //A) Aquellos que son estáticos de la propia clase
    private static int cantidadTotalAeronaves;
    private static int cantidadAeronavesVolando;
    private static float horasTotalesVueloTodasAeronaves;
    
    //B) Aquellos que son constantes de la propia clase
    /**
     * Valor del piloto por omisión ({@value PILOTO_DEFECTO})
     */
    public final static String PILOTO_DEFECTO = "Juan Pérez";
    /**
     * Valor del matrícula por omisión ({@value MATRICULA_DEFECTO})
     */    
    public final static String MATRICULA_DEFECTO="EC-ABC";
    /**
     * Valor del modelo por omisión ({@value MODELO_DEFECTO})
     */    
    public final static String MODELO_DEFECTO="Cessna 152";
    /**
     * Valor mínimo de altitud de la aeronave conforme normativa ({@value MIN_ALTITUD} metros) 
     */      
    public final static int MIN_ALTITUD=1000;
    /**
     * Valor máximo de altitud de la aeronave conforme normativa ({@value MAX_ALTITUD} metros)
     */          
    public final static int MAX_ALTITUD=3000;
    /**
     * Constante que indica que el tipo de vuelo ({@value VUELO_ESCUELA}=Escuela)
     */          
    public final static int VUELO_ESCUELA=0;
    /**
     * Constante que indica que el tipo de vuelo ({@value VUELO_PRIVADO}=Privado)
     */      
    public final static int VUELO_PRIVADO=1;
    
    //C) Aquellos que son inmutables de instancia de clase
    private final String matriculaAeronave;
    private final String modeloAeronave;    
    //D) Aquellos que son variables de instancia de clase
    //D.1) Estado de la aeronave:
    private boolean volandoAeronave;
    private String nombrePiloto;
    private int tipoVuelo;
    private int tiempoTotalVuelo;
    private String mansajeEstado;    
    //D.2) Información de vuelo:
    private int velocidadAeronave;
    private int rumboAeronave;
    private int altitudAeronave;
    
    //definición de métodos
    //Aquí van todos los métodos constructores deseados.
    //1º) Un constructor con tres parámetros: matrícula, modelo y piloto.
    /**
     * Constructor que creará una instancia que representa una aeronave, identificada
     * por su matrícula, el módelo y el piloto del avión asignado.
     * @param matricula Matrícula de la nueva aeronave
     * @param modelo Modelo de la nueva aeronave
     * @param piloto Piloto asignado a la nueva aeronave
     * @throws NullPointerException Advierte de que algunos de los parámetros son nulos
     * @throws IllegalArgumentException Advierte de que algún parámetro está vacío no cumple el formato
     */
    public ComputadorVuelo(String matricula, String modelo, String piloto)
        throws NullPointerException, IllegalArgumentException {
        
        //Asignación inicial del atributo: Matrícula de la aeronave
        if (matricula == null) {
            throw new NullPointerException("La matricula de la aeronave no puede ser nula");
        } else if (matricula.isEmpty()) {
            throw new IllegalArgumentException("La matricula no puede ser una cadena vacía");            
        } else if (!matricula.startsWith("EC-") || matricula.length() > 6) {
            throw new IllegalArgumentException("El formato de la matricula es incorrecto: " + matricula);
        } else {
            this.matriculaAeronave=matricula;
        }
        
        //Asignación inicial del atributo: Modelo de la aeronave
        if (modelo==null) {
            throw new NullPointerException("El modelo de aeronave no puede ser nulo");
        } else {
            this.modeloAeronave=modelo;
        }
        
        //Asignación inicial del atributo: Piloto de la aeronave
        if (piloto==null) {
            throw new NullPointerException("El piloto de aeronave no puede ser nulo");
        } else {
            this.nombrePiloto=piloto;
        }
        
        //Por defecto la aeronave está en tierra al instanciarse la clase ComputadorVuelo
        this.volandoAeronave=false;
        
        //Por defecto la aeronave es para vuelos de la escuela al instanciarse la clase ComputadorVuelo
        this.tipoVuelo=ComputadorVuelo.VUELO_ESCUELA;
        
        //Por defecto el tiempo total de vuelo al instanciarse la clase ComputadorVuel es cero
        this.tiempoTotalVuelo=0;
        
        //Por defceto los valores de velocidad, rumbo y altitud al instanciarse la clase ComputadorVuelo es cero
        this.velocidadAeronave=0;
        this.rumboAeronave=0;
        this.altitudAeronave=0;
        
        //Por defecto el mensaje de estado indicará que el avión se ha creado con éxito
        this.mansajeEstado = String.format("%s se ha creado con éxito",matricula);
        
        //Incremento la cantidad total de aeronables disponibles
        ComputadorVuelo.cantidadTotalAeronaves++;
        
    }
    
    //2º) Un constructor con dos parámetros: matrícula y modelo.
    /**
     * Constructor que creará una instancia que representa una aeronave, identificada
     * por su matrícula, el módelo y por defecto asigna el piloto por omisión
     * @param matricula Matrícula de la nueva aeronave
     * @param modelo Modelo de la nueva aeronave
     * @throws NullPointerException Advierte de que algunos de los parámetros son nulos
     * @throws IllegalArgumentException Advierte de que algún parámetro está vacío no cumple el formato
     */
    public ComputadorVuelo (String matricula, String modelo) {
        //Invoco al constructor de la clase de tres parámetros
        //El tercer parámetro (piloto) toma su valor por defecto
        this(matricula, modelo, PILOTO_DEFECTO);
    }
    //3º) Un constructor sin parámetros.
    /**
     * Constructor que creará una instancia que representa una aeronave, identificada
     * por la matrícula, el modelo y el piloto por defecto
     * @throws NullPointerException Advierte de que algunos de los parámetros son nulos
     * @throws IllegalArgumentException Advierte de que algún parámetro está vacío no cumple el formato
     */
    public ComputadorVuelo() {
        //Invoco al constructor de la clase de tres parámetros
        //Aquí todos los parámetros tomas sus valores por defecto
        this(MATRICULA_DEFECTO, MODELO_DEFECTO,PILOTO_DEFECTO);
    }
    
    //Aquí van todos los métodos fábrica deseados.
    //1º) Un método "fábrica" con un parámetro: cantidad de aeronaves
    /**
     * Método fábrica para crear un array de la cantidad de aeronaves indicadas como parámetro
     * @param cantidadAeronaves Cantidad de aeronaves a crear con valor comprendido entre 1 y 10
     * @return Array con la cantidad aeronaves indicada como parámetro
     * @throws IllegalArgumentException Advierte que la cantidad de aeronaves está fuera de los límites
     */
    public static ComputadorVuelo[] crearArrayComputadorVuelo (int cantidadAeronaves)
        throws IllegalArgumentException {
        
        //Declaro localmente el Array de ComputadorVuelo
        ComputadorVuelo[] arrayComputadorVuelo;
        
        //Establezo el tamaño del array de ComputadorVuelos si la cantidad es correcta
        if (cantidadAeronaves >=1 && cantidadAeronaves <=10) {
            //Creo el array ComputadorVuelo deseado
             arrayComputadorVuelo = new ComputadorVuelo[cantidadAeronaves];
        } else {
            //Lanzo excepción para mostrar que el parámetro de cantidad de aeronave está fuera del rango 1-10.
            throw new IllegalArgumentException(String.format("Número de aviones incorrecto %d, debe ser mayor o igual que 1 y menor o igual que 10", cantidadAeronaves));
        }
            
        //Fabrico los ComputadoresVuelo y los añado al array
        for (int i=0; i<arrayComputadorVuelo.length ;i++) {
            arrayComputadorVuelo[i] = new ComputadorVuelo();
        }
        
        //Añado el nm?ero de aeronaves creadas al atributo de clase que contiene el número total de aeronaves disponibles
        ComputadorVuelo.cantidadTotalAeronaves += cantidadAeronaves;
        
        //Devuelvo el resultado del método
        return arrayComputadorVuelo;
        
    }
    
    //Aquí van los métodos de consulta y modificación: Getters and setters.
    //1º) Aquellos que trabajan con atributos de objeto: GETTERS -> Obtener información.
    /**
     * Método para consultar la matrícula de la aeronave
     * @see #MATRICULA_DEFECTO
     * @return Devuelve la matricula de la aeronave
     */
    public String getMatricula() {       
        //Devuelvo el atributo de objeto: matriculaAeronave o si está vacio la matrícula por defecto.
        return this.matriculaAeronave.isEmpty() ? ComputadorVuelo.MATRICULA_DEFECTO : this.matriculaAeronave;
    }
    /**
     * Método para consultar el modelo de aeronave.
     * Si el módelo está vacío devuelve su valor por omisión.
     * @see #MODELO_DEFECTO
     * @return Devuelve el modelo de aeronave
     */
    public String getModelo() {
        //Devuelvo el atributo de objeto: modeloAeronave o si está vacio el modelo por defecto.
        return this.matriculaAeronave.isEmpty() ? ComputadorVuelo.MODELO_DEFECTO : this.modeloAeronave;       
    }
    /**
     * Método para consultar si la aeronave está volando o no
     * @return <strong>false</strong> si está en tierra | <strong>true</strong> si está volando
     */
    public boolean isVolando() {
        //Devuelvo el atributo de objeto: volandoAeronave que por defecto estará en tierra (false).
        return this.volandoAeronave;
        
    }
    /**
     * Método para consultar el nombre del piloto de la aeronave.
     * Si el nomnbre del piloto estña vacío devuelve el piloto por omisión.
     * @see #PILOTO_DEFECTO
     * @return Devueve el nombre del piloto de la aeronave
     */
    public String getPiloto() {
        //Devuelvo el atributo de objeto: pilotoAeronave o si está vacio el piloto por defecto.
        return this.nombrePiloto.isEmpty() ? ComputadorVuelo.PILOTO_DEFECTO : this.nombrePiloto;         
    }
    /**
     * Método para consulta el tipo de vuelo que realiza la aeronave.
     * @return Devuelve <strong>0</strong> = Vuelo Escuela | <strong>1</strong> = Vuelo Privado
     */
    public int getTipoVuelo() {
        //Devuelvo el atributo de objeto: volandoAeronave que por defecto estará en tierra (false).
        return this.tipoVuelo;        
    }
    /**
     * Método para consultar el tiempo total de vuelo de la aeronave.
     * @return Devuelve el tiempo total de vuelo de la aeronave en minutos
     */
    public int getTiempoTotalVuelo() {
        //Devuelvo el atributo de objeto: tiempoTotalVuelo que recien creado bede er cero
        return this.tiempoTotalVuelo;
    }
    /**
     * Método para consultar la velocidad de la aeronave en un instante dado.
     * @return Devuele la velocidad de la aeronave en un instante dado (km/h)
     */
    public int getVelocidad() {
        //Si la aerinave no está volando su velocidad debe ser cero
        if (!this.isVolando()) {
            this.velocidadAeronave=0;
        }
        //Devuelvo el valor del atributo de objeto: velocidadAerinave
        return this.velocidadAeronave;
    }
    /**
     * Método para consultar el rumbo de la aeronave en un instante dado.
     * @return Devuelve el rumbo de la aeronave en un instante dado (º)
     */
    public int getRumbo() {
        //Si la aerinave no está volando su velocidad debe ser cero
        if (!this.isVolando()) {
            this.rumboAeronave=0;
        }
        //Devuelvo el valor del atributo de objeto: velocidadAerinave
        return this.rumboAeronave;        
    }
    /**
     * Método para consultar la altitud de la aeronave en un instante dado.
     * @return Devuelve la altitud de la aeronave en metros para un instante dado.
     */
    public int getAltitud() {
        //Si la aerinave no está volando su velocidad debe ser cero
        if (!this.isVolando()) {
            this.altitudAeronave=0;
        }
        //Devuelvo el valor del atributo de objeto: velocidadAerinave
        return this.altitudAeronave;        
    }
    //2º) Aquellos que trabajan con atributos de objeto: SETTERS -> Modificar información
    /**
     * Metodo para actualizar velocidad de la aeronave en un instante dado.
     * @param velocidad Nuevo valor de la velocidad aeronave para ese instante dado.
     * Recuerda que no se admiten valores de velocidad negativos.
     */
    public void setVelocidad(int velocidad) {
        //La velocidad de un objeto no puede ser negativa por física
        if (velocidad<0) {
            //Entonces por defecto la asigno a cero
            this.velocidadAeronave=0;
        } else {
            //Para valores myores o iguales a cero establezco el valor sin controlar un límite máximo
            this.velocidadAeronave=velocidad;
        }
    }
    /**
     * Método para actualizar el rumbo de la aeronave en un instante dado.
     * @param rumbo Nuevo valor de rumbo para ese instante dado.
     * Recuerda que el rumbo debe estar comprendido entre 0º y 360º
     */
    public void setRumbo(int rumbo) {
        //El rumbo del aweronave se base en los puntos cardinales cuyo valores se encuentra entre 0 y 360º
        //Si el valor de rumbo es negativo por defecto debe ser igual cero.
        if (rumbo<0)
            this.rumboAeronave=0;
        //Si el rumbo es mayor a 350º (considero sólo una vuelta a la brújula) por defecto será 360º
        else if (rumbo>360) {
            this.rumboAeronave=360;
        //Sie el valor de rumbo están dentro del rango aceptado lo asigno al atributo.
        } else {
            this.rumboAeronave=rumbo;
        }
    }
    /**
     * Método para actualizar la altitud de la aeronave en un instante dado.
     * @param altitud Nuevo valor de altitud de la aeronave para ese instante dado.
     * Recuerda que la altitud debe estar comprendida entre un valor máximo y mínimo
     * @see #MIN_ALTITUD
     * @see #MAX_ALTITUD
     * 
     */
    public void setAltitud(int altitud) {
        //Si el valor de altiud está compendido entre MIN_ALTITUD y MAX_ALTITUD lo asigno al atributo
        if (altitud < ComputadorVuelo.MIN_ALTITUD || altitud > ComputadorVuelo.MAX_ALTITUD) {
            this.altitudAeronave=ComputadorVuelo.MIN_ALTITUD;
        } else {
            this.altitudAeronave=altitud;
        }
    }
    //3º) Aquellos que trabajan con atributos de clase.
    /**
     * Método de clase para consultar el número de aeronaves disponibles.
     * @return Devuelve el número total de aeronaves creadas.
     */
    public static int getNumAeronaves() {
        //Devuelvo el valor del atributo de clase que contiene el número total de aeronaves disponibles
        return ComputadorVuelo.cantidadTotalAeronaves;
    }
    /**
     * Método de clase para consultar el número total de aeronaves volando.
     * @return Devuelve el número total de aeronaves volando.
     */
    public static int getNumAeronavesVolando() {
        //Devuelve el valor del atributo de clase que contiene el número total de aeronaves volando
        return ComputadorVuelo.cantidadAeronavesVolando;
    }
    /**
     * Método de clase para consultar el número de horas totales de vuelo d etodas las aeronaves
     * @return Devuelve el número total de horas voladas por todas las aeronaves
     */
    public static float getNumHorasVuelo() {
        //Devuelve el valor del atributo de clase que conttiene el número total de horas de vuelo de todas las aeronaves
        return ComputadorVuelo.horasTotalesVueloTodasAeronaves;
    }
    
    //Aquí va el método que inicia un nuevo vuelo: Despegue.
    /**
     * Método que inicia el despegue de una aeronave desde su aeropuerto
     * @param tipoVuelo Establece el tipo de vuelo que realiza la aeronave
     * @param velocidad Establece la velocidad de vuelo de la aeronave
     * @param altitud Establece la altitud de vuelo de la aeronave
     * @throws IllegalStateException Advierte de que la aeronave ya ha despegado previamente
     * @throws IllegalArgumentException Advierte de que la altitud está fuera de los límites normativos
     */
    public void despegar(int tipoVuelo, int velocidad, int altitud) 
        throws IllegalStateException, IllegalArgumentException {
        
        //Controlo si la latitud del nuevo vuelo está entre los límites permitidos
        if (altitud < ComputadorVuelo.MIN_ALTITUD || altitud > ComputadorVuelo.MAX_ALTITUD) {
            throw new IllegalArgumentException(String.format("La altitud de vuelo %d es incorrecta",altitud));
        } else {
            //Controlo si el avión ya ha despegado previamente
            if (this.isVolando()) {
                throw new IllegalStateException(String.format("%s ya ha despegado y se encuentra fuera del aeropuerto",this.matriculaAeronave));
            } else {
                //Aquí el avión se encuentra en el aeropuerto entonces:            
                //Establezco la altitud del nuevo vuelo
                this.altitudAeronave=altitud;
                //Establezco el tipo de vuelo que realiza el avión
                this.tipoVuelo=tipoVuelo;
                //Establezo la velocidad del nuevo vuelo.
                this.velocidadAeronave=velocidad;
                //Establezco que el avión ha despegado y está volando
                this.volandoAeronave=true;
                //Incremento el número de aviones en el aire.
                ComputadorVuelo.cantidadAeronavesVolando++;
            }            
        }        
    }
    
    //Aquí va el método que finaliza el vuelo: Aterrizaje.
    /**
     * Método para finalizar el vuelo de una aeronave hacia un aeropuerto
     * @param aeropuertoSalida Establece el aeropuerto de partida
     * @param aeropuertoLlegada Establece el aeropuerto de aterrizaje
     * @param tiempoVuelo Establece la duración del vuelo en minutos
     * @throws IllegalStateException Advierte que el avión ya ha aterrizado previamente
     */
    public void aterrizar(String aeropuertoSalida, String aeropuertoLlegada, 
            int tiempoVuelo) throws IllegalStateException {
        
        //Controlo que el avión no haya aterrizado previamente
        if (this.isVolando()) {
            //Establezco el mensaje de estado de la aeronave
            this.mansajeEstado = String.format("%s ha volado desde el aeropueto %s a %s",
                this.matriculaAeronave,
                aeropuertoSalida,
                aeropuertoLlegada);
            //Establezco la velocidad del vuelo a acero al aterrizar
            this.velocidadAeronave=0;
            //Establezo la altitud del vuelo a cero al aterrizar
            this.altitudAeronave=0;
            //Acumulo en tiempo de vuelo al tiempo total de vuelo del avión
            this.tiempoTotalVuelo += tiempoVuelo;
            //Acumulo en tiempo de vuelo al número total de horas de vuelo de todas las aeronaves
            ComputadorVuelo.horasTotalesVueloTodasAeronaves += (float) tiempoVuelo / 60.0f;
            //Establezco que el avión ha aterrizado y está en tierra
            this.volandoAeronave=false;
            //Decremento el número de aviones en el aire.
            ComputadorVuelo.cantidadAeronavesVolando--;            
        } else {
            //Lanzo la excepción para indicar que el avión ya ha aterrizado previamente
            throw new IllegalStateException(String.format("%s ya ha aterrizado y debe despegar de nuevo antes de aterrizar",this.matriculaAeronave));            
        }
        
    }
    
    //Aquí el método específico toString() para asociar información identificativa de la clase ComputadorVuelo.
    /**
     * Método para mostrar un texto identificativo de la clase ComputadorVuelo
     * @return Devuelve un texto identificativo de la clase que conttiene la información siguiente
     * <ol>
     * <li>un inicio de bloque o corchete de apertura (carácter [)</li>
     * <li>la matrícula de la aeronave</li>
     * <li>el modelo de la aeronave</li>
     * <li>el valor del atributo volando(indica si está o no volando)</li>
     * <li>el nombre del piloto</li>
     * <li>el tipo de vuelo que está realizando</li>
     * <li>el tiempo total de vuelo</li>
     * <li>la velocidad</li>
     * <li>el rumbo</li>
     * <li>la altitud</li>
     * <li>un fin de bloque o corchete de cierre (carácter ])</li>
    * </ol>
     * Presenta el formato: [Matricula=EC-FA3, Modelo=Eurostar Evektor EV-97, isVolando=false, Piloto=Pepito Pérez, TipoVuelo=1, TiempoTotal=230, V=0 km/h, Rumbo=0º, Altitud=0 metros]
     * 
     */
    @Override
    public String toString() {
        
        //Devuelvo el texto identificativo de la clase ComputadorVuelo
        return String.format("[Matricula=%s, Modelo=%s, isVolando=%b, Piloto=%s]"
                + ", TipoVuelo=%d, TiempoTotal=%d, V=%d km/h, Rumbo=%dº, Altitud=%d metros]",
                this.matriculaAeronave,
                this.modeloAeronave,
                this.isVolando(),
                this.nombrePiloto,
                this.tipoVuelo,
                this.tiempoTotalVuelo,
                this.velocidadAeronave,
                this.rumboAeronave,
                this.altitudAeronave);
        
    }
    
}
