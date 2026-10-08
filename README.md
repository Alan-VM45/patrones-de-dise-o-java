# Patrones de diseño en Java

Los ejemplos del PDF estaban escritos en Python. Aquí están adaptados a Java y separados por patrón, paquete y archivo. Cada carpeta contiene una clase `Demo` que ejecuta una comprobación funcional.

## Compilar todos los patrones (PowerShell)

Desde esta carpeta:

```powershell
javac -d out (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object FullName)
```

## Ejecutar las demos

```powershell
java -cp out patrones.builder.Demo
java -cp out patrones.prototype.Demo
java -cp out patrones.adapter.Demo
java -cp out patrones.decorator.Demo
java -cp out patrones.facade.Demo
java -cp out patrones.chain.Demo
java -cp out patrones.memento.Demo
java -cp out patrones.observer.Demo
java -cp out patrones.state.Demo
java -cp out patrones.strategy.Demo
```

Cada demo termina con `OK` si sus comprobaciones se cumplen; si no, falla con una excepcion.