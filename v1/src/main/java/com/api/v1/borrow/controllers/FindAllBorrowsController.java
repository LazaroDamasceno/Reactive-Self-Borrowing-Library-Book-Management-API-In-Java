package com.api.v1.borrow.controllers;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.services.FindAllBorrowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController 
@RequestMapping("api/v1/borrows")
public class FindAllBorrowsController {
    
    @Autowired
    private FindAllBorrowsService service;

    @GetMapping("all")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("all/by-book/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findByIsbn(@PathVariable @ISBN String isbn) {
        return service.findAllByIsbn(isbn);
    }

    @GetMapping("all/by-book/{isbn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllByIsbnAndYear(@PathVariable @ISBN String isbn, @PathVariable int year) {
        return service.findAllByIsbnAndYear(isbn, year);
    }
    
    @GetMapping("all/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllBySsn(@PathVariable @SSN String ssn) {
        return service.findAllBySsn(ssn);
    }


    @GetMapping("all/by-borrower/{ssn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllBySsnAndYear(@PathVariable @SSN String ssn, @PathVariable int year) {
        return service.findAllBySsnAndYear(ssn, year);
    }

    @GetMapping("all/by-borrower/{ssn}/and/by-book/{isbn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllByIsbnAndSsnAndYear(
            @PathVariable @ISBN String isbn, 
            @PathVariable @SSN String ssn, 
            @PathVariable int year
    ) {
        return service.findAllByIsbnAndSsnAndYear(isbn, ssn, year);
    }

    @GetMapping("all/by-borrower/{ssn}/and/by-book/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllByIsbnAndSsn(@PathVariable @ISBN String isbn, @PathVariable @SSN String ssn) {
        return service.findAllByIsbnAndSsn(isbn, ssn);
    }

    @GetMapping("active")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllActive() {
        return service.findAllActive();
    }

    @GetMapping("active/by-book/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllActiveByIsbn(@PathVariable @ISBN String isbn) {   
        return service.findAllActiveByIsbn(isbn);
    }

    @GetMapping("active/by-book/{isbn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllActiveByIsbnAndYear(
            @PathVariable @ISBN String isbn,
            @PathVariable int year
    ) {
        return service.findAllActiveByIsbnAndYear(isbn, year);
    }

    @GetMapping("active/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllActiveBySsn(@PathVariable @SSN String ssn) {
        return service.findAllActiveBySsn(ssn);
    }

    @GetMapping("active/by-borrower/{ssn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllActiveBySsnAndYear(@PathVariable @SSN String ssn, @PathVariable int year) {
        return service.findAllActiveBySsnAndYear(ssn, year);
    }

    @GetMapping("active/by-book/{isbn}/and/by-borrower/{ssn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllActiveByIsbnAndSsnAndYear(
            @PathVariable @ISBN String isbn,
            @PathVariable @SSN String ssn,
            @PathVariable int year
    ) {
        return service.findAllActiveByIsbnAndSsnAndYear(isbn, ssn, year);
    }

    @GetMapping("active/by-book/{isbn}/and/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllActiveByIsbnAndSsn(
            @PathVariable @ISBN String isbn,
            @PathVariable @SSN String ssn
    ) {
        return service.findAllActiveByIsbnAndSsn(isbn, ssn);
    }

    @GetMapping("overdue")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllOverdue() {
        return service.findAllOverdue();
    }

    @GetMapping("overdue/by-book/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllOverdueByIsbn(@PathVariable @ISBN String isbn) {
        return service.findAllOverdueByIsbn(isbn);
    }

    @GetMapping("overdue/by-book/{isbn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllOverdueByIsbnAndYear(@PathVariable @ISBN String isbn, @PathVariable int year) {
        return service.findAllOverdueByIsbnAndYear(isbn, year);
    }

    @GetMapping("overdue/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllOverdueBySsn(@PathVariable @SSN String ssn) {
        return service.findAllOverdueBySsn(ssn);
    }

    @GetMapping("overdue/by-borrower/{ssn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllOverdueBySsnAndYear(@PathVariable @SSN String ssn, @PathVariable int year) {
        return service.findAllOverdueBySsnAndYear(ssn, year);
    }

    @GetMapping("overdue/by-book/{isbn}/and/by-borrower/{ssn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllOverdueByIsbnAndSsnAndYear(
            @PathVariable @ISBN String isbn,
            @PathVariable @SSN String ssn,
            @PathVariable int year
    ) {
        return service.findAllOverdueByIsbnAndSsnAndYear(isbn, ssn, year);
    }

    @GetMapping("overdue/by-book/{isbn}/and/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllOverdueByIsbnAndSsn(
            @PathVariable @ISBN String isbn,
            @PathVariable @SSN String ssn
    ) {
        return service.findAllOverdueByIsbnAndSsn(isbn, ssn);
    }

    @GetMapping("finished")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllFinished() {
        return service.findAllFinished();
    }

    @GetMapping("finished/by-book/{isbn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllFinishedByIsbn(@PathVariable @ISBN String isbn) {
        return service.findAllFinishedByIsbn(isbn);
    }

    @GetMapping("finished/by-book/{isbn}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllFinishedByIsbnAndYear(
            @PathVariable @ISBN String isbn,
            @PathVariable int year
    ) {
        return service.findAllFinishedByIsbnAndYear(isbn, year);
    }

    @GetMapping("finished/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllFinishedBySsn(@PathVariable @SSN String ssn) {
        return service.findAllFinishedBySsn(ssn);
    }

    @GetMapping("finished/by-borrower/{ssn}/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllFinishedBySsnAndYear(
            @PathVariable @SSN String ssn,
            @PathVariable int year
    ) {
        return service.findAllFinishedBySsnAndYear(ssn, year);
    }

    @GetMapping("finished/by-book/{isbn}/and/by-borrower/{ssn}/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllFinishedByIsbnAndSsnAndYear(
            @PathVariable @ISBN String isbn,
             @PathVariable @SSN String ssn,
             @PathVariable int year
    ) {
        return service.findAllFinishedByIsbnAndSsnAndYear(isbn, ssn, year);
    }

    @GetMapping("finished/by-book/{isbn}/and/by-borrower/{ssn}")
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<BorrowResponseDto> findAllFinishedByIsbnAndSsn(
            @PathVariable @ISBN String isbn,
            @PathVariable @SSN String ssn
    ) {
        return service.findAllFinishedByIsbnAndSsn(isbn, ssn);
    }
    
}
