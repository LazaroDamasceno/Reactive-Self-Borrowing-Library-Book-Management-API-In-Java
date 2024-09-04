package com.api.v1.borrower;

import com.api.v1.borrower.dtos.NewBorrowerRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BorrowerUpdatingTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulBorrowerUpdating() {

        var requestDto = new NewBorrowerRequestDto(
                "Leo",
                "Silva",
                "Santos Jr.",
                LocalDate.parse("2000-12-12"),
                "123456789",
                "jr@leosantos.com",
                "St Dennis, Paris",
                "0987654321",
                "cis male"
        );

        webTestClient
                .put()
                .uri("api/v1/borrowers")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulBorrowerUpdating() {

        var requestDto = new NewBorrowerRequestDto(
                "Leo",
                "Silva",
                "Santos Jr.",
                LocalDate.parse("2000-12-12"),
                "123456788",
                "jr@leosantos.com",
                "St Dennis, Paris",
                "0987654321",
                "cis male"
        );

        webTestClient
                .put()
                .uri("api/v1/borrowers")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
