Módulo de Programación DAW (2023/2024): Análisis del Dominio de Java

📝 Introducción al Flujo del Módulo

Este documento presenta un resumen analítico del Módulo de Programación del curso 2023/2024, centrado en el desarrollo de la lógica algorítmica y la aplicación práctica de la Programación Orientada a Objetos (POO) en Java. El recorrido se inició con la comprensión de la sintaxis fundamental (variables, tipos de datos y operadores) para luego estructurar el flujo de ejecución mediante condicionales y bucles. La fase inicial culminó con la implementación de lógica compleja para sistemas como una Máquina Expendedora y la simulación de Formaciones Romanas, sentando las bases sólidas para la abstracción de sistemas y el uso eficiente del depurador del IDE.

💻 Resumen de Proyectos y Tareas de Programación (PROG)Esta tabla resume el temario y los proyectos prácticos implementados durante el módulo de Programación del ciclo DAW/DAM, mostrando la progresión desde la programación estructurada hasta la gestión de bases de datos y la programación avanzada con GUI.

| Tarea | Concepto Destacado | Ejemplos de Implementación / Proyecto Principal | 
| PROG01 | Variables, Tipos y Operadores | Cálculo del volumen de un cilindro. Manejo de operaciones aritméticas complejas. |
PROG02Estructuras de Flujo y DepuraciónLógica de cambio en la Máquina Expendedora (while, switch). Bucles anidados para la Formación Romana de Soldados.PROG03Abstracción de Clases (POO)Creación de las clases Teatro y Dado. Uso de Constructores y métodos getters/setters para la gestión de estado.PROG04Cadenas, Arrays y RegexManipulación avanzada de String. Uso de arrays unidimensionales/bidimensionales (e.g., para festivos). Uso de Expresiones Regulares (Regex) para validación.PROG05Principios POO y Desarrollo de ClasesImplementación completa de la clase Aeronave con Constructores, Métodos de Fábrica, Getters, Setters y lógica de negocio compleja (simulación de vuelo).PROG06Utilización Avanzada de ClasesDiseño de una jerarquía de clases (Mueble, Asiento, Armario). Aplicación de Herencia, Polimorfismo e Interfaces (Ajustable, Personalizable).PROG07Manejo de Estructuras de Datos InternasGestión de un Jardín Botánico (Planta, Especie) utilizando las colecciones ArrayList, HashSet y HashMap para almacenamiento y clasificación eficiente.PROG08Estructuras de Datos Externas (Ficheros)Implementación de persistencia para un Recetario usando tres canales: Texto plano (Streams de caracteres), Serialización binaria (Streams de objetos) y Ficheros XML (DOM/SAX).PROG09Interfaces Gráficas de Usuario (GUI)Creación del Juego Memorízame (Memory Game) usando un framework GUI (ej. JavaFX), implementando el patrón Modelo-Vista-Controlador (MVC) y manejadores de eventos.PROG10Operaciones CRUD sobre Base de DatosGestión completa del ciclo de vida de los datos (CRUD) en una base de datos relacional (ej. H2), manejo de conexión, consultas SQL y la integridad de la información.ConclusiónEstos ejercicios demuestran la capacidad para desarrollar aplicaciones full-stack (lógica de negocio, persistencia, GUI) utilizando los fundamentos de la Programación Orientada a Objetos y estructuras de datos.


Tarea 1: Asentando las Bases de la Programación.

La Tarea Online 01 del módulo de Programación ha sido el punto de partida, actuando como la piedra angular para asentar los conceptos esenciales de la ingeniería de software. El objetivo de esta tarea fue familiarizarse con la estructura canónica de un programa Java, la creación y gestión de paquetes, y el manejo fundamental de los tipos de datos y operadores. Desde el cálculo del volumen de un cilindro hasta la simulación de la gestión de recursos hídricos o las reglas de un parque acuático, cada ejercicio exigió la aplicación rigurosa de variables, constantes y estructuras condicionales (if-else). Esta tarea inicial fue crucial para desarrollar la disciplina de sintaxis y la lógica algorítmica necesarias para abordar la programación orientada a objetos en las unidades posteriores.



