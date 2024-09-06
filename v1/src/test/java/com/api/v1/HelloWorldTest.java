package com.api.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulAppExecution() {
        webTestClient
                .get()
                .uri("hello-world")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

}
