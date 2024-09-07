package com.api.v1.book;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookDeletionByIsbnTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulBookDeletion() {
        String isbn = "123456789012";
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted(isbn))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(2)
    void testUnsuccessfulBookDeletion() {
        String isbn = "123456789012";
        webTestClient
                .delete()
                .uri("api/v1/books/%s".formatted(isbn))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
