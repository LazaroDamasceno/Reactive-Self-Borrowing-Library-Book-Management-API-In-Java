package com.api.v1.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AllBooksDeletionTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulBookDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/books")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulBookDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/books")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
