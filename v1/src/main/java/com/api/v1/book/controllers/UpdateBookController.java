package com.api.v1.book.controllers;

import com.api.v1.book.dtos.BookResponseDto;
import com.api.v1.book.dtos.NewBookRequestDto;
import com.api.v1.book.services.UpdateBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
class UpdateBookController {

    @Autowired
    private UpdateBookService service;

    @PutMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<BookResponseDto> update(@Valid @RequestBody NewBookRequestDto request) {
        return service.update(request);
    }

}
