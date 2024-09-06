package com.api.v1.borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookBorrowingTest {

    @Autowired
    private WebTestClient webTestClient;

    void testSuccessfulBookBorrowing() {

        String ssn = "123456789";
        String isbn = "123456789012";
        String endpoint = "api/v1/borrows/%s/%s".formatted(ssn, isbn);

        webTestClient
                .post()
                .uri(endpoint)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    void testUnsuccessfulBookBorrowing1() {

        String ssn = "123456788";
        String isbn = "123456789012";
        String endpoint = "api/v1/borrows/%s/%s".formatted(ssn, isbn);

        webTestClient
                .post()
                .uri(endpoint)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    void testUnsuccessfulBookBorrowing2() {

        String ssn = "123456789";
        String isbn = "123456789011";
        String endpoint = "api/v1/borrows/%s/%s".formatted(ssn, isbn);

        webTestClient
                .post()
                .uri(endpoint)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    void testUnsuccessfulBookBorrowing3() {

        String ssn = "123456789";
        String isbn = "123456789012";
        String endpoint = "api/v1/borrows/%s/%s".formatted(ssn, isbn);

        webTestClient
                .put()
                .uri(endpoint)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
