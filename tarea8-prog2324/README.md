# 📁 Tarea 08: Estructuras de datos externas (ficheros)

Este repositorio contiene la resolución de la Tarea Online PROG08 del módulo de Programación. El enfoque principal es la gestión de la persistencia de datos, moviendo el estado de los objetos desde la memoria (el equilibrio del programa) hacia el almacenamiento externo (ficheros) y viceversa.

El dominio modelado es un Recetario digital, donde la información de las Recetas debe ser guardada y recuperada a través de diferentes formatos y canales.

## 🎯 Contenidos Clave Trabajados

Esta tarea se ha centrado en dominar los canales de Input/Output (I/O) de Java, y las técnicas para serializar y deserializar información:

1. **Lectura/Escritura de Ficheros de Texto** (Streams de Caracteres)    
   * <u>Canales</u>: Uso de FileReader/FileWriter y sus versiones bufferizadas (BufferedReader/PrintWriter) para gestionar la entrada y salida de datos en formato de texto.
   * <u>Gestión del Flujo</u>: Implementación de lógica para estructurar los datos del recetario línea por línea (ej. un formato delimitado) durante la escritura y su posterior parsing durante la lectura.
   * <u>Manejo de Excepciones</u>: Uso obligatorio de try-catch para capturar IOException y control de fallos de I/O.
   * <u>Cierre de Streams</u>: Uso de la estructura try-with-resources para garantizar el cierre automático de los flujos, manteniendo la limpieza y el Sattva en la gestión de recursos.
2. **Serialización de Objetos** (Streams Binarios)
   * <u>Persistencia Binaria</u>: Uso de ObjectOutputStream y ObjectInputStream para guardar y recuperar el estado completo de un objeto (o una colección de objetos) de forma binaria.
   * <u>Requisito Vital</u>: Implementación de la interfaz Serializable en las clases de datos (Receta, Ingrediente) para que puedan ser escritas y leídas.
   * <u>serialVersionUID</u>: Gestión del identificador de versión para la serialización.
3. **Ficheros XML** (Estructura de Datos Extensible)
   * <u>Formato de Intercambio</u>: Uso de la API de Java para manipular ficheros XML, que actúan como un formato de intercambio estructurado y legible.
   * <u>Modelos de I/O XML</u>: Implementación de la lectura y escritura usando alguna de las siguientes metodologías:
     * <u>DOM</u> (Document Object Model): Carga todo el documento en memoria para facilitar la navegación y manipulación (útil para ficheros pequeños).
     * <u>SAX</u> (Simple API for XML): Procesamiento secuencial basado en eventos (útil para ficheros grandes).
     * <u>XJAXB</u>: Para mapear objetos Java directamente a XML y viceversa. (Opcional/Avanzado)

## 🚀 Ejemplos de Funcionalidad y Acción

La clase principal de gestión (GestorRecetario.java) debe exponer métodos que demuestren el correcto Rajas sobre los ficheros:

* guardarEnTexto(String nombreFichero)
* cargarDesdeTexto(String nombreFichero)
* serializarRecetario(String nombreFichero)
* deserializarRecetario(String nombreFichero)
* exportarAXML(String nombreFichero)
* importarDesdeXML(String nombreFichero)

## 🪛 Depuración: Ejecución y Casos de Prueba

Estos tests verifican la correcta transferencia del Sattva (el estado de los objetos) a través de los Nadis (Streams de I/O) hacia el disco y su recuperación posterior, asegurando la integridad de los datos.

(**A**) -> <u>El Caso Base se corresponde con la Inicialización de Datos, donde se crea un recetario en memoria con dos recetas para la prueba.</u>

| Objeto de Prueba | Clave / Dato | Valor |
| :---: | :---: | :---: |
| Receta 1 | Nombre | "Tarta de Manzana Clásica" |
| Ingrediente 1 | "Manzanas" | Cantidad: 4 |
| Ingrediente 2 | "Harina" | Cantidad: 200 (gramos) |
| Receta 2 | Nombre | "Sopa de Lentejas Rápida" |
| Ingrediente 1 | "Lentejas" | Cantidad: 300 (gramos) |
| Ingrediente 2 | "Cebolla" |  Cantidad: 1 |

