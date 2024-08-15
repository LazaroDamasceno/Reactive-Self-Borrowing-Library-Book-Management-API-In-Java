package com.api.v1.borrower.services;

import com.api.v1.borrower.dtos.BorrowerResponseDto;

import reactor.core.publisher.Flux;

public interface FindAllBorrowersService {

    Flux<BorrowerResponseDto> findAll();

}