-- ***************************************************************
-- FICHERO: creaDB.sql
-- DESCRIPCION: Script DDL para la creación de la estructura de la
--              base de datos del ejercicio de la Tarea 10.
--              Contiene las sentencias CREATE TABLE, CREATE INDEX,
--              y la definición de claves primarias/foráneas.
-- AUTOR: Sergio García Butrón <contacto@bitgharcia.es>
-- ***************************************************************

-- Se eliminan las tablas si existen
DROP TABLE IF EXISTS Disponible_en;
DROP TABLE IF EXISTS Plataformas;
DROP TABLE IF EXISTS Peliculas;

--
-- Estructura de las tablas
--
CREATE TABLE Peliculas (
    codigo INTEGER PRIMARY KEY,
    titulo VARCHAR(50) UNIQUE NOT NULL,
    sinopsis TEXT NULL,
    fEstreno DATE
);

CREATE TABLE Plataformas (
    codigo INTEGER PRIMARY KEY,
    nombre VARCHAR(30) UNIQUE NOT NULL,
    unLogotipo TEXT NULL
);

CREATE TABLE Disponible_en (
    codPlataforma INTEGER,
    codPelicula INTEGER,
    fDisponibilidad DATE PRIMARY KEY,
    CONSTRAINT pelicula_disponible_fk FOREIGN KEY (codPelicula) REFERENCES Peliculas (codigo),
        /* No veo sentido usar esta primera cláusula SQL porque mientras haya plataforma que emitan una película
        no podrá eliminarse de la plataforma.
       ON DELETE CASCADE
       Esta segunda cláusula SQL si puede tener más sentido por alguna necesidad de operativa del sistema.
       ON UPDATE CASCADE, */
    CONSTRAINT plataforma_disponible_fk FOREIGN KEY (codPlataforma) REFERENCES Plataformas (codigo)
       /* Para evitar el mensaje de error de integridad al borrar una plataforma con películas disponibles
        seria recomendable incluir la clausula SQL siguiente para que al desaparecer una plataforma desaparezca
        también todo su contenido, ya que en el mundo real los clientes ya no podrán acceder a ella.
        ON DELETE CASCADE
        Sería interesante añadir esta otra cláusula SQL para que si la plataforma cambia su código se actualice
        de forma recursiva en todos los recursos existente en en esta tabla
        ON UPDATE CASCADE */
);