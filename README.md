# Patrones de diseño en Java

Este proyecto contiene ejemplos sencillos de los 23 patrones clasicos GoF. Las carpetas estan organizadas primero por familia y despues por patron. Por ejemplo, Builder esta en `src/patrones/creacionales/builder`.

## Las tres familias

### 1. Creacionales: crear objetos

Ayudan a decidir como se crean los objetos, sin repartir por todo el programa el detalle de usar `new`.

- **Abstract Factory** (`abstractfactory`): crea familias de objetos compatibles.
- **Builder** (`builder`): arma un objeto complejo paso a paso.
- **Factory Method** (`factorymethod`): delega en una subclase la eleccion del objeto que se crea.
- **Prototype** (`prototype`): crea un objeto copiando otro existente.
- **Singleton** (`singleton`): ofrece una unica instancia compartida de una clase.

### 2. Estructurales: conectar y organizar objetos

Muestran como combinar objetos o clases para formar estructuras utiles.

- **Adapter** (`adapter`): adapta una interfaz para que dos componentes incompatibles colaboren.
- **Bridge** (`bridge`): separa una funcionalidad de su implementacion.
- **Composite** (`composite`): permite tratar un objeto individual y un grupo de objetos de la misma manera.
- **Decorator** (`decorator`): agrega una responsabilidad envolviendo un objeto.
- **Facade** (`facade`): ofrece una entrada simple a un subsistema complejo.
- **Flyweight** (`flyweight`): comparte datos comunes para ahorrar memoria.
- **Proxy** (`proxy`): controla el acceso a otro objeto.

### 3. De comportamiento: repartir tareas y comunicacion

Definen como colaboran los objetos, quien hace cada trabajo y como se intercambian solicitudes o cambios.

- **Chain of Responsibility** (`chain`): pasa una solicitud por varios manejadores posibles.
- **Command** (`command`): convierte una accion en un objeto que puede ejecutarse despues.
- **Interpreter** (`interpreter`): representa y evalua expresiones de una gramatica.
- **Iterator** (`iterator`): recorre una coleccion sin revelar como esta almacenada.
- **Mediator** (`mediator`): centraliza la comunicacion entre varios objetos.
- **Memento** (`memento`): guarda y restaura un estado anterior.
- **Observer** (`observer`): avisa a varios suscriptores cuando algo cambia.
- **State** (`state`): cambia el comportamiento de un objeto segun su estado.
- **Strategy** (`strategy`): permite cambiar un algoritmo por otro intercambiable.
- **Template Method** (`templatemethod`): fija los pasos de un algoritmo y deja algunos pasos a las subclases.
- **Visitor** (`visitor`): agrega operaciones a tipos de objetos sin poner esas operaciones dentro de cada tipo.

## Que es `Demo` y que es un constructor

`Demo` no es un constructor. Es una clase de ejemplo que tiene el metodo especial `main`; Java empieza a ejecutar el programa desde ese metodo. En este repositorio, cada `Demo` prepara una situacion concreta y muestra en consola como colaboran los objetos y cual es el resultado. Tambien realiza comprobaciones internas; si un resultado no es el esperado, lanza un error.

Un **constructor** es una parte de una clase que inicializa un objeto. Tiene el mismo nombre que la clase y no declara un tipo de retorno. Por ejemplo, en `Pizza.java`, `Pizza(String masa, String salsa, String queso)` es un constructor: recibe los ingredientes y los guarda en la pizza. La expresion `new Pizza(...)` llama a ese constructor para crear el objeto.

Una clase tambien puede no declarar ningun constructor; Java le proporciona uno vacio automaticamente. Por eso puede aparecer `new PizzaBuilder()` aunque `PizzaBuilder.java` no tenga un constructor escrito.

## Como se conectan los archivos: ejemplo Builder

En `src/patrones/creacionales/builder/` hay cuatro archivos y cada uno tiene un papel distinto:

- `Demo.java`: punto de entrada para probar el ejemplo. Llama al director y comprueba los ingredientes obtenidos.
- `PizzaDirector.java`: indica el orden de construccion de una Margarita.
- `PizzaBuilder.java`: recibe cada ingrediente y, al final, crea la pizza completa.
- `Pizza.java`: es el objeto final; guarda la masa, la salsa y el queso.

El recorrido es: `Demo.main` pide una Margarita al `PizzaDirector`; el director configura el `PizzaBuilder`; `build()` crea y devuelve una `Pizza`; por ultimo, `Demo` muestra los ingredientes y verifica sus valores. Esa colaboracion, y no un solo archivo, es la implementacion del patron.

En otros patrones puede haber menos archivos. Algunos ejemplos ponen las clases auxiliares dentro de `Demo.java` para mantener el ejemplo corto; eso no cambia la idea del patron.

## Compilar y ejecutar

Abre PowerShell en la carpeta del proyecto y compila todos los archivos:

```powershell
javac -d out (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object FullName)
```

Luego ejecuta una demo usando el nombre completo del paquete y la clase. Por ejemplo:

```powershell
java -cp out patrones.creacionales.builder.Demo
java -cp out patrones.estructurales.adapter.Demo
java -cp out patrones.comportamiento.strategy.Demo
```

El nombre despues de `patrones.` contiene la familia y el patron, igual que las carpetas bajo `src/patrones`. `Demo` es la clase que contiene `main`. Al ejecutar Builder veras la pizza creada y sus ingredientes; en Strategy veras el mismo pago procesado con dos metodos distintos. Para ejecutar otro patron, cambia la familia y el nombre del patron; por ejemplo, `patrones.estructurales.proxy.Demo`.