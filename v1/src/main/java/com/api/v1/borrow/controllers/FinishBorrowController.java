package com.api.v1.borrow.controllers;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.services.FinishBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrows")
public class FinishBorrowController {

    @Autowired
    private FinishBorrowService service;

    @PatchMapping("by-book/{isbn}/and/by-borrower{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Borrow> finish(@ISBN @PathVariable String isbn, @SSN @PathVariable String ssn) {
        return service.finish(isbn, ssn);
    }

}
