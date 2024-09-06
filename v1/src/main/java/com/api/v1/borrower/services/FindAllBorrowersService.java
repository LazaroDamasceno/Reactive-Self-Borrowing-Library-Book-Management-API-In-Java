package com.api.v1.borrower.services;

import com.api.v1.borrower.dtos.BorrowerResponseDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FindAllBorrowersService {

    Mono<BorrowerResponseDto> findBySsn(String ssn);
    Flux<BorrowerResponseDto> findAll();

}