package com.demojanice.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebFluxController {

    // 1. MONO: Representa 0 o 1 elemento
    @GetMapping("/mono")
    public Mono<String> getMono() {
        return Mono.just("Hola, soy un Mono. Solo devuelvo UN dato.");
    }

    // 2. FLUX: Representa 0 a N elementos (con retraso para simular lentitud)
    @GetMapping("/flux")
    public Flux<String> getFlux() {
        List<String> datos = new ArrayList<>();
        datos.add("Dato 1");
        datos.add("Dato 2");
        datos.add("Dato 3");
        datos.add("Dato 4");
        datos.add("Dato 5");

        return Flux.fromIterable(datos)
                .delayElements(Duration.ofSeconds(1)); // Retrasa 1 segundo entre cada dato
    }

    // 3. COMPARACIÓN: Endpoint "lento" (simula 5 segundos)
    @GetMapping("/lento")
    public Mono<String> endpointLento() {
        return Mono.delay(Duration.ofSeconds(5))
                .map(l -> "Tardo 5 segundos pero no bloqueo el servidor.");
    }
}