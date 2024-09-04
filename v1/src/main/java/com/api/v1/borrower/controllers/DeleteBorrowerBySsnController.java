package com.api.v1.borrower.controllers;

import com.api.v1.annotations.SSN;
import com.api.v1.borrower.services.DeleteBorrowerBySsnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrowers")
public class DeleteBorrowerBySsnController {

    @Autowired
    private DeleteBorrowerBySsnService service;

    @DeleteMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    Mono<Void> deleteBySsn(@SSN @PathVariable String ssn) {
        return service.deleteBySsn(ssn);
    }

}
