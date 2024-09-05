package com.api.v1.borrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookBorrowTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testSuccessfulBookBorrow() {

        String isbn = "123456789012";
        String ssn = "123456789";
        String uri = String.format("api/v1/borrows/%s/%s", isbn, ssn);

        webTestClient
                .post()
                .uri(uri)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    public void testUnsuccessfulBookBorrow() {

        String isbn = "123456789011";
        String ssn = "123456788";
        String uri = String.format("api/v1/borrows/%s/%s", isbn, ssn);

        webTestClient
                .post()
                .uri(uri)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
