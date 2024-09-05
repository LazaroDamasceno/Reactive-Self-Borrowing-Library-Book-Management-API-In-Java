package com.api.v1.borrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BorrowDeletionTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testSuccessfulBorrowDeletion() {

        String isbn = "123456789012";
        String ssn = "123456789";
        String uri = "api/v1/borrows/%s/%s".formatted(isbn, ssn);

        webTestClient
                .delete()
                .uri(uri)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

    }

    @Test
    public void testUnsuccessfulBorrowDeletion() {

        String isbn = "123456789012";
        String ssn = "123456789";
        String uri = "api/v1/borrows/%s/%s".formatted(isbn, ssn);

        webTestClient
                .delete()
                .uri(uri)
                .exchange()
                .expectStatus()
                .is5xxServerError();

    }

}
