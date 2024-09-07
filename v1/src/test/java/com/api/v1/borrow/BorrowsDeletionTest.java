package com.api.v1.borrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BorrowsDeletionTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulBorrowsDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/borrows")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulBorrowsDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/borrows")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
