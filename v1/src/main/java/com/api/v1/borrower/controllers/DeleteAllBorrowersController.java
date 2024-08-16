package com.api.v1.borrower.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.borrower.services.DeleteAllBorrowersService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrowers")
class DeleteAllBorrowersController {

    @Autowired
    private DeleteAllBorrowersService service;

    @DeleteMapping("purging")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }
    
}
