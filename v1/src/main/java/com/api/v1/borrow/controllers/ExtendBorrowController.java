package com.api.v1.borrow.controllers;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.services.ExtendBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrows")
class ExtendBorrowController {

    @Autowired
    private ExtendBorrowService service;

    @PatchMapping("by-book/{isbn}/and/by-borrower/{ssn}/extension")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Borrow> extend(@ISBN String isbn, @SSN String ssn) {
        return service.extend(isbn, ssn);
    }

}
