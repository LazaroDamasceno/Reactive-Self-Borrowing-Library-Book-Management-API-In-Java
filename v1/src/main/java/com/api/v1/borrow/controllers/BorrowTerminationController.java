package com.api.v1.borrow.controllers;

import com.api.v1.borrow.services.BorrowTerminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrows")
public class BorrowTerminationController {

    @Autowired
    private BorrowTerminationService service;

    @PatchMapping("{id}/termination")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> terminate(@PathVariable String id) {
        return service.terminate(id);
    }

}
