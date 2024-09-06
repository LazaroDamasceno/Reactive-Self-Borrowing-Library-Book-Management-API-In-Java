package com.api.v1.borrow.controllers;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrows")
public class BorrowingController {

    @Autowired
    private BorrowingService service;

    @PostMapping("{ssn}/{isbn}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<BorrowResponseDto> borrow(
            @SSN @PathVariable String ssn,
            @ISBN @PathVariable String isbn
    ) {
        return service.borrow(ssn, isbn);
    }

}
