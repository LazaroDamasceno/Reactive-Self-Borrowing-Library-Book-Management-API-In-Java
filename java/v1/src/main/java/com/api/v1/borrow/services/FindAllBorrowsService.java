package com.api.v1.borrow.services;

import com.api.v1.book.domain.Book;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrower.domain.Borrower;
import reactor.core.publisher.Flux;

public interface FindAllBorrowsService {

    Flux<BorrowResponseDto> findAll();
    Flux<BorrowResponseDto> findAll(Book book);
    Flux<BorrowResponseDto> findAll(Book book, int year);
    Flux<BorrowResponseDto> findAll(Borrower borrower);
    Flux<BorrowResponseDto> findAll(Borrower borrower, int year);
    Flux<BorrowResponseDto> findAll(Book book, Borrower borrower, int year);
    Flux<BorrowResponseDto> findAllActive();
    Flux<BorrowResponseDto> findAllActive(Book book);
    Flux<BorrowResponseDto> findAllActive(Book book, int year);
    Flux<BorrowResponseDto> findAllActive(Borrower borrower);
    Flux<BorrowResponseDto> findAllActive(Borrower borrower, int year);
    Flux<BorrowResponseDto> findAllActive(Book book, Borrower borrower, int year);
    Flux<BorrowResponseDto> findAllOverdue();
    Flux<BorrowResponseDto> findAllOverdue(Book book);
    Flux<BorrowResponseDto> findAllOverdue(Book book, int year);
    Flux<BorrowResponseDto> findAllOverdue(Borrower borrower);
    Flux<BorrowResponseDto> findAllOverdue(Borrower borrower, int year);
    Flux<BorrowResponseDto> findAllOverdue(Book book, Borrower borrower, int year);
    Flux<BorrowResponseDto> findAllReturned();
    Flux<BorrowResponseDto> findAllReturned(Book book);
    Flux<BorrowResponseDto> findAllReturned(Book book, int year);
    Flux<BorrowResponseDto> findAllReturned(Borrower borrower);
    Flux<BorrowResponseDto> findAllReturned(Borrower borrower, int year);
    Flux<BorrowResponseDto> findAllReturned(Book book, Borrower borrower, int year);

}
