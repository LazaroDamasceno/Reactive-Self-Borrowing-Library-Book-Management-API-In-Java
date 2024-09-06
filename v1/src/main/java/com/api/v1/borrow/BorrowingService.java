package com.api.v1.borrow;

import reactor.core.publisher.Mono;

public interface BorrowingService {

    Mono<BorrowingResponseDto> borrow(String ssn, String isbn);

}
