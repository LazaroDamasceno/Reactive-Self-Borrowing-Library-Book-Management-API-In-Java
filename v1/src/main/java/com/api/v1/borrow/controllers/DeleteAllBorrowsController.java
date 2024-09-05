package com.api.v1.borrow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.borrow.services.DeleteAllBorrowsService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrows")
public class DeleteAllBorrowsController {

    @Autowired
    private DeleteAllBorrowsService service;

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }
    
}
