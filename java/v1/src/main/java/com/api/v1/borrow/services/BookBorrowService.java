package com.api.v1.borrow.services;

import com.api.v1.borrow.dtos.BorrowResponseDto;
import reactor.core.publisher.Mono;

public interface BookBorrowService {

    Mono<BorrowResponseDto> borrowBook(String isbn, String ssn);

}
