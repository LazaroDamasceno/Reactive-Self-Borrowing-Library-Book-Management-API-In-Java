package com.api.v1.borrow.controllers;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.services.BorrowsFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/borrows")
public class BorrowsFinderController {

    @Autowired
    private BorrowsFinderService service;

    @GetMapping("active/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllActive(
            @PathVariable int firstYear, 
            @PathVariable int lastYear
    ) {
        return service.findAllActive(firstYear, lastYear);
    }

    @GetMapping("active/{author}/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findActiveByAuthor(
            @PathVariable String author, 
            @PathVariable int firstYear, 
            @PathVariable int lastYear
    ) {
        return service.findActiveByAuthor(author, firstYear, lastYear);
    }

    @GetMapping("active/{isbn}/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findActiveByBook(
            @ISBN @PathVariable String isbn, 
            @PathVariable int firstYear, 
            @PathVariable int lastYear
    ) {
        return service.findActiveByBook(isbn, firstYear, lastYear);
    }

    @GetMapping("active/{ssn}/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findActiveByBorrower(
            @SSN @PathVariable String ssn, 
            @PathVariable int firstYear, 
            @PathVariable int lastYear
    ) {
        return service.findActiveByBorrower(ssn, firstYear, lastYear);
    }

    @GetMapping("overdue/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllOverdue(
            @PathVariable int firstYear, 
            @PathVariable int lastYear) {
        return service.findAllOverdue(firstYear, lastYear);
    }

    @GetMapping("overdue/{author}/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findOverdueByAuthor(
            @PathVariable String author, 
            @PathVariable int firstYear, 
            @PathVariable int lastYear
    ) {
        return service.findOverdueByAuthor(author, firstYear, lastYear);
    }

    @GetMapping("overdue/{isbn}/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findOverdueByBook(
            @ISBN @PathVariable String isbn, 
            @PathVariable int firstYear,
            @PathVariable int lastYear
    ) {
        return service.findOverdueByBook(isbn, firstYear, lastYear);
    }

    @GetMapping("overdue/{ssn}/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findOverdueByBorrower(
            @SSN @PathVariable String ssn, 
            @PathVariable int firstYear, 
            @PathVariable int lastYear
    ) {
        return service.findOverdueByBorrower(ssn, firstYear, lastYear);
    }

    @GetMapping("terminated/terminated/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllTerminated(
            @PathVariable int firstYear,
            @PathVariable int lastYear
    ) {
        return service.findAllTerminated(firstYear, lastYear);
    }

    @GetMapping("terminated/{author}/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findTerminatedByAuthor(
            @PathVariable String author, 
            @PathVariable int firstYear, 
            @PathVariable int lastYear
    ) {
        return service.findTerminatedByAuthor(author, firstYear, lastYear);
    }

    @GetMapping("terminated/{isbn}/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findTerminatedByBook(
            @ISBN @PathVariable String isbn, 
            @PathVariable int firstYear, 
            @PathVariable int lastYear
    ) {
        return service.findTerminatedByBook(isbn, firstYear, lastYear);
    }

    @GetMapping("terminated/{ssn}/{firstYear}/{lastYear}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findTerminatedByBorrower(
            @SSN @PathVariable String ssn, 
            @PathVariable int firstYear, 
            @PathVariable int lastYear
    ) {
        return service.findTerminatedByBorrower(ssn, firstYear, lastYear);
    }

}
