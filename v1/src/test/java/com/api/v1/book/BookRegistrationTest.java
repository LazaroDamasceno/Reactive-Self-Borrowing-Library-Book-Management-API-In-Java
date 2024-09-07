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
public class BookRegistrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulBookRegistration() {

        var request = new NewBookRequestDto(
                "Harry Potter",
                "The First Book",
                "123456789012",
                "J.K. Rowling",
                1997,
                "juvenile fantasy",
                300,
                1
        );

        webTestClient
                .post()
                .uri("api/v1/books")
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

    }

    @Test
    @Order(2)
    void testUnsuccessfulBookRegistration() {

        var request = new NewBookRequestDto(
                "Harry Potter",
                "The first book",
                "123456789012",
                "J.K. Rowling",
                1997,
                "juvenile fantasy",
                300,
                1
        );

        webTestClient
                .post()
                .uri("api/v1/books")
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is5xxServerError();

    }

}
