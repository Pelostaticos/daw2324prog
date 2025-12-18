# 📁 Tarea 06: Utilización avanzada de clases (Jerarquía y Polimorfismo)

Este repositorio contiene la resolución de la Tarea Online PROG06 del módulo de Programación, que se enfoca en la creación de una arquitectura de clases compleja para modelar un dominio específico (probablemente un sistema de Mobiliario Modular).

El objetivo principal es implementar un diseño jerárquico que permita la reutilización de código y la aplicación del Polimorfismo, lo que conduce al Sattva (claridad y buen diseño) en el código.

## 🎯 Contenidos Clave Trabajados

Esta tarea se ha centrado en los siguientes pilares de POO:

Herencia (extends): Diseño de una jerarquía de clases a partir de una clase base (Mueble) y clases intermedias (ej. Asiento, Almacenaje). Esto evita el Tamas (duplicidad de código) al compartir atributos y métodos comunes.
Clases Abstractas: Utilización de la clase base (Mueble) como abstracta para definir la estructura común, pero sin permitir su instanciación directa.
Polimorfismo: Implementación de métodos que se comportan de manera diferente según la clase concreta que los invoca (ej. método toString() o métodos de interfaces).
Interfaces (implements): Definición de contratos (Ajustable, Personalizable) para imponer un comportamiento específico a aquellas clases que los implementen (ej. una Silla es Ajustable, un Armario es Personalizable).
Métodos con Sobrescritura (@Override): Implementación de la lógica específica en las subclases para los métodos heredados o de interfaz.
Uso de la palabra clave super: Invocación de constructores y métodos de la superclase para asegurar la correcta inicialización y flujo de la herencia.
Documentación Javadoc: Documentación completa de todas las clases e interfaces para garantizar el Sattva y la mantenibilidad.

## 🧩 Estructura de la Tarea

La implementación requiere un conjunto de ficheros organizados para reflejar la jerarquía:

Clase Base: Mueble.java (Probablemente Abstracta)
Interfaces: Ajustable.java y Personalizable.java
Clases Intermedias: Asiento.java, Almacenaje.java, Mesa.java.
Clases Concretas: Silla.java, Sillon.java, Sofa.java, Estanteria.java, Armario.java.
Programa de Pruebas: ProgramaPrueba.java (Contiene el main para demostrar el Rajas de la implementación).

## 🚀 Ejecución y Pruebas Clave

Para validar el flujo de la jerarquía y el cumplimiento del Rajas (acción de los métodos), la clase de pruebas debe verificar lo siguiente:
Instanciación de Clases Concretas: Verificar que solo se pueden crear objetos de las clases concretas (Silla, Armario), y que la herencia inicializa correctamente los atributos de Mueble.

Llamadas Polimórficas: Crear un array o lista de Mueble (o de una de las interfaces) y recorrerlo, llamando a un método para asegurar que se ejecuta la versión específica de cada subclase.
Implementación de Interfaces: Verificar que las clases que implementan Ajustable (ej. Silla) responden correctamente a sus métodos (ajustarAltura()) y que otras clases (ej. Armario) responden a los de Personalizable.
Sobrescritura de toString(): Asegurar que el método toString() sobrescrito en cada clase concreta proporciona una representación completa y detallada, incluyendo la información de la superclase.

## 🪛 Depuración: Ejecución y Casos de Prueba

Estos tests están diseñados para verificar la correcta implementación de la Herencia, el Polimorfismo y las Interfaces en el sistema de mobiliario, asegurando que la arquitectura del código es sólida y libre de Tamas.

<u>Jerarquía de Clases y Polimorfismo</u>: El prog debe enfocarse en cómo interactúan las clases concrama de pruebas (ProgramaPrueba.java)retas con sus superclases y las interfaces.

| Escenario | Acción / Código | Salida Esperada | Verificación POO |
| :---: | :---: | :---: | :---: |
| Instanciación (Herencia) | Silla s = new Silla("Gaming", "Rojo", 4);| El objeto s debe tener atributos heredados (ej. Material: "Gaming", Color: "Rojo") y propios (ej. numRuedas: 4). | Check: Constructor de Silla llama a super(...) correctamente. |
| Llamada Polimórfica 1 | Mueble a = new Armario("Roble", 200, 100); a.mostrarEstado(); | Se ejecuta el método mostrarEstado() específico de Armario (o el toString sobrescrito). | Check: Se valida que el Polimorfismo funciona; el compilador llama al método de la clase concreta Armario. |
| Llamada Polimórfica 2 (Interfaz) | Ajustable s1 = new Silla("Metal", "Negro", 5); s1.ajustarAltura(10); | Se ejecuta la implementación de ajustarAltura() de la clase Silla. |Check: Se valida que el método de la Interfaz Ajustable es implementado y ejecutado correctamente por Silla. |
| Implementación de Interfaz | Armario ar = new Armario("Pino", 150, 60); ar.personalizarAcabado("Barniz Mate"); | El atributo acabado del objeto ar cambia a "Barniz Mate". | Check: La clase Armario debe implementar la Interfaz Personalizable y el método debe modificar el estado. |
| Método Sobreescrito | Ejecutar System.out.println(s); sobre un objeto Silla. | Se muestra un texto con el modelo, el color (heredados de Mueble) y el número de ruedas (propio de Silla). | Check: La clase Silla debe sobrescribir el toString() de Mueble y/o Object, y llamar a super.toString() para evitar el Tamas de rehacer la impresión de atributos base. |
| Clase Abstracta (Acción) | Intentar Mueble m = new Mueble("Teka", "Marrón"); | Error de compilación: Mueble es una clase abstracta y no se puede instanciar. | Check: Se confirma que la clase base es abstracta y no se permite su instanciación, forzando la creación de clases concretas. |
| Herencia de Constructor | Crear un objeto Sofa y verificar que el constructor de la superclase Asiento y la superclase Mueble se ejecutan correctamente en orden. | Mensajes de consola (si se han puesto): "Constructor de Mueble", "Constructor de Asiento", "Constructor de Sofa". | Check: Se valida el flujo de la cadena de constructores mediante super(). |

Pruebas de Lógica de Negocio:

| Escenario | Clase / Interfaz | Método | Resultado Esperado |
| :---: | :---: | :---: | :---: |
| Límite de Altura | Silla (Implementa Ajustable) | ajustarAltura(30) | Si la altura máxima es 25, la altura debe mantenerse en 25 (prevención de la acción). |
| Personalización de Modulo | Modulo | agregarElemento("Cajón") | El array o lista interna de Modulo se incrementa con el nuevo elemento. |
| Método en Abstracto | Mueble | calcularPrecioFinal() | Debe forzar la implementación en las clases hijas (Armario, Silla) para que no haya error en el cálculo. |

<u>Profesor</u>: **Jesús María Bono Boyero** | [I.E.S Cristóbal de Monroy](https://www.iescristobaldemonroy.es/wordpress/)

Desarrollado como parte de la formación DAW durante el Curso 2023/2024.