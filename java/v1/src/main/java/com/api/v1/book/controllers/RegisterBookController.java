package com.api.v1.book.controllers;

import com.api.v1.book.helpers.BookRequestDto;
import com.api.v1.book.helpers.BookResponseDto;
import com.api.v1.book.services.RegisterBookService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
class RegisterBookController {

    @Autowired
    private RegisterBookService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<BookResponseDto> register(@Valid @RequestBody BookRequestDto request) {
        return service.register(request);
    }

}
