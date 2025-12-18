# 📁 Tarea 07: Manejo de estructuras de datos internas (Colecciones)

Este repositorio contiene la resolución de la Tarea Online PROG07 del módulo de Programación, enfocada en la manipulación y gestión eficiente de conjuntos de datos mediante el uso del API de Colecciones de Java.

El dominio modelado para esta tarea es un Jardín Botánico, donde se gestionan colecciones de objetos Planta o Especie para realizar operaciones complejas de almacenamiento, búsqueda, filtrado y ordenación. El objetivo es elegir la estructura de colección adecuada para cada necesidad, garantizando el Sattva (orden y eficiencia) del programa.

## 🎯 Contenidos Clave Trabajados

Esta tarea se ha centrado en los siguientes pilares de la gestión de datos internos:

* <u>Listas (List - ArrayList)</u>: Utilizadas para colecciones ordenadas que permiten duplicados, ideal para el almacenamiento secuencial (ej. la lista principal de todas las plantas).
* <u>Conjuntos (Set - HashSet)</u>: Utilizados para colecciones no ordenadas donde se garantiza que no hay duplicados (ej. obtener una lista única de familias botánicas), crucial para evitar el Tamas (datos redundantes).
* <u>Mapas (Map - HashMap)</u>: Utilizados para almacenar pares de clave-valor, ideal para búsquedas rápidas o clasificaciones (ej. calendario de floración, donde la clave es el mes y el valor es la lista de plantas que florecen).
* <u>Genéricos (<T>)</u>: Uso de genéricos para asegurar la pureza del tipo de dato en las colecciones (ej. List<Planta>, Map<String, List<Planta>>), manteniendo el Sattva del tipo.
* <u>Sobrescritura de equals() y hashCode()</u>: Implementación obligatoria en la clase de datos (Planta o Especie) para que las colecciones de tipo Set o Map identifiquen correctamente los objetos duplicados o las claves.
* <u>Ordenación</u>: Implementación del interfaz Comparable (orden natural) y/o Comparator (orden personalizado) para ordenar las colecciones según diferentes criterios (ej. por nombre científico, por altura).

## 🧩 Estructura de la Tarea

La implementación requiere las siguientes clases y estructuras:

* <u>Clase de Datos</u>: Planta.java o Especie.java (Debe implementar Comparable e incluir equals() y hashCode()).
* <u>Clase de Gestión/Catálogo</u>: JardinBotanico.java (Contiene las colecciones como atributos y los métodos de negocio).
* <u>Programa de Pruebas</u>: ProgramaPrueba.java (Contiene el main para demostrar el Rajas de la gestión de colecciones).

## 🚀 Ejemplos de Funcionalidad

Los métodos implementados en la clase de gestión deben incluir funcionalidades como:

* Añadir y eliminar elementos (Listas y Conjuntos).
* Buscar elementos por clave (Mapas).
* Filtrar elementos (ej. Plantas populares, Plantas de interior).
* Clasificar elementos por una propiedad (ej. clasificar por tipo de suelo usando un HashMap).
* Ordenar la colección resultante.

## 🪛 Depuración: Ejecución y Casos de Prueba

Estos tests están diseñados para verificar la correcta implementación del API de Colecciones en el sistema de gestión de especies del Jardín Botánico. Se busca confirmar el Sattva (orden y pureza) de las estructuras de datos.

Estructura de Colecciones y Manipulación Básica, donde asumimos una clase Planta con atributos: nombreComun, nombreCientifico, tipo (Enum), y métodos de acceso.

| Escenario | Acción / Código | Salida Esperada | Verificación |
| :---: | :---: | :---: | :---: |
| Búsqueda en Lista | List<Planta> jardin = ... / jardin.get(i) o iteración. | Se encuentra la planta "Lavanda" y se muestra su información. | Check: Se valida la búsqueda secuencial o indexada en ArrayList. | 
| Prevención de Duplicados | Intentar añadir dos objetos Planta idénticos a un HashSet<Planta>. | El tamaño del HashSet debe ser 1 (solo se añade una vez). | Check: Se valida la correcta sobrescritura de equals() y hashCode() para que el HashSet evite el Tamas (duplicidad). |
| Clasificación por Mapa | Map<String, List<Planta>> calendario = clasificarPorMesFloracion(); | Las claves del mapa son nombres de meses (ej. "Marzo") y el valor asociado es una List<Planta>. | Check: Se valida la construcción y el uso del HashMap para agrupar datos, demostrando el Rajas (acción) de clasificación. |
| Genéricos | Intentar añadir un String a un ArrayList<Planta>. | Error de compilación. | Check: Se confirma el uso de Genéricos para mantener el Sattva del tipo de dato en la colección. |
| Eliminación por Objeto | Eliminar una instancia de Planta de un ArrayList<Planta>. | El tamaño de la lista se reduce en 1. | Check: Se valida el método remove(Object o) en ArrayList, que depende de la implementación de equals(). |

Pruebas de Lógica de Negocio Avanzada:

|           Escenario            |                                   Clase / Estructura                                   |                                                             Método a Depurar                                                              |                                                              Resultado Esperado                                                               |
| :----------------------------: | :------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------------------------------------------------------------: |
|       Ordenación Natural       |                                      List<Planta>                                      |                                                     Collections.sort(listaDePlantas);                                                     |          Las plantas aparecen ordenadas alfabéticamente por nombreCientifico (asumiendo que es el criterio definido en Comparable).           |
|    Ordenación Personalizada    |                                      List<Planta>                                      |                                                  lista.sort(new ComparadorPorAltura());                                                   |                                             Las plantas se ordenan de la más baja a la más alta.                                              |
|       Búsqueda Eficiente       |              JardinBotanico.buscarPlantaPorNombreCientifico("RosaCanina")              | Tarda menos tiempo si la colección interna está optimizada para la búsqueda (ej. usando un HashMap auxiliar si la búsqueda es por clave). | Check: Se valida que, si la tarea lo requiere, el diseño de la colección interna favorece la eficiencia (evitando el Tamas del código lento). |
| Coincidencias (Set Operations) | Crear dos HashSet (ej. Plantas de Sol y Plantas Perennes) y usar set1.retainAll(set2); |                         El set1 final contiene solo las plantas que cumplen ambas condiciones (la intersección).                          |                Check: Se valida el uso de operaciones de conjuntos para obtener clasificaciones complejas sin bucles manuales.                | Ejemplo de Salida para Clasificación (HashMap) Salida de JardinBotanico.mostrarClasificacionPorTipo(): |

<u>Profesor</u>: **Jesús María Bono Boyero** | [I.E.S Cristóbal de Monroy](https://www.iescristobaldemonroy.es/wordpress/)

Desarrollado como parte de la formación DAW durante el Curso 2023/2024.