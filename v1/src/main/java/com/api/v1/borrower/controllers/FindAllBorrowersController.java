package com.api.v1.borrower.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.borrower.dtos.BorrowerResponseDto;
import com.api.v1.borrower.services.FindAllBorrowersService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/borrowers")
public class FindAllBorrowersController {

    @Autowired
    private FindAllBorrowersService service;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowerResponseDto> findAll() {
        return service.findAll();
    }

}