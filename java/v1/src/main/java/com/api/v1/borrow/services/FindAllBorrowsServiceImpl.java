package com.api.v1.borrow.services;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.book.domain.Book;
import com.api.v1.book.utils.BookFinderUtil;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.mappers.BorrowResponseMapper;
import com.api.v1.borrow.utils.FindAllBorrowsUtil;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.utils.BorrowerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;

@Service
class FindAllBorrowsServiceImpl implements FindAllBorrowsService {

    @Autowired
    private FindAllBorrowsUtil findAllBorrows;

    @Autowired
    private BookFinderUtil bookFinder;

    @Autowired
    private BorrowerFinderUtil borrowerFinder;

    @Override
    public Flux<BorrowResponseDto> findAll() {
        return findAllBorrows
                .findAll()
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllByIsbn(@ISBN String isbn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        return findAllBorrows
                .findAll()
                .filter(e -> Mono.just(e.getBook()).equals(bookMono))
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllByIsbnAndYear(@ISBN String isbn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        return findAllBorrows
                .findAll()
                .filter(e -> Mono.just(e.getBook()).equals(bookMono)
                    && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllBySsn(@SSN String ssn) {
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findAll()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono))
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllBySsnAndYear(@SSN String ssn, int year) {
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findAll()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono)
                    && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllByIsbnAndSsnAndYear(@ISBN String isbn, @SSN String ssn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findAll()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono)
                        && Mono.just(e.getBook()).equals(bookMono)
                        && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllByIsbnAndSsn(@ISBN String isbn, @SSN String ssn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findAll()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono)
                        && Mono.just(e.getBook()).equals(bookMono)
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllActive() {
        return findAllBorrows
                .findActive()
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveByIsbn(@ISBN String isbn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        return findAllBorrows
                .findActive()
                .filter(e -> Mono.just(e.getBook()).equals(bookMono)
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveByIsbnAndYear(@ISBN String isbn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        return findAllBorrows
                .findActive()
                .filter(e -> Mono.just(e.getBook()).equals(bookMono)
                        && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveBySsn(@SSN String ssn) {
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findActive()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono)
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveBySsnAndYear(@SSN String ssn, int year) {
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findActive()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono)
                        && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveByIsbnAndSsnAndYear(@ISBN String isbn, @SSN String ssn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findActive()
                .filter(e -> Mono.just(e.getBook()).equals(bookMono)
                        && Mono.just(e.getBorrower()).equals(borrowerMono)
                        && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveByIsbnAndSsn(@ISBN String isbn, @SSN String ssn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findActive()
                .filter(e -> Mono.just(e.getBook()).equals(bookMono)
                        && Mono.just(e.getBorrower()).equals(borrowerMono)
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdue() {
        return findAllBorrows
                .findOverdue()
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueByIsbn(@ISBN String isbn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        return findAllBorrows
                .findOverdue()
                .filter(e -> Mono.just(e.getBook()).equals(bookMono))
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueByIsbnAndYear(@ISBN String isbn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        return findAllBorrows
                .findOverdue()
                .filter(e -> Mono.just(e.getBook()).equals(bookMono)
                        && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueBySsn(@SSN String ssn) {
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findOverdue()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono))
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueBySsnAndYear(@SSN String ssn, int year) {
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findOverdue()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono)
                    && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueByIsbnAndSsnAndYear(@ISBN String isbn, @SSN String ssn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findOverdue()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono)
                        && Mono.just(e.getBook()).equals(bookMono)
                        && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueByIsbnAndSsn(@ISBN String isbn, @SSN String ssn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findOverdue()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono)
                        && Mono.just(e.getBook()).equals(bookMono)
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinished() {
        return findAllBorrows
                .findFinished()
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedByIsbn(@ISBN String isbn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        return findAllBorrows
                .findFinished()
                .filter(e -> Mono.just(e.getBook()).equals(bookMono))
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedByIsbnAndYear(@ISBN String isbn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        return findAllBorrows
                .findFinished()
                .filter(e -> Mono.just(e.getBook()).equals(bookMono)
                    && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedBySsn(@SSN String ssn) {
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findFinished()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono))
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedBySsnAndYear(@SSN String ssn, int year) {
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findFinished()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono)
                        && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedByIsbnAndSsnAndYear(@ISBN String isbn, @SSN String ssn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findFinished()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono)
                        && Mono.just(e.getBook()).equals(bookMono)
                        && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedByIsbnAndSsn(@ISBN String isbn, @SSN String ssn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return findAllBorrows
                .findFinished()
                .filter(e -> Mono.just(e.getBorrower()).equals(borrowerMono)
                        && Mono.just(e.getBook()).equals(bookMono)
                )
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

}
