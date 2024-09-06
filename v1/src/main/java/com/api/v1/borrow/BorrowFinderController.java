package com.api.v1.borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/borrows")
public class BorrowFinderController {

    @Autowired
    private BorrowFinderService service;

    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<BorrowResponseDto> find(@PathVariable String id) {
        return service.find(id);
    }

}
