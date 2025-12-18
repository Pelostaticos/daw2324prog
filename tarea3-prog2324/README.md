# 📁 Tarea 03: Clases, Objetos y Métodos DAW

Este repositorio contiene la resolución de la Tarea Online PROG03 del módulo de Programación (CM2) del Ciclo Formativo de Desarrollo de Aplicaciones Web/Multiplataforma (DAW/DAM).

El objetivo principal de esta tarea es introducir y aplicar los fundamentos de la Programación Orientada a Objetos (POO), haciendo la transición del código estructurado al diseño basado en clases.

## 🎯 Contenidos Clave Trabajados

La tarea se centra en la aplicación de los flujps de Datos de la POO:
Abstracción: Creación de clases para modelar entidades del mundo real, como pueden ser: Teatro, Dado, Fecha.

* <u>Clases y Objetos</u>: Instanciación y manejo de múltiples objetos de la misma clase.
* <u>Encapsulación</u>: Uso de constructores y métodos (Getters/Setters) para controlar el acceso al estado interno de los objetos.
* <u>Uso de Librerías</u>: Integración de la funcionalidad de la librería estándar de Java (java.time.LocalDate, java.util.Random).
* <u>Formatos de Salida</u>: Aplicación de formatos específicos en la visualización de información por consola.

## 🧩 Estructura de la Tarea

Todos los ejercicios se encuentran implementados dentro de clases específicas siguiendo la estructura de paquetes definida: es.cifp.programa.ejercicioX.

Ejercicio
Título del Proyecto
Clases Creadas
Conceptos Principales
1
Trabajo con Teatros
Teatro, Entrada
Constructores parametrizados, Getters y Setters, uso de final.
2
Lanzamiento de Dados
Dado
Atributos privados, métodos de acción (lanzar()), y uso de la clase Random.
3
Día de Cumpleaños
Fecha
Integración de java.time.LocalDate para manejo de fechas, try-catch básico.

## 🚀 Ejecución y Casos de Prueba

Para ejecutar y validar la funcionalidad de los ejercicios, siga los siguientes pasos:

1. Clone el repositorio en su máquina local.
2. Abra el proyecto en su IDE de Java (NetBeans, IntelliJ, o Eclipse).
3. Ejecute la clase principal de cada ejercicio (EjercicioX.java).

Utilice los siguientes casos de prueba para verificar los resultados:

| Ejercicio | Caso de Prueba / Entrada | Resultado Esperado (Lógica) |
| :---: | :---: | :---: |
| 1 | Teatro: "El Gran Teatro", Aforo: 500, Precio: 35.00€ | Output: Comprobación de que los Getters devuelven los valores correctos (nombre, aforo, precio). Función: Simular la venta de entradas y que el aforo restante se actualice correctamente (500 - 350 = 150 disponibles). |
| 2 | Creación de dos objetos Dado | Salida: El método lanzar() del objeto 1 debe producir un resultado entre 1 y 6 (ej. 3). El método lanzar() del objeto 2 debe producir otro resultado (ej. 5). |
| 2 | Lanzar el dado 100 veces. | Lógica: El bucle debe ejecutar dado.lanzar() 100 veces. Verificación: Los resultados deben estar distribuidos uniformemente entre 1 y 6. | 
| 3 | Fecha de Nacimiento: 18/05/1990 | Salida: La clase Fecha debe almacenar y mostrar la fecha correcta. Cálculo: Debe determinar y mostrar el día de la semana que fue (Viernes) y el número de días transcurridos hasta el día actual. | 
| 3 | Introducir una fecha inválida: 30/02/2024 | Lógica: El programa debe capturar o propagar la excepción adecuadamente (ej. DateTimeParseException o similar), indicando el defecto de la entrada. |

<u>Profesor</u>: **Jesús María Bono Boyero** | [I.E.S Cristóbal de Monroy](https://www.iescristobaldemonroy.es/wordpress/)

Desarrollado como parte de la formación DAW durante el Curso 2023/2024.