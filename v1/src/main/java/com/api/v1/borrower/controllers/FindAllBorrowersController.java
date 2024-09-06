package com.api.v1.borrower.controllers;

import com.api.v1.annotations.SSN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.api.v1.borrower.dtos.BorrowerResponseDto;
import com.api.v1.borrower.services.FindAllBorrowersService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrowers")
public class FindAllBorrowersController {

    @Autowired
    private FindAllBorrowersService service;

    @GetMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<BorrowerResponseDto> findBySsn(@SSN @PathVariable String ssn) {
        return service.findBySsn(ssn);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowerResponseDto> findAll() {
        return service.findAll();
    }

}