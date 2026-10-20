# Patrones de diseño en Java

Este repositorio contiene ejemplos didácticos de los 23 patrones clásicos de diseño conocidos como GoF (Gang of Four). La idea no es crear una aplicación de negocio completa, sino mostrar cómo se resuelve un problema recurrente de software con una solución reutilizable.

Las carpetas están organizadas por familia y, dentro de cada familia, por patrón:

- `src/patrones/creacionales/`
- `src/patrones/estructurales/`
- `src/patrones/comportamiento/`

Por ejemplo, el patrón Builder está en `src/patrones/creacionales/builder`.

---

## ¿Qué es un patrón de diseño?

Un patrón de diseño es una solución probada para un problema que aparece muchas veces en programación. No es un framework ni una librería, sino una forma de organizar el código para que sea más claro, flexible y mantenible.

Los patrones no “hacen magia”; simplemente te dan una estructura que ayuda a resolver un problema típico como:

- crear objetos de forma controlada,
- conectar clases y componentes,
- evitar código duplicado,
- organizar responsabilidades,
- comunicar objetos entre sí,
- manejar estados o decisiones complejas.

Cada ejemplo de este proyecto intenta mostrar la idea del patrón mediante una situación pequeña y comprensible.

---

## Las tres familias

### 1) Creacionales: crear objetos

Los patrones creacionales se enfocan en la creación de objetos. Su objetivo es encapsular la lógica de instanciación para no dejar todo el código disperso con `new` por todas partes.

Esto ayuda cuando:

- queremos decidir qué clase concreta crear,
- queremos centralizar la construcción de un objeto complejo,
- necesitamos una sola instancia compartida,
- queremos clonar objetos sin depender de la clase concreta.

Patrones incluidos:

- Abstract Factory
- Builder
- Factory Method
- Prototype
- Singleton

### 2) Estructurales: organizar y conectar componentes

Los patrones estructurales ayudan a formar estructuras más útiles combinando clases u objetos. Su foco está en la composición y la relación entre partes del sistema.

Esto ayuda cuando:

- queremos adaptar una clase para que encaje con otra interfaz,
- combinamos componentes para formar algo más grande,
- queremos añadir responsabilidades sin cambiar la clase base,
- simplificamos el acceso a un subsistema complejo,
- reducimos la duplicación de información.

Patrones incluidos:

- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Proxy

### 3) De comportamiento: cómo colaboran los objetos

Los patrones de comportamiento describen cómo los objetos interactúan, quién responde a una solicitud y cómo se distribuyen responsabilidades.

Esto ayuda cuando:

- hay varios pasos y varios objetos participan,
- queremos cambiar el algoritmo sin tocar el resto,
- hay notificaciones entre varios observadores,
- necesitamos guardar el estado para volver atrás,
- una solicitud debe pasar por una cadena de decisiones.

Patrones incluidos:

- Chain of Responsibility
- Command
- Interpreter
- Iterator
- Mediator
- Memento
- Observer
- State
- Strategy
- Template Method
- Visitor

---

## ¿Qué significa `Demo`?

`Demo` no es un constructor. Es una clase de ejemplo que contiene el método `main`, que es el punto de entrada del programa en Java.

Cuando ejecutas algo como:

```bash
java -cp out patrones.creacionales.builder.Demo
```

lo que ocurre es:

- Java carga la clase `Demo`.
- Busca el método `main`.
- Ejecuta ese método.
- Ahí se crean los objetos, se usan los patrones y se imprime la salida en consola.

En este proyecto, cada `Demo` representa una pequeña historia de negocio o una situación realista para demostrar el patrón. Por ejemplo, se puede estar creando un pedido, una compra, un catálogo o un sistema de mensajes. La clase `Demo` se encarga de preparar la prueba y mostrar el resultado.

---

## ¿Qué es un constructor?

Un constructor es un método especial de una clase que se usa para inicializar un objeto. Tiene el mismo nombre que la clase y no devuelve un valor.

Ejemplo conceptual:

```java
public class Pizza {
    public Pizza(String masa, String salsa, String queso) {
        this.masa = masa;
        this.salsa = salsa;
        this.queso = queso;
    }
}
```

Cuando haces esto:

```java
Pizza pizza = new Pizza("fina", "tomate", "mozzarella");
```

estás llamando al constructor y creando un objeto `Pizza`.

La diferencia es clara:

- `Demo` = clase de prueba / punto de entrada.
- Constructor = parte de una clase que crea e inicializa un objeto.

En este proyecto, `Demo` suele hablar en nombre del problema del patrón, mientras que los otros archivos son las clases que implementan la solución.

---

## Cómo se conectan los archivos: ejemplo de Builder

En la carpeta `src/patrones/creacionales/builder/` encontrarás varios archivos con roles distintos:

- `Demo.java`: punto de entrada. Crea el ejemplo y comprueba el resultado.
- `PizzaDirector.java`: decide el proceso de construcción.
- `PizzaBuilder.java`: recoge cada pieza y crea la pizza final.
- `Pizza.java`: representa el objeto final.

El flujo típico es:

1. `Demo` solicita una pizza al director.
2. El director ordena la construcción.
3. El builder va armando los ingredientes.
4. Se crea el objeto final `Pizza`.
5. `Demo` comprueba que la pizza tenga los valores correctos.

