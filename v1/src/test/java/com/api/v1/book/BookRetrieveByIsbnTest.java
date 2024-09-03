package com.api.v1.book;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookRetrieveByIsbnTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulBooksRetrievingByIsbn() {
        webTestClient
                .get()
                .uri("api/v1/books/%s".formatted("123456789012"))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulBooksRetrievingByIsbn() {
        webTestClient
                .get()
                .uri("api/v1/books/%s".formatted("123456789012"))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
