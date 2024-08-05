package com.api.v1.borrower.controllers;

import com.api.v1.borrower.dtos.BorrowerResponse;
import com.api.v1.borrower.dtos.UpdatedBorrowerRequest;
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
public class UpdateBorrowerController {

    @Autowired
    private UpdateBorrowerService service;

    @PutMapping("{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<BorrowerResponse> update(
            @NotNull @Size(min=9, max=9) @PathVariable String ssn,
            @Valid @RequestBody UpdatedBorrowerRequest request
    ) {
        return service.update(ssn, request);
    }

}