Tarea-8: Estructuras de datos externas. Los ficheros.

Esta etapa estableció la persistencia del programa, utilizando los canales de Entrada/Salida (I/O). El objetivo fue asegurar que el estado (la coherencia de los objetos en memoria) no se pierda al finalizar la ejecución, sino que se transfiera al disco. La ejecución se manifestó en la correcta implementación de tres mecanismos de persistencia: Texto plano, Serialización binaria y Ficheros XML. Fue crucial gestionar correctamente las excepciones de I/O (el fallo del disco/sistema) y cerrar todos los recursos (streams) utilizando bloques try-with-resources.

Tarea-9: Creando aplicaciones gráficas de escritorio: Juego de Memoria.

Esta etapa supone la implementación de la Interacción y Presentación Visual, migrando las aplicaciones desde la consola (Entrada/Salida de texto) a una Interfaz Gráfica de Usuario (GUI). El proyecto principal es el desarrollo del Juego Memorízame (Memory Game).
El desafío principal es aplicar el patrón Modelo-Vista-Controlador (MVC), donde:
    • Vista (Coherencia Visual): La interfaz gráfica (el tablero, las cartas) debe ser coherente, intuitiva y visualmente estilizada (uso de CSS/estilos para la estética).
    • Modelo: La lógica de datos (el estado del tablero, las parejas encontradas).
    • Controlador (Lógica de Eventos): La implementación de los manejadores de eventos (ActionEvent) que traducen la acción del usuario (clic en una carta) a una acción en la lógica del juego (voltear la carta, comprobar pareja).
La Lógica del Controlador se enfoca en la implementación para gestionar el flujo del juego: mezcla inicial, gestión del turno (dos clics), comprobación de la coincidencia y bloqueo temporal de la interfaz para evitar errores por concurrencia o múltiples clics.

Tarea-10: Operaciones CRUD sobre una base de datos H2.

Esta tarea finaliza el ciclo de persistencia, implementando el mecanismo de Conexión (JDBC) para interactuar con bases de datos. El objetivo principal es garantizar que la información se gestione de manera estructurada y consistente, manteniendo la integridad de los datos.
Se domina el patrón CRUD (Crear, Leer, Actualizar, Borrar) a través de la interfaz JDBC, empleando un motor de base de datos relacional ligero como H2. Los conceptos clave son:
    1. Conexión: Establecer y cerrar correctamente el enlace/recurso de conexión a la base de datos (usando try-with-resources).
    2. Operaciones DDL: Crear la estructura de tablas (CREATE TABLE), definiendo claves primarias y foráneas para imponer la restricción/integridad de las relaciones.
    3. Operaciones DML (CRUD):
        ◦ Crear (C): Sentencias INSERT (carga inicial de datos).
        ◦ Leer (R): Sentencias SELECT para recuperar datos complejos (ej. joins para obtener películas y sus plataformas).
        ◦ Actualizar (U): Sentencias UPDATE para modificar datos (ej. cambiar el nombre de una plataforma).
        ◦ Borrar (D): Sentencias DELETE para eliminar registros (ej. borrar una plataforma).
    4. Base de Datos OO: Se requiere también el análisis conceptual de las Bases de Datos Orientadas a Objetos como alternativa a la persistencia relacional.
Es fundamental utilizar Sentencias Preparadas (PreparedStatement) para la ejecución eficiente y segura de las consultas, mitigando los riesgos de inyección SQL.

Conclusión y Hoja de Ruta.

La competencia principal adquirida en esta etapa reside en la aplicación rigurosa de la Programación Orientada a Objetos (POO), permitiendo la organización del código en clases y objetos coherentes que modelan entidades reales (Teatros, Dados, Fechas, Aeronaves, Muebles, Plantas). Este dominio se complementa con la habilidad de depuración para garantizar la funcionalidad y estabilidad del código.
