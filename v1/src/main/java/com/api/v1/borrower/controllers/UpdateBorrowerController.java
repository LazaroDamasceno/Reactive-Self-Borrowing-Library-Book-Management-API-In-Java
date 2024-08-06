package com.api.v1.borrower.controllers;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.helpers.UpdateBorrowerRequest;
import com.api.v1.borrower.services.UpdateBorrowerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrowers")
class UpdateBorrowerController {

    @Autowired
    private UpdateBorrowerService service;

    @PutMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Borrower> update(@NotNull @Size(min=9, max=9) @PathVariable String ssn,
                             @Valid @RequestBody UpdateBorrowerRequest request
    ) {
        return service.update(ssn, request);
    }

}
