📁 Tarea PROG05: Desarrollo de Clases (POO Avanzado)
Este repositorio contiene la resolución de la Tarea Online PROG05 del módulo de Programación (CM2), cuyo propósito es consolidar los fundamentos de la Programación Orientada a Objetos (POO) mediante la construcción de una clase con arquitectura completa y robusta (simulando una Aeronave o entidad similar).
La tarea se enfoca en asegurar que el objeto cumpla con los principios de la Encapsulación y mantenga un estado interno coherente y válido.
🎯 Contenidos Clave Trabajados
Esta tarea se ha centrado en el desarrollo de la clase, cubriendo los siguientes aspectos fundamentales de POO:
Atributos Privados (Estado): Definición del estado interno de la clase utilizando el modificador de acceso private para controlar la integridad de los datos.
Constructores: Implementación de constructores para inicializar el objeto en diferentes estados iniciales.
Método de Fábrica (Factory Method): Creación de un método estático que devuelve una instancia de la clase, permitiendo una inicialización controlada y con validación previa.
Métodos Mutadores (Setters): Métodos de modificación con lógica de validación para prevenir la entrada de datos erróneos (Tamas) y asegurar un estado interno consistente.
Métodos Consultores (Getters): Métodos de consulta para acceder al estado interno del objeto.
Lógica de Negocio (Métodos de Acción): Implementación de métodos que simulan acciones complejas (como despegar() o aterrizar()) y que modifican el estado de la aeronave basándose en reglas internas.
Método toString(): Personalización del método para ofrecer una representación textual clara del estado actual del objeto.
Documentación Javadoc: Documentación completa de la clase, atributos y métodos para fomentar el Sattva (claridad) en el código.
🧩 Estructura de la Tarea
La implementación se basa principalmente en dos ficheros:
Aeronave.java (o clase principal del modelo): Contiene la implementación de todos los ejercicios (atributos, constructores, métodos de fábrica, getters/setters y lógica de negocio).
ProgramaPrueba.java: Contiene el método main para probar exhaustivamente la funcionalidad de la clase, asegurando que todos los métodos y constructores operen correctamente.
🚀 Ejecución del Código
Para validar el flujo de vida del objeto y el cumplimiento de las condiciones Rajas (esfuerzo y acción), ejecute la clase de pruebas y verifique los siguientes escenarios:
Inicialización con Constructor: Crear una instancia usando un constructor estándar y verificar que los atributos iniciales sean correctos.
Inicialización con Método de Fábrica: Usar el método estático de fábrica para crear una instancia y confirmar que el objeto solo se crea si los parámetros de entrada son válidos.
Transiciones de Estado: Simular el ciclo de vida (creación -> despegue -> vuelo -> aterrizaje) y verificar que el método toString() refleje el estado correcto en cada paso.
Validación de Setters: Intentar modificar un atributo con un valor inválido para asegurar que el setter lo rechace (o aplique un valor por defecto) y lance la excepción o mensaje de error adecuado.

Ejemplos de Ejecución y Casos de Prueba (Depuración) - Tarea PROG05
Los siguientes casos de prueba están diseñados para verificar la correcta implementación de la Programación Orientada a Objetos (POO) en la clase principal (por ejemplo, Aeronave.java) y asegurar que la lógica de negocio se ejecuta sin Tamas (errores).
Clase: Aeronave (Ejemplo de Clase a Desarrollar)
Escenario
Acción / Entrada
Estado Esperado del Objeto (toString())
Verificación (Lógica Interna)
Inicialización (Constructor)
Crear Aeronave a1 = new Aeronave("A-380", 15000, 300);
Aeronave A-380, Combustible: 15000L, Carga Máx: 300kg, Estado: En Hangar.
Check: El constructor debe asignar los valores y establecer el estado inicial a "En Hangar" (o equivalente).
Método de Fábrica (Éxito)
Llamar al método de fábrica estático con datos válidos.
Objeto Aeronave creado.
Check: El método estático debe devolver una instancia VÁLIDA.
Método de Fábrica (Fallo)
Llamar al método de fábrica con combustible < 0 o carga < 0.
Devolver null o lanzar una excepción controlada.
Check: El método debe contener una validación que previene la creación del objeto con datos inválidos (prevención de Tamas).
Acción: Despegue (Éxito)
Ejecutar a1.despegar(2000) (consumo: 2000L).
Estado: En Vuelo, Combustible: 13000L.
Check: El método despegar() resta el combustible, verifica que haya suficiente para el despegue y cambia el estado.
Acción: Despegue (Fallo por Estado)
Ejecutar a1.despegar(1000) estando ya En Vuelo.
Debe mostrar un mensaje de error o lanzar una excepción (ej: "La aeronave ya está en vuelo").
Check: La lógica interna debe validar el estado actual antes de permitir el despegue.
Acción: Aterrizaje
Ejecutar a1.aterrizar().
Estado: En Hangar, Tiempo de Vuelo: X horas/minutos.
Check: El método debe cambiar el estado a "En Hangar" y registrar el tiempo de vuelo o el aterrizaje.
Método Mutador (Setter)
Ejecutar a1.setCargaActual(250).
Carga Actual: 250kg.
Check: El setter debe permitir el cambio si 250 <= Carga Máxima.
Método Mutador (Setter con Tamas)
Ejecutar a1.setCargaActual(500) si la carga máxima es 300kg.
Carga Actual se mantiene sin cambios, o se muestra un mensaje de error (ej: "Carga excede el límite permitido").
Check: El setter debe rechazar el valor inválido para proteger el estado del objeto.
toString()
Ejecutar System.out.println(a1).
Texto formateado claro, incluyendo todos los atributos relevantes (ej: Modelo, Combustible, Carga, Estado).
Check: El formato de salida debe ser claro y legible, útil para la depuración y la interfaz de usuario.

