package com.api.v1.borrower.controllers;

import com.api.v1.borrower.dtos.BorrowerResponseDto;
import com.api.v1.borrower.dtos.NewBorrowerRequestDto;
import com.api.v1.borrower.services.UpdateBorrowerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrowers")
public class UpdateBorrowerController {

    @Autowired
    private UpdateBorrowerService service;

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<BorrowerResponseDto> update(@Valid @RequestBody NewBorrowerRequestDto request) {
        return service.update(request);
    }

}
