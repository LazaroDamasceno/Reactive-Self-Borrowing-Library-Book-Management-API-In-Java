package com.api.v1.borrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BorrowFinishingTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulBorrowFinishing() {

        String isbn = "123456789012";
        String ssn = "123456789";
        String endpoint = "api/v1/borrows/%s/%s/finishing".formatted(isbn, ssn);

        webTestClient
                .patch()
                .uri(endpoint)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulBorrowFinishing() {

        String isbn = "123456789012";
        String ssn = "123456789";
        String endpoint = "api/v1/borrows/%s/%s/finishing".formatted(isbn, ssn);

        webTestClient
                .patch()
                .uri(endpoint)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
