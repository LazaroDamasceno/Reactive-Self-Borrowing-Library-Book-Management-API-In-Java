package com.api.v1.borrow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManyBorrowsTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulManyBookBorrowings() {

        int testcases = 10;

        while(testcases > 0) {
            String ssn = "123456789";
            String isbn = "123456789012";
            String endpoint = "api/v1/borrows/%s/%s".formatted(ssn, isbn);

            webTestClient
                    .post()
                    .uri(endpoint)
                    .exchange()
                    .expectStatus()
                    .is2xxSuccessful();

            testcases--;
        }


    }

    @Test
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

    @Test
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

    @Test
    void testUnsuccessfulBookBorrowing3() {

        String ssn = "123456789";
        String isbn = "123456789012";
        String endpoint = "api/v1/borrows/%s/%s".formatted(ssn, isbn);

        webTestClient
                .put()
                .uri(endpoint)
                .exchange()
                .expectStatus()
                .is4xxClientError();
    }

}
