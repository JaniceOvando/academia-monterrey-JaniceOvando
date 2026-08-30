# Concepto 3: Spring WebFlux (Programación Reactiva)

## 1. ¿Qué es y qué problema resuelve?
WebFlux es un framework reactiva para construir aplicaciones web escalables. Resuelve el problema de los servidores tradicionales que se "bloquean" (hilos ocupados) esperando respuestas lentas (como bases de datos o servicios externos). Permite manejar miles de conexiones simultáneas con pocos recursos.

## 2. ¿Dónde se ve en mi código?
- **Mono<T>**: Clase en `WebFluxController.java` (método `getMono`). Representa un flujo de 0 o 1 elemento.
- **Flux<T>**: Clase en `WebFluxController.java` (método `getFlux`). Representa un flujo de 0 a N elementos.
- **Delay**: Uso de `delayElements(Duration.ofSeconds(1))` para simular una fuente de datos lenta sin bloquear el hilo principal.

## 3. ¿Qué pasa si no lo uso?
- **Sin WebFlux (usando Spring MVC tradicional)**: Si un endpoint tarda 5 segundos en responder, el hilo del servidor queda ocupado esperando. Si llegan 100 usuarios, el servidor se llena de hilos esperando y se vuelve lento o se cae.
- **Con WebFlux**: El hilo se libera mientras espera, permitiendo atender otras peticiones.

## 4. Diferencia clave: Lazy
- Los flujos `Mono` y `Flux` son **Lazy (Perezosos)**. No hacen nada hasta que alguien se suscribe (ej. cuando el navegador hace la petición).

## 5. Cómo correrlo
1. En IntelliJ: Click en "Run" en `WebfluxApplication.java`.
2. Abre navegador en `http://localhost:8080/api/flux`.
3. Verás que los datos llegan cada 1 segundo.
4. Abre otra pestaña en `http://localhost:8080/api/mono`. Debería responder al instante, demostrando que el servidor no se bloqueó.