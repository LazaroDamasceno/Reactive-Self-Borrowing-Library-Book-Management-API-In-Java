package com.api.v1.borrower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BorrowerRetrievingTest {

    @Autowired
    private WebTestClient webTestClient;

    public void testSuccessfulBorrowerRetrievingBySsn() {

        String ssn = "123456789";

        webTestClient
                .get()
                .uri("api/v1/borrowers/%s".formatted(ssn))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

    }

    public void testUnsuccessfulBorrowerRetrievingBySsn() {

        String ssn = "123456788";

        webTestClient
                .get()
                .uri("api/v1/borrowers/%s".formatted(ssn))
                .exchange()
                .expectStatus()
                .is5xxServerError();

    }

}
