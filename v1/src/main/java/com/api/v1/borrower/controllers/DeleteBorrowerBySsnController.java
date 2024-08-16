package com.api.v1.borrower.controllers;

import com.api.v1.borrower.services.DeleteBorrowerBySsnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.api.v1.annotations.SSN;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrowers")
class DeleteBorrowerBySsnController {

    @Autowired
    private DeleteBorrowerBySsnService service;

    @DeleteMapping("{ssn}/purging")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteBySsn(@PathVariable @SSN String ssn) {
        return service.deleteBySsn(ssn);
    }

}
