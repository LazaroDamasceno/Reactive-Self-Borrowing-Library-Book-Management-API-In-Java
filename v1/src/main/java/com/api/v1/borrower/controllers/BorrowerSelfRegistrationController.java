package com.api.v1.borrower.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.borrower.dtos.NewBorrowerRequestDto;
import com.api.v1.borrower.dtos.BorrowerResponseDto;
import com.api.v1.borrower.services.BorrowerSelfRegistrationService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrowers")
public class BorrowerSelfRegistrationController {

    @Autowired
    private BorrowerSelfRegistrationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BorrowerResponseDto> selfRegister(@Valid @RequestBody NewBorrowerRequestDto request) {
        return service.selfRegister(request);
    }

}
