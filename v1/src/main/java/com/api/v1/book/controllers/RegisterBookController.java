package com.api.v1.book.controllers;

import com.api.v1.book.helpers.dtos.BookRequest;
import com.api.v1.book.helpers.dtos.BookResponse;
import com.api.v1.book.services.RegisterBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
public class RegisterBookController {

    @Autowired
    private RegisterBookService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<BookResponse> register(@Valid @RequestBody BookRequest request) {
        return service.register(request);
    }

}