(**B**) -> <u>Persistencia en Texto Plano (Flujo de Caracteres)</u>

Se comprueba la correcta codificación y descodificación de los datos.

| Escenario | Acción / Código | Fichero Resultante (recetario.txt) | Verificación |
| :---: | :---: | :---: | :---: |
| Escritura | GestorRecetario.guardarEnTexto("recetario.txt") | Tarta de Manzana Clásica;Manzanas:4,Harina:200g<br>Sopa de Lentejas Rápida;Lentejas:300g,Cebolla:1| Check: El fichero se crea. El formato delimitado es correcto. El stream se cierra (try-with-resources).|
| Lectura | 1. Eliminar recetario en memoria.<br>2. GestorRecetario. |cargarDesdeTexto("recetario.txt")<br>(Contenido en memoria) | Check: El objeto GestorRecetario contiene las dos recetas exactamente con los mismos datos. Se gestiona FileNotFoundException. |
| Fallo | Intentar leer un fichero que no existe. | Mensaje: "Error: Fichero recetario_no_existe.txt no encontrado." | Check: Se captura FileNotFoundException para evitar el Tamas (la interrupción súbita).

(**C**) -> <u>Serialización de Objetos (Flujo Binario)</u>

Se verifica que el estado de los objetos se mantiene intacto.

| Escenario | Acción / Código | Fichero Resultante (recetario.dat) | Verificación |
| :---: | :---: | :---: | :---: |
| Serialización | GestorRecetario.serializarRecetario("recetario.dat") | Fichero binario de tamaño > 0. | Check: El fichero se crea. La clase Receta implementa Serializable. |
| Deserialización | 1. Eliminar recetario en memoria.</br>2. GestorRecetario.deserializarRecetario("recetario.dat") | (Contenido en memoria) | Check: El recetario se carga. Se comprueba que Receta 1.getNombre() devuelve "Tarta de Manzana Clásica". |
| Fallo de Interfaz | Intentar serializar una clase que no implementa Serializable. | Excepción Esperada: NotSerializableException. | Check: Se valida la robustez ante la omisión del requisito de la interfaz. |

(**D**) -> <u>Persistencia en XML: El flujo estructruturado</u>

Se asegura la correcta estructura jerárquica para el intercambio de datos.

| Escenario | Acción / Código | Fragmento XML Resultante | Verificación |
| :---: | :---: | :---: | :---: |
| **Escritura XML** | GestorRecetario.exportarAXML("recetario.xml") | recetario.xml | Ver abajo contenido |
| **Lectura XML** | Eliminar recetario en memoria.<br>`GestorRecetario.importarDesdeXML("recetario.xml")` | *(Contenido en memoria)* | **Check:** El recetario en memoria se reconstruye a partir de la jerarquía XML. El conteo de ingredientes de la Tarta de Manzana es 2. |
| **Tamas (Fallo de Formato)** | Intentar cargar un XML con una etiqueta de cierre incorrecta (malformado). | **Excepción Esperada:** Excepción de `Parsing` (SAX o DOM). | **Check:** El programa gestiona el **Tamas** de la corrupción de datos y notifica que el fichero no es un XML válido. |

***Contenido del fichero "recetario.xml" tras su escritura:*** 🔍

```xml
<recetario>

   <receta nombre="Tarta de Manzana Clásica">
      <ingrediente nombre="Manzanas" cantidad="4"/>
      <ingrediente nombre="Harina" cantidad="200"/>
   </receta>

   <!-- ... Receta 2 ... -->

</recetario>
```

<u>Profesor</u>: **Jesús María Bono Boyero** | [I.E.S Cristóbal de Monroy](https://www.iescristobaldemonroy.es/wordpress/)

Desarrollado como parte de la formación DAW durante el Curso 2023/2024.