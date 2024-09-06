package com.api.v1.borrow.services;

import com.api.v1.borrow.dtos.BorrowResponseDto;
import reactor.core.publisher.Mono;

public interface BorrowingService {

    Mono<BorrowResponseDto> borrow(String ssn, String isbn);

}
