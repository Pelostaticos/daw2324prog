📁 Tarea PROG02: Uso de Estructuras de Control de Flujo (DAW/DAM)
Este repositorio contiene la resolución de la Tarea Online PROG02 del módulo de Programación (CM2) del Ciclo Formativo de Desarrollo de Aplicaciones Web/Multiplataforma (DAW/DAM).
El objetivo de esta tarea es demostrar el dominio en la escritura y depuración de código, aplicando de forma efectiva las estructuras de control para dirigir el flujo de ejecución de los programas.
🎯 Contenidos Clave Trabajados
La tarea se centra en la aplicación de la lógica de control, cubriendo los siguientes conceptos:
Estructuras de Selección: Uso de if, else if, else y switch para la toma de decisiones.
Estructuras de Repetición: Implementación de bucles (for, while, do-while) para manejar tareas repetitivas.
Depuración de Programas: Uso de breakpoints e inspección de variables para garantizar la funcionalidad (Sattva).
Entrada de Datos: Uso de Scanner para la interacción con el usuario por consola.
🧩 Estructura de la Tarea
Todos los ejercicios se encuentran implementados dentro de clases específicas siguiendo la estructura de paquetes definida: es.cifp.programa.ejercicioX.
Ejercicio
Título del Proyecto
Conceptos Principales
1
Utilización del Depurador del IDE
Uso práctico del depurador, breakpoints y seguimiento de flujo.
2
Máquina Expendedora
Estructuras de selección (switch o if/else) y bucles (while/do-while) para gestión de pagos y cambio.
3
Formación Romana de Soldados
Bucles anidados (for) y lógica matemática para calcular y representar filas y columnas.
4
Simulador de Máquina Tragaperras
Uso de números aleatorios, bucles de juego (do-while) y estructuras de selección para evaluar premios.
🚀 Ejecución y Casos de Prueba
Para ejecutar y validar la funcionalidad de los ejercicios, siga los siguientes pasos:
Clone el repositorio en su máquina local.
Abra el proyecto en su IDE de Java (NetBeans, IntelliJ, o Eclipse).
Ejecute la clase principal de cada ejercicio (EjercicioX.java).
Utilice los siguientes casos de prueba para verificar los resultados:
Ejercicio
Caso de Prueba / Entrada
Resultado Esperado (Lógica)
1
Uso del Depurador
Verificar que el valor de la variable de acumulación cambia correctamente en cada iteración del bucle, y que las condiciones se evalúan según lo esperado.
2
Producto 1 (1.20€), Pago 2.00€
Cambio: 0.80€. Lógica: Uso del bucle para pedir monedas y selección para dispensar cambio.
2
Producto 3 (0.95€), Pago 1.00€
Cambio: 0.05€. Lógica: Manejo de valores float o double y redondeo.
3
Número de Soldados: 120
Formación: 10 filas de 12 soldados (12 x 10). Resto: 0 soldados.
3
Número de Soldados: 85
Formación: 9 filas de 9 soldados (9 x 9 = 81). Resto: 4 soldados.
4
Intentar 3 veces un giro
Lógica: El bucle debe permitir 3 intentos. Premios: Si los tres símbolos son iguales (ej. 🍉 🍉 🍉), el resultado debe ser "Premio Mayor". Si dos son iguales, "Premio Menor".
Desarrollado como parte de la formación DAW/DAM (Curso 2023/2024).
