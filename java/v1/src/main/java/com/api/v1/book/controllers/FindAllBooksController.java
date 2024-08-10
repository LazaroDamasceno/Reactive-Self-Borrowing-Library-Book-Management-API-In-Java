package com.api.v1.book.controllers;

import com.api.v1.book.dtos.BookResponseDto;
import com.api.v1.book.services.FindAllBooksService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/books")
class FindAllBooksController {

    @Autowired
    private FindAllBooksService service;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BookResponseDto> findAll() {
        return service.findAll();
    }

}
