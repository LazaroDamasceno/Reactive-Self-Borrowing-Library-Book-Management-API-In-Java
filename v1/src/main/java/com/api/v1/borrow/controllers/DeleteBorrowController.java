package com.api.v1.borrow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.borrow.services.DeleteBorrowService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrows")
public class DeleteBorrowController {

    @Autowired
    private DeleteBorrowService service;

    @DeleteMapping("{isbn}/{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@ISBN @PathVariable String isbn, @SSN @PathVariable String ssn) {
        return service.delete(isbn, ssn);
    }
    
}
