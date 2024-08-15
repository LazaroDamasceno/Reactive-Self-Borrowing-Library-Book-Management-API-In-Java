package com.api.v1.borrow.services;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.book.domain.Book;
import com.api.v1.book.utils.BookFinderUtil;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrow.mappers.BorrowResponseMapper;
import com.api.v1.borrow.utils.FindBorrowsUtil;
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
    private FindBorrowsUtil findBorrows;

    @Autowired
    private BookFinderUtil bookFinder;

    @Autowired
    private BorrowerFinderUtil borrowerFinder;

    @Override
    public Flux<BorrowResponseDto> findAll() {
        return findBorrows
                .findAll()
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllByIsbn(@ISBN String isbn) {
        return bookFinder
                .find(isbn)
                .flatMapMany(book -> findBorrows
                        .findAll()
                        .filter(e -> e.getBook().equals(book))
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllByIsbnAndYear(@ISBN String isbn, int year) {
        return bookFinder
                .find(isbn)
                .flatMapMany(book -> findBorrows
                        .findAll()
                        .filter(e -> e.getBook().equals(book)
                            && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                        )
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllBySsn(@SSN String ssn) {
        return borrowerFinder
                .find(ssn)
                .flatMapMany(borrower -> findBorrows
                        .findAll()
                        .filter(e -> e.getBorrower().equals(borrower))
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllBySsnAndYear(@SSN String ssn, int year) {
        return borrowerFinder
                .find(ssn)
                .flatMapMany(borrower -> findBorrows
                        .findAll()
                        .filter(e -> e.getBorrower().equals(borrower)
                            && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                        )
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllByIsbnAndSsnAndYear(@ISBN String isbn, @SSN String ssn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono.zip(bookMono, borrowerMono)
                .flatMapMany(tuple -> {
                    Book book = tuple.getT1();
                    Borrower borrower = tuple.getT2();
                    return findBorrows
                            .findAll()
                            .filter(e -> e.getBorrower().equals(borrower)
                                    && e.getBook().equals(book)
                                    && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                            );
                })
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllByIsbnAndSsn(@ISBN String isbn, @SSN String ssn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono.zip(bookMono, borrowerMono)
                .flatMapMany(tuple -> {
                    Book book = tuple.getT1();
                    Borrower borrower = tuple.getT2();
                    return findBorrows
                            .findAll()
                            .filter(e -> e.getBorrower().equals(borrower)
                                    && e.getBook().equals(book)
                            );
                })
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllActive() {
        return findBorrows
                .findActive()
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveByIsbn(@ISBN String isbn) {
        return bookFinder
                .find(isbn)
                .flatMapMany(b -> findBorrows
                        .findActive()
                        .filter(e -> e.getBook().equals(b))
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveByIsbnAndYear(@ISBN String isbn, int year) {
        return bookFinder
                .find(isbn)
                .flatMapMany(b -> findBorrows
                        .findActive()
                        .filter(e -> e.getBook().equals(b)
                            && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                        )
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveBySsn(@SSN String ssn) {
        return borrowerFinder
                .find(ssn)
                .flatMapMany(b -> findBorrows
                        .findActive()
                        .filter(e -> e.getBorrower().equals(b))
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveBySsnAndYear(@SSN String ssn, int year) {
        return borrowerFinder
                .find(ssn)
                .flatMapMany(b -> findBorrows
                        .findActive()
                        .filter(e -> e.getBorrower().equals(b)
                            && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                        )
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveByIsbnAndSsnAndYear(@ISBN String isbn, @SSN String ssn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono.zip(bookMono, borrowerMono)
                .flatMapMany(tuple -> {
                    Book book = tuple.getT1();
                    Borrower borrower = tuple.getT2();
                    return findBorrows
                            .findActive()
                            .filter(e -> e.getBorrower().equals(borrower)
                                && e.getBook().equals(book)
                                && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                            );
                })
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllActiveByIsbnAndSsn(@ISBN String isbn, @SSN String ssn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono.zip(bookMono, borrowerMono)
                .flatMapMany(tuple -> {
                    Book book = tuple.getT1();
                    Borrower borrower = tuple.getT2();
                    return findBorrows
                            .findActive()
                            .filter(e -> e.getBorrower().equals(borrower)
                                    && e.getBook().equals(book)
                            );
                })
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdue() {
        return findBorrows
                .findOverdue()
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueByIsbn(@ISBN String isbn) {
        return bookFinder
                .find(isbn)
                .flatMapMany(b -> findBorrows
                        .findOverdue()
                        .filter(e -> e.getBook().equals(b))
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueByIsbnAndYear(@ISBN String isbn, int year) {
        return bookFinder
                .find(isbn)
                .flatMapMany(b -> findBorrows
                        .findOverdue()
                        .filter(e -> e.getBook().equals(b)
                            && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                        )
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueBySsn(@SSN String ssn) {
        return borrowerFinder
                .find(ssn)
                .flatMapMany(b -> findBorrows
                        .findOverdue()
                        .filter(e -> e.getBorrower().equals(b))
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueBySsnAndYear(@SSN String ssn, int year) {
        return borrowerFinder
                .find(ssn)
                .flatMapMany(b -> findBorrows
                        .findOverdue()
                        .filter(e -> e.getBorrower().equals(b)
                                && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                        )
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueByIsbnAndSsnAndYear(@ISBN String isbn, @SSN String ssn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono.zip(bookMono, borrowerMono)
                .flatMapMany(tuple -> {
                    Book book = tuple.getT1();
                    Borrower borrower = tuple.getT2();
                    return findBorrows
                            .findOverdue()
                            .filter(e -> e.getBorrower().equals(borrower)
                                    && e.getBook().equals(book)
                                    && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                            );
                })
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllOverdueByIsbnAndSsn(@ISBN String isbn, @SSN String ssn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono.zip(bookMono, borrowerMono)
                .flatMapMany(tuple -> {
                    Book book = tuple.getT1();
                    Borrower borrower = tuple.getT2();
                    return findBorrows
                            .findOverdue()
                            .filter(e -> e.getBorrower().equals(borrower)
                                    && e.getBook().equals(book)
                            );
                })
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinished() {
        return findBorrows
                .findFinished()
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedByIsbn(@ISBN String isbn) {
        return bookFinder
                .find(isbn)
                .flatMapMany(b -> findBorrows
                        .findFinished()
                        .filter(e -> e.getBook().equals(b))
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedByIsbnAndYear(@ISBN String isbn, int year) {
        return bookFinder
                .find(isbn)
                .flatMapMany(b -> findBorrows
                        .findFinished()
                        .filter(e -> e.getBook().equals(b)
                            && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                        )
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedBySsn(@SSN String ssn) {
        return borrowerFinder
                .find(ssn)
                .flatMapMany(b -> findBorrows
                        .findFinished()
                        .filter(e -> e.getBorrower().equals(b))
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedBySsnAndYear(@SSN String ssn, int year) {
        return borrowerFinder
                .find(ssn)
                .flatMapMany(b -> findBorrows
                        .findFinished()
                        .filter(e -> e.getBorrower().equals(b)
                            && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                        )
                        .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)))
                );
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedByIsbnAndSsnAndYear(@ISBN String isbn, @SSN String ssn, int year) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono.zip(bookMono, borrowerMono)
                .flatMapMany(tuple -> {
                    Book book = tuple.getT1();
                    Borrower borrower = tuple.getT2();
                    return findBorrows
                            .findFinished()
                            .filter(e -> e.getBook().equals(book)
                                    && e.getBorrower().equals(borrower)
                                    && ZonedDateTime.parse(e.getBorrowedDate()).getYear() == year
                            );
                })
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

    @Override
    public Flux<BorrowResponseDto> findAllFinishedByIsbnAndSsn(@ISBN String isbn, @SSN String ssn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono.zip(bookMono, borrowerMono)
                .flatMapMany(tuple -> {
                    Book book = tuple.getT1();
                    Borrower borrower = tuple.getT2();
                    return findBorrows
                            .findFinished()
                            .filter(e -> e.getBook().equals(book)
                                    && e.getBorrower().equals(borrower)
                            );
                })
                .flatMap(e -> Flux.just(BorrowResponseMapper.map(e)));
    }

}
