package com.api.v1.borrow;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BorrowsRetrievingTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulBooksFinding() {
        String endpoint = "api/v1/borrows/active/%04d/%04d".formatted(2024, 2024);
        webTestClient
                .get()
                .uri(endpoint)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(2)
    void testUnsuccessfulBooksFinding() {
        String endpoint = "api/v1/borrows/active/%04d/%04d".formatted(2023, 2023);
        webTestClient
                .get()
                .uri(endpoint)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
