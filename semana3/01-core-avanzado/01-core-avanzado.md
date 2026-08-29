# Concepto 1: Threading, Archivos y Serialización

## 1. ¿Qué es y qué problema resuelve?
Este concepto permite que una aplicación realice múltiples tareas simultáneamente (hilos), maneje datos persistentes (archivos) y guarde el estado de objetos en disco (serialización). Resuelve problemas de lentitud en procesamiento de datos y la necesidad de guardar información entre ejecuciones.

## 2. ¿Dónde se ve en mi código?
- **Hilos/ExecutorService**: Clase `ProcesoHilos.java` (método `main` y `ExecutorService`).
- **Concurrencia**: Uso de `AtomicInteger` en la variable `totalLineas` para evitar condiciones de carrera.
- **Archivos**: Uso de `Files.lines()` y `Files.writeString()` en el método `procesarArchivo`.
- **Serialización**: Clase `ResultadoProceso` implementando `Serializable`, métodos `guardarObjeto` y `leerObjeto`.

## 3. ¿Qué pasa si no lo uso?
- **Sin hilos**: El procesamiento de archivos sería secuencial (mucho más lento).
- **Sin `AtomicInteger`**: El contador `totalLineas` daría valores incorrectos por condiciones de carrera.
- **Sin serialización**: No podríamos guardar el estado de un objeto para usarlo después sin tener que recalcularlo.

## 4. Preguntas clave
- **¿Por qué existe `serialVersionUID`?** Es una versión de serialización. Si cambia, Java no podrá deserializar objetos antiguos. Evita errores de versión.
- **¿Qué le pasa a un campo `transient`?** Se ignora al guardar el objeto. Al leerlo, tendrá el valor por defecto (null para objetos).

## 5. Cómo correrlo
1. En IntelliJ: Click en "Run" (triángulo verde) en `ProcesoHilos.java`.
2. O en terminal: `java -cp out com.ejemplo.hilos.ProcesoHilos`.