package com.api.v1.borrower.services;

public interface FindAllBorrowersService {

    Flux<BorrowerResponse> findAll();

}