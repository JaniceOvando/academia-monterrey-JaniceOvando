package com.demojanice.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class WebFluxControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testMonoEndpoint() {
        // Prueba del endpoint /mono
        webTestClient.get()
                .uri("/api/mono")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(result -> {
                    assertNotNull(result);
                    assertEquals("Hola, soy un Mono. Solo devuelvo UN dato.", result);
                });
    }

    @Test
    void testFluxEndpoint() {
        // Prueba del endpoint /flux
        webTestClient.get()
                .uri("/api/flux")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(results -> {
                    assertNotNull(results);
                    assertEquals(5, results.size(), "Debería haber 5 datos");
                });
    }

    @Test
    void testMonoDelayEndpoint() {
        // Prueba del endpoint /lento (simula 5 segundos)
        webTestClient.get()
                .uri("/api/lento")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(result -> {
                    assertNotNull(result);
                    assertEquals("¡Listo! Tardo 5 segundos pero no bloqueo el servidor.", result);
                });
    }
}