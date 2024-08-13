package com.api.v1.borrow.services;

import com.api.v1.borrow.dtos.BorrowResponseDto;
import reactor.core.publisher.Flux;

public interface FindAllBorrowsService {

    Flux<BorrowResponseDto> findAll();
    Flux<BorrowResponseDto> findAllByIsbn(String isbn);
    Flux<BorrowResponseDto> findAllByIsbnAndYear(String isbn, int year);
    Flux<BorrowResponseDto> findAllBySsn(String ssn);
    Flux<BorrowResponseDto> findAllBySsnAndYear(String ssn, int year);
    Flux<BorrowResponseDto> findAllByIsbnAndSsnAndYear(String isbn, String ssn, int year);
    Flux<BorrowResponseDto> findAllByIsbnAndSsn(String isbn, String ssn);
    Flux<BorrowResponseDto> findAllActive();
    Flux<BorrowResponseDto> findAllActiveByIsbn(String isbn);
    Flux<BorrowResponseDto> findAllActiveByIsbnAndYear(String isbn, int year);
    Flux<BorrowResponseDto> findAllActiveBySsn(String ssn);
    Flux<BorrowResponseDto> findAllActiveBySsnAndYear(String ssn, int year);
    Flux<BorrowResponseDto> findAllActiveByIsbnAndSsnAndYear(String isbn, String ssn, int year);
    Flux<BorrowResponseDto> findAllActiveByIsbnAndSsn(String isbn, String ssn);
    Flux<BorrowResponseDto> findAllOverdue();
    Flux<BorrowResponseDto> findAllOverdueByIsbn(String isbn);
    Flux<BorrowResponseDto> findAllOverdueByIsbnAndYear(String isbn, int year);
    Flux<BorrowResponseDto> findAllOverdueBySsn(String ssn);
    Flux<BorrowResponseDto> findAllOverdueBySsnAndYear(String ssn, int year);
    Flux<BorrowResponseDto> findAllOverdueByIsbnAndSsnAndYear(String isbn, String ssn, int year);
    Flux<BorrowResponseDto> findAllOverdueByIsbnAndSsn(String isbn, String ssn);
    Flux<BorrowResponseDto> findAllFinished();
    Flux<BorrowResponseDto> findAllFinishedByIsbn(String isbn);
    Flux<BorrowResponseDto> findAllFinishedByIsbnAndYear(String isbn, int year);
    Flux<BorrowResponseDto> findAllFinishedBySsn(String ssn);
    Flux<BorrowResponseDto> findAllFinishedBySsnAndYear(String ssn, int year);
    Flux<BorrowResponseDto> findAllFinishedByIsbnAndSsnAndYear(String isbn, String ssn, int year);
    Flux<BorrowResponseDto> findAllFinishedByIsbnAndSsn(String isbn, String ssn);

}
