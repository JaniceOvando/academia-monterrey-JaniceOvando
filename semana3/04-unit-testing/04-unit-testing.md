# Concepto 4: Unit Testing con JUnit y Mockito

## 1. ¿Qué es y qué problema resuelve?
El Unit Testing permite probar unidades individuales de código (métodos, clases) de forma aislada para asegurar que funcionan correctamente. Resuelve el problema de que los errores pasen desapercibidos hasta que se produce en producción. JUnit es el framework estándar para tests en Java, y Mockito permite simular (mockear) dependencias externas para probar solo la lógica de tu clase.

## 2. ¿Dónde se ve en mi código?
- **JUnit 5**: Archivo `WebFluxControllerTest.java` en `src/test/java/com/demojanice/webflux/`.
- **Tests**: Métodos `@Test` como `testMonoEndpoint`, `testFluxEndpoint`.
- **Asserts**: Uso de `assertEquals`, `assertNotNull` para verificar resultados.
- **WebTestClient**: Cliente de prueba para hacer peticiones HTTP a los endpoints de la API.
- **Mockito**: (Opcional, si usas servicios mockeados). Aquí usamos `WebTestClient` para probar los endpoints reales de forma aislada.

## 3. ¿Qué pasa si no lo uso?
- Los errores de lógica no se detectan hasta que el usuario los encuentra.
- No hay garantía de que las actualizaciones del código no rompan funcionalidades existentes.
- Es difícil refactorizar código sin miedo a romper algo.

## 4. Experimento: ¿Cómo demostré que los tests son reales?
1. **Rompi el código a propósito**: Cambié el texto de retorno en el método `getMono()` a `"Hola, soy un Mono. Solo devuelvo UN dato ERRADO."`.
2. **Corrí los tests**: El test `testMonoEndpoint` falló en rojo, mostrando que el valor esperado no coincidía con el real.
3. **Reparé el código**: Volver a poner el texto original hizo que el test pasara en verde.
   Esto demuestra que los tests están verificando la lógica real y no son solo "acompañantes".

## 5. Cómo correr los tests
1. En IntelliJ, haz clic en el botón **Run** (triángulo verde) junto a `WebFluxControllerTest.java`.
2. O en la terminal, dentro de la carpeta `webflux`:
   ```bash
   mvn test