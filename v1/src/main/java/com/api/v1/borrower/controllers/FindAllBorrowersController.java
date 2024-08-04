package com.api.v1.borrower.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.borrower.dtos.BorrowerResponse;
import com.api.v1.borrower.services.FindAllBorrowersService;

import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/borrowers")
public class FindAllBorrowersController {

    @Autowired
    private FindAllBorrowersService service;

    @GetMapping
    public ResponseEntity<Flux<BorrowerResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
}
