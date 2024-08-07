package com.api.v1.book.controllers;

import com.api.v1.book.domain.Book;
import com.api.v1.book.helpers.BookRequest;
import com.api.v1.book.services.UpdateBookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/books")
class UpdateBookController {

    @Autowired
    private UpdateBookService service;

    @PutMapping("{isbn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Book> update(
            @NotNull @Size(min=13, max=13) @PathVariable String isbn,
            @Valid @RequestBody BookRequest request
    ) {
        return service.update(isbn, request);
    }

}
