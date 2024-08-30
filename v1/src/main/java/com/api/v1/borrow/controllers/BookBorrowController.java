package com.api.v1.borrow.controllers;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.services.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrows")
class BookBorrowController {

    @Autowired
    private BookBorrowService service;

    @PostMapping("{isbn}/{ssn}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<BorrowResponseDto> borrowBook(@ISBN @PathVariable String isbn, @SSN @PathVariable String ssn) {
        return service.borrowBook(isbn, ssn);
    }

}
