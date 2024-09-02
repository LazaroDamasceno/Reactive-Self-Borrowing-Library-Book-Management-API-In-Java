package com.api.v1;

import com.api.v1.borrower.dtos.NewBorrowerRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BorrowerRegistrationTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testSuccessfulBorrowerRegistration() {

		var borrower = new NewBorrowerRequestDto(
				"Leo",
				"",
				"Santos",
				LocalDate.parse("2000-12-12"),
				"123456789",
				"leosantos@mail.com",
				"St. Dennis, Paris",
				"1234567890",
				"male"
		);

		webTestClient
				.post()
				.uri("api/v1/borrowers")
				.bodyValue(borrower)
				.exchange()
				.expectStatus()
				.is2xxSuccessful();
	}

	@Test
	void testUnsuccessfulBorrowerRegistration() {

		var borrower = new NewBorrowerRequestDto(
				"Leo",
				"",
				"Santos",
				LocalDate.parse("2000-12-12"),
				"123456789",
				"leosantos@mail.com",
				"St. Dennis, Paris",
				"1234567890",
				"male"
		);

		webTestClient
				.post()
				.uri("api/v1/borrowers")
				.bodyValue(borrower)
				.exchange()
				.expectStatus()
				.is5xxServerError();

	}

}