Eso muestra la idea del patrón: no se construye el objeto “a mano” desde distintos lados del código; la creación se centraliza y se hace en un orden controlado.

En otros patrones, la estructura puede variar, pero la idea siempre es la misma: una clase o un conjunto de clases resuelven un problema de organización, creación o colaboración.

---

## ¿Qué están mostrando los demos?

Cada `Demo` no solo imprime `OK`. En realidad, demuestra una situación concreta:

- qué problema aparece,
- qué solución usa el patrón,
- qué efecto tiene en la lógica del programa.

Por ejemplo:

- `Builder` muestra cómo crear un pedido o una pizza paso a paso.
- `Singleton` muestra cómo una configuración global debe compartirse sin crear múltiples copias.
- `Strategy` muestra cómo cambiar la forma de pagar o el algoritmo sin romper la lógica principal.
- `Observer` muestra cómo varios componentes reaccionan a cambios de estado.
- `Facade` muestra cómo ocultar la complejidad de un subsistema complejo detrás de una sola interfaz.

El objetivo no es que el programa sea enorme ni realista, sino que el patrón quede visible y comprensible.

---

## Explicación rápida de cada patrón por familia

### Creacionales

- `Abstract Factory`: crea familias de productos relacionados sin depender de sus clases concretas.
- `Builder`: construye objetos complejos paso a paso y en un orden controlado.
- `Factory Method`: delega la creación de objetos a subclases según el caso.
- `Prototype`: clona objetos existentes en lugar de crear otros desde cero.
- `Singleton`: asegura que solo exista una instancia de una clase.

### Estructurales

- `Adapter`: convierte la interfaz de una clase para que funcione con otra distinta.
- `Bridge`: separa la abstracción de su implementación para que puedan variar por separado.
- `Composite`: trata objetos simples y compuestos de la misma forma.
- `Decorator`: añade comportamiento extra a un objeto sin cambiar su estructura base.
- `Facade`: ofrece una interfaz simple para un sistema más complejo.
- `Flyweight`: comparte objetos pequeños y repetidos para ahorrar memoria.
- `Proxy`: controla el acceso a un objeto, por ejemplo, cargándolo bajo demanda.

### De comportamiento

- `Chain of Responsibility`: cada objeto decide si resuelve la solicitud o la pasa al siguiente.
- `Command`: encapsula una acción como un objeto para poder ejecutarla, deshacerla o encolar.
- `Interpreter`: interpreta un lenguaje o una regla específica.
- `Iterator`: recorre una colección sin conocer su implementación interna.
- `Mediator`: centraliza la comunicación entre varios objetos.
- `Memento`: guarda el estado para poder restaurarlo después.
- `Observer`: notifica automáticamente a los interesados cuando cambia un estado.
- `State`: modifica el comportamiento según el estado actual del objeto.
- `Strategy`: intercambia algoritmos o formas de ejecución en tiempo de ejecución.
- `Template Method`: define una estructura general del algoritmo y deja detalles a las subclases.
- `Visitor`: añade nuevas operaciones a una estructura de objetos sin cambiar sus clases.

---

## Cómo leer este repositorio

Puedes entenderlo como una colección de pequeños ejemplos de software. Cada carpeta representa un patrón concreto y cada clase tiene una responsabilidad clara:

- `Demo.java`: prepara la prueba y muestra el resultado.
- Clases auxiliares: representan las piezas del problema.
- `main`: es el “arranque” del ejemplo.

No hace falta memorizar toda la teoría del patrón de golpe. Lo importante es ver el problema que resuelve y cómo se estructura la solución.

---

## Compilar y ejecutar

Abre PowerShell en la raíz del proyecto y compila todos los archivos Java:

```powershell
javac -d out (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object FullName)
```

Luego ejecuta una demo concreta:

```powershell
java -cp out patrones.creacionales.builder.Demo
java -cp out patrones.estructurales.adapter.Demo
java -cp out patrones.comportamiento.strategy.Demo
```

También puedes ejecutar otros patrones cambiando el paquete y la clase:

```powershell
java -cp out patrones.creacionales.singleton.Demo
java -cp out patrones.estructurales.facade.Demo
java -cp out patrones.comportamiento.observer.Demo
```

El nombre del paquete refleja la familia y el patrón, así que si conoces la carpeta, sabes dónde está la prueba.

---

## Conclusión

Este proyecto no pretende ser una aplicación empresarial completa; pretende ser una guía visual y práctica para entender los patrones de diseño. Cada demo se concentra en un solo problema y una sola solución, para que puedas ver con claridad qué hace cada patrón y por qué vale la pena usarlo.

Si quieres aprender patrones de diseño, lo mejor es ir probando un ejemplo, leer su flujo, entender el problema y luego relacionarlo con una situación real de tu código.

---

## Resumen rápido

- Los patrones ayudan a resolver problemas recurrentes.
- `Demo` es el punto de entrada del ejemplo.
- Un constructor inicializa un objeto.
- Cada carpeta del proyecto representa un patrón distinto.
- La idea no es ver muchos archivos en abstracto, sino conectar cada pieza con una solución concreta.

Si lees este README y ejecutas varios `Demo`, entenderás mucho mejor la lógica detrás de los patrones de diseño en Java.