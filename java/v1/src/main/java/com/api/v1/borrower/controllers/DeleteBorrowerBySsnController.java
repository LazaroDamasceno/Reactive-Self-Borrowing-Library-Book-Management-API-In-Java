package com.api.v1.borrower.controllers;

import com.api.v1.borrower.services.DeleteBorrowerBySsnService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrowers")
class DeleteBorrowerBySsnController {

    @Autowired
    private DeleteBorrowerBySsnService service;

    @DeleteMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteBySsn(@PathVariable @NotNull @Size(min=9, max=9) String ssn) {
        return service.deleteBySsn(ssn);
    }

}
