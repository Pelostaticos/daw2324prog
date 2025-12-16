📁 Tarea PROG10: Operaciones CRUD sobre una base de datos H2
Este repositorio contiene la resolución de la Tarea Online PROG10 del módulo de Programación. El objetivo es dominar la persistencia de datos en un entorno relacional, utilizando el API JDBC (Java Database Connectivity) para realizar el ciclo de vida completo de los datos (CRUD).
El dominio modelado es un sistema de gestión de contenidos audiovisuales, donde se relacionan Peliculas y Plataformas de streaming.
🎯 Contenidos Clave Trabajados
Esta tarea se ha centrado en abrir el Nadi de Conexión a las bases de datos y en implementar el Rajas (acción) del ciclo CRUD:
1. Conectividad JDBC y Base de Datos H2
Driver: Carga y uso del driver JDBC de H2.
Conexión: Establecimiento de la conexión mediante DriverManager.getConnection().
Cierre de Nadis (Streams): Uso obligatorio de try-with-resources para gestionar la conexión y los statements, asegurando que el Nadi de Conexión se cierre correctamente y evitando el Tamas de la fuga de recursos.
2. Operaciones DDL (Definición de Datos)
Creación de tablas (Plataformas, Peliculas) con tipos de datos adecuados.
Definición de Claves Primarias y Claves Foráneas para asegurar el Rajas de la integridad relacional.
3. Operaciones DML (CRUD - Manipulación de Datos)
Crear (C): Sentencias INSERT para poblar las tablas iniciales.
Leer (R): Sentencias SELECT complejas, incluyendo joins para obtener datos relacionados (ej. Películas y sus plataformas asociadas).
Actualizar (U): Sentencias UPDATE para la modificación de registros existentes.
Borrar (D): Sentencias DELETE para la eliminación de registros.
4. Seguridad y Eficiencia
Sentencias Preparadas (PreparedStatement): Uso de PreparedStatement en lugar de Statement para la inyección segura de parámetros (evitando inyección SQL) y la optimización de las consultas.
Gestión de Resultados: Uso de ResultSet para iterar y extraer los datos del Sattva de la base de datos hacia los objetos en memoria.
🧩 Métodos Implementados (CRUD)
La clase principal de gestión (GestorCine.java) implementa al menos los siguientes métodos CRUD:
crearTablas(): Ejecuta las DDL.
insertarDatosIniciales(): Ejecuta los INSERT.
mostrarPeliculas(): SELECT * FROM Peliculas.
borrarPlataforma(String nombrePlataforma): DELETE FROM Plataformas WHERE ... (Cuidado con las claves foráneas).
modificarPlataforma(String nombreOriginal, String nuevoNombre): UPDATE Plataformas SET ...
mostrarPeliculasPorPlataformas(String nombrePlataforma): SELECT ... JOIN ... WHERE ... (Consulta con relación).

Ejemplos de Ejecución y Casos de Prueba (Depuración) - Tarea PROG10
Estos tests verifican la correcta gestión de la base de datos H2 mediante JDBC, comprobando que las operaciones CRUD se realizan con integridad y que el Nadi de Conexión se maneja correctamente.
Configuración Inicial de la Base de Datos
Se asume la siguiente estructura de tablas:
PLATAFORMAS (ID_PLATAFORMA PK, NOMBRE)
PELICULAS (ID_PELICULA PK, TITULO, ID_PLATAFORMA FK)
1. Prueba de Operación Crear (C) y Leer (R)
Objetivo: Verificar la creación de la estructura, la inserción de datos iniciales y la lectura simple.
Escenario
Acción / Código
Salida Esperada
Verificación
Creación de Tablas
GestorCine.crearTablas()
Mensaje: "Tablas creadas y FK establecidas."
Check: Se verifica que el esquema DDL es correcto y se establece la integridad relacional (Rajas).
Población de Datos
GestorCine.insertarDatosIniciales()
Mensaje: "Datos iniciales insertados."
Check: Se confirman los INSERT (ej. 3 plataformas, 5 películas) mediante una consulta directa.
Lectura Simple
GestorCine.mostrarPeliculas()
Muestra 5 películas en consola, con título y su ID de plataforma asociada.
Check: Se valida el uso de SELECT y la iteración del ResultSet para transferir el Sattva de la BD a la consola.
2. Prueba de Operación Actualizar (U)
Objetivo: Verificar la modificación de un registro.
Escenario
Acción / Código
Salida Esperada
Verificación
Modificación de Plataforma
GestorCine.modificarPlataforma("Netflix", "MegaFlix")
Mensaje: "Plataforma 'Netflix' modificada a 'MegaFlix'."
Check: Se ejecuta un SELECT posterior para confirmar que la plataforma con ID original de Netflix ahora tiene el nombre "MegaFlix". Las películas asociadas no cambian su FK.
3. Prueba de Lectura Relacional (R - JOIN)
Objetivo: Verificar la consulta que requiere un JOIN entre dos tablas.
Escenario
Acción / Código
Salida Esperada
Verificación
Lectura por Plataforma
GestorCine.mostrarPeliculasPorPlataforma("HBO")
Lista de 2 películas (ej. "Succession", "The Last of Us").
Check: Se valida la consulta SELECT ... JOIN ... WHERE NOMBRE = 'HBO' para obtener datos relacionales.
4. Prueba de Operación Borrar (D) y Excepciones
Objetivo: Verificar la eliminación de un registro y el manejo del Tamas (excepciones de integridad).
Escenario
Acción / Código
Salida Esperada
Verificación
Borrar con Integridad
GestorCine.borrarPlataforma("HBO")
Excepción: Se captura una excepción de Integridad de Datos (Foreign Key Constraint Violation) si quedan películas asociadas a "HBO".
Check: Si la plataforma tiene películas, la operación debe fallar. Esto valida que el Rajas de las FK está activo y se gestiona el Tamas del fallo con un try-catch.
Borrar Limpio
1. Borrar todas las películas de la plataforma "HBO".
2. GestorCine.borrarPlataforma("HBO")
Mensaje: "Plataforma 'HBO' borrada correctamente."
Check: Se verifica mediante un SELECT que la plataforma ya no existe.
Cierre de Conexión
Ejecutar el programa completo usando try-with-resources.
Mensaje: "Conexión cerrada automáticamente." (o se verifica con depurador).
Check: Se valida que el Nadi de Conexión se cierra automáticamente, asegurando la liberación de recursos.
