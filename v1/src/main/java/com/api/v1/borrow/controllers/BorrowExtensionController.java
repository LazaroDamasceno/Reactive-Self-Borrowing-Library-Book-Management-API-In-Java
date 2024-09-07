package com.api.v1.borrow.controllers;

import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.services.BorrowExtensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrows")
public class BorrowExtensionController {

    @Autowired
    private BorrowExtensionService service;

    @PatchMapping("{id}/extension")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<BorrowResponseDto> extend(@PathVariable String id) {
        return service.extend(id);
    }

}
