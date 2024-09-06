package com.api.v1.borrow;

import reactor.core.publisher.Mono;

public interface BorrowingService {

    Mono<BorrowResponseDto> borrow(String ssn, String isbn);

}
