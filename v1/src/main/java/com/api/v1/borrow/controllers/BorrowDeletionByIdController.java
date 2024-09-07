package com.api.v1.borrow.controllers;

import com.api.v1.borrow.services.BorrowDeletionByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrows")
public class BorrowDeletionByIdController {

    @Autowired
    private BorrowDeletionByIdService service;

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteById(@PathVariable String id) {
        return service.deleteById(id);
    }

}
