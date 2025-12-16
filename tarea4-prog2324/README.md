📁 Tarea PROG04: Utilizando Cadenas de Caracteres y Arrays (DAW/DAM)
Este repositorio contiene la resolución de la Tarea Online PROG04 del módulo de Programación (CM2), enfocada en el dominio de las estructuras de datos fundamentales de longitud fija y el procesamiento de texto en Java.
El objetivo principal de esta tarea es demostrar la capacidad de gestionar colecciones de datos mediante arrays y de manipular y validar texto de forma eficiente utilizando expresiones regulares.
🎯 Contenidos Clave Trabajados
La tarea se centra en los siguientes conceptos de manipulación de datos:
Arrays Unidimensionales: Declaración, inicialización y recorrido (iteración) para la gestión de listas de elementos.
Arrays Bidimensionales (Matrices): Implementación y procesamiento de estructuras tabulares.
Manipulación de Cadenas (String): Uso de métodos de la clase String para análisis de texto.
Expresiones Regulares (Regex): Aplicación de patrones de búsqueda y validación de formato (ej. seguridad de contraseñas).
Algoritmos de Búsqueda: Implementación de lógica de búsqueda dentro de estructuras de datos.
🧩 Estructura de la Tarea (Ejemplos de Proyecto)
Los ejercicios se encuentran implementados dentro de clases específicas siguiendo la estructura de paquetes definida: es.cifp.programa.ejercicioX.
| Ejercicio | Título del Proyecto | Conceptos Principales |
| 1 | Nivel de Seguridad de Contraseñas | Uso intensivo de Expresiones Regulares para validar la presencia de minúsculas, mayúsculas, números y caracteres especiales. |
| 2 | Juego Campo de Regalos | Uso de arrays bidimensionales para simular un mapa de juego. Lógica de coordenadas (fila/columna) y condiciones de victoria. |
| 3 | Días Festivos y Puentes | Uso de arrays unidimensionales para almacenar y buscar fechas (o indicadores de fecha). Algoritmos de recorrido y búsqueda. |
🚀 Ejecución del Código
Para ejecutar y validar la funcionalidad de los ejercicios, siga los siguientes pasos:
Clone el repositorio en su máquina local.
Abra el proyecto en su IDE de Java (NetBeans, IntelliJ, o Eclipse).
Ejecute la clase principal de cada ejercicio (EjercicioX.java).
Utilice los casos de prueba provistos para verificar la robustez de la lógica.

Ejercicio
Caso de Prueba / Entrada
Resultado Esperado (Lógica)
PROG04-1 (Análisis Lexicográfico)
Entrada de String: "Programacion En Java"
Vocales: 7 (o, a, i, o, e, a, a). Longitud Total: 21. Salida: La cadena en mayúsculas: "PROGRAMACION EN JAVA".
PROG04-1 (Análisis Lexicográfico)
Entrada de String: "1234"
Vocales: 0. Longitud Total: 4. Lógica: Manejo correcto de caracteres no alfabéticos.
PROG04-2 (Gestión de Notas)
Entrada de Notas (Array): {7.5, 5.0, 9.2, 6.8, 4.0}
Promedio: 6.5. Nota Máxima: 9.2. Nota Mínima: 4.0. Lógica: El recorrido del array debe ser completo y sin errores de índice.
PROG04-2 (Gestión de Notas)
Array Vacío (Excepción): {}
Lógica: El código debe manejar la excepción (ej. ArrayIndexOutOfBoundsException o control con if antes de operar) y notificar que no hay datos.
PROG04-3 (Inventario de Almacén)
Array Bidimensional (3x3): {{100, 150, 90}, {200, 180, 250}, {50, 70, 60}} (Filas: Producto A, B, C / Columnas: Mes 1, 2, 3)
Total Producto B (Fila 1): 630. Total Mes 3 (Columna 2): 400. Lógica: Implementación de bucles anidados para sumar correctamente por dimensión (fila o columna).
PROG04-3 (Inventario de Almacén)
Búsqueda de Máximo: Usando la matriz 3x3 anterior.
Máximo: 250 (ocurrió en Producto B, Mes 3). Lógica: Recorrido eficiente de toda la matriz para determinar el valor pico.