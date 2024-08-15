package com.api.v1.book.controllers;

import com.api.v1.book.domain.Book;
import com.api.v1.book.dtos.UpdateBookRequestDto;
import com.api.v1.book.services.UpdateBookService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.api.v1.annotations.ISBN;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
class UpdateBookController {

    @Autowired
    private UpdateBookService service;

    @PutMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Book> update(
            @ISBN @PathVariable String isbn,
            @Valid @RequestBody UpdateBookRequestDto request
    ) {
        return service.update(isbn, request);
    }

}
