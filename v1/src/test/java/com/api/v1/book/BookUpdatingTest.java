package com.api.v1.book;

import com.api.v1.book.dtos.NewBookRequestDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookUpdatingTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulBookUpdating() {

        var request = new NewBookRequestDto(
                "Harry Potter",
                "And the Magical Stone",
                "123456789012",
                "J.K. Rowling",
                2002,
                "juvenile fantasy",
                336,
                1
        );

        webTestClient
                .put()
                .uri("api/v1/books")
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

    }

    @Test
    @Order(2)
    void testUnsuccessfulBookUpdating() {

        var request = new NewBookRequestDto(
                "Harry Potter",
                "And the Magical Stone",
                "123456789011",
                "J.K. Rowling",
                2002,
                "juvenile fantasy",
                336,
                1
        );

        webTestClient
                .put()
                .uri("api/v1/books")
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is5xxServerError();

    }

}
