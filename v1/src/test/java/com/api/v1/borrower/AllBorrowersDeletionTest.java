package com.api.v1.borrower;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AllBorrowersDeletionTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulAllBorrowerDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/borrowers")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulAllBorrowerDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/borrowers")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
