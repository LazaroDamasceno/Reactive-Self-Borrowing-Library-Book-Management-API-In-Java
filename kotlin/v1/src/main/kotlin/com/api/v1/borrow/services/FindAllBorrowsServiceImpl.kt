package com.api.v1.borrow.services

import com.api.v1.annotations.ISBN
import com.api.v1.annotations.SSN
import com.api.v1.book.domain.Book
import com.api.v1.book.utils.BookFinderUtil
import com.api.v1.borrow.domain.Borrow
import com.api.v1.borrow.dtos.BorrowResponseDto
import com.api.v1.borrow.mappers.BorrowResponseMapper
import com.api.v1.borrow.utils.FindBorrowsUtil
import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.utils.BorrowerFinderUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.util.function.Tuple2
import java.time.ZonedDateTime

@Service
internal class FindAllBorrowsServiceImpl {

    @Autowired
    private lateinit var findBorrows: FindBorrowsUtil

    @Autowired
    private lateinit var bookFinder: BookFinderUtil

    @Autowired
    private lateinit var borrowerFinder: BorrowerFinderUtil

    fun findAll(): Flux<BorrowResponseDto> {
        return findBorrows
            .findAll()
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    fun findAllByIsbn(@ISBN isbn: String): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany<BorrowResponseDto> { book: Book ->
                findBorrows
                    .findAll()
                    .filter { e -> e.book == book }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllByIsbnAndYear(@ISBN isbn: String, year: Int): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany<BorrowResponseDto> { book: Book ->
                findBorrows
                    .findAll()
                    .filter { e -> e.book == book 
                            && ZonedDateTime.parse(e.borrowedDate).year == year 
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllBySsn(@SSN ssn: String): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany<BorrowResponseDto> { borrower: Borrower ->
                findBorrows
                    .findAll()
                    .filter { e -> e.borrower == borrower }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllBySsnAndYear(@SSN ssn: String, year: Int): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany<BorrowResponseDto> { borrower: Borrower ->
                findBorrows
                    .findAll()
                    .filter { e -> e.borrower == borrower
                            && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllByIsbnAndSsnAndYear(
        @ISBN isbn: String,
        @SSN ssn: String,
        year: Int
    ): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip<Book, Borrower>(bookMono, borrowerMono)
            .flatMapMany<Borrow> { tuple: Tuple2<Book, Borrower> ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findAll()
                    .filter { e -> e.borrower == borrower
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    fun findAllByIsbnAndSsn(@ISBN isbn: String, @SSN ssn: String): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip<Book, Borrower>(bookMono, borrowerMono)
            .flatMapMany<Borrow> { tuple: Tuple2<Book, Borrower> ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findAll()
                    .filter { e -> e.borrower == borrower && e.book == book }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    fun findAllActive(): Flux<BorrowResponseDto> {
        return findBorrows
            .findActive()
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    fun findAllActiveByIsbn(@ISBN isbn: String): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany<BorrowResponseDto> { b: Book ->
                findBorrows
                    .findActive()
                    .filter { e -> e.book == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllActiveByIsbnAndYear(@ISBN isbn: String, year: Int): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany<BorrowResponseDto> { b: Book ->
                findBorrows
                    .findActive()
                    .filter { e -> e.book == b
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllActiveBySsn(@SSN ssn: String): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany<BorrowResponseDto> { b: Borrower ->
                findBorrows
                    .findActive()
                    .filter { e -> e.borrower == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllActiveBySsnAndYear(@SSN ssn: String, year: Int): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany<BorrowResponseDto> { b: Borrower ->
                findBorrows
                    .findActive()
                    .filter { e -> e.borrower == b
                            && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllActiveByIsbnAndSsnAndYear(
        @ISBN isbn: String,
        @SSN ssn: String,
        year: Int
    ): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip<Book, Borrower>(bookMono, borrowerMono)
            .flatMapMany<Borrow> { tuple: Tuple2<Book, Borrower> ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findActive()
                    .filter { e -> e.borrower == borrower
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    fun findAllActiveByIsbnAndSsn(@ISBN isbn: String, @SSN ssn: String): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip<Book, Borrower>(bookMono, borrowerMono)
            .flatMapMany<Borrow> { tuple: Tuple2<Book, Borrower> ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findActive()
                    .filter { e -> e.borrower == borrower && e.book == book }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    fun findAllOverdue(): Flux<BorrowResponseDto> {
        return findBorrows
            .findOverdue()
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    fun findAllOverdueByIsbn(@ISBN isbn: String): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany<BorrowResponseDto> { b: Book ->
                findBorrows
                    .findOverdue()
                    .filter { e -> e.book == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllOverdueByIsbnAndYear(@ISBN isbn: String, year: Int): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany<BorrowResponseDto> { b: Book ->
                findBorrows
                    .findOverdue()
                    .filter { e -> e.book == b
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllOverdueBySsn(@SSN ssn: String): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany<BorrowResponseDto> { b: Borrower ->
                findBorrows
                    .findOverdue()
                    .filter { e -> e.borrower == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllOverdueBySsnAndYear(@SSN ssn: String, year: Int): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany<BorrowResponseDto> { b: Borrower ->
                findBorrows
                    .findOverdue()
                    .filter { e -> e.borrower == b
                            && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllOverdueByIsbnAndSsnAndYear(
        @ISBN isbn: String,
        @SSN ssn: String,
        year: Int
    ): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip<Book, Borrower>(bookMono, borrowerMono)
            .flatMapMany<Borrow> { tuple: Tuple2<Book, Borrower> ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findOverdue()
                    .filter { e -> e.borrower == borrower && e.book == book
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    fun findAllOverdueByIsbnAndSsn(@ISBN isbn: String, @SSN ssn: String): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip<Book, Borrower>(bookMono, borrowerMono)
            .flatMapMany<Borrow> { tuple: Tuple2<Book, Borrower> ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findOverdue()
                    .filter { e -> e.borrower == borrower && e.book == book }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    fun findAllFinished(): Flux<BorrowResponseDto> {
        return findBorrows
            .findFinished()
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    fun findAllFinishedByIsbn(@ISBN isbn: String): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany<BorrowResponseDto> { b: Book ->
                findBorrows
                    .findFinished()
                    .filter { e -> e.book == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllFinishedByIsbnAndYear(@ISBN isbn: String, year: Int): Flux<BorrowResponseDto> {
        return bookFinder
            .find(isbn)
            .flatMapMany<BorrowResponseDto> { b: Book ->
                findBorrows
                    .findFinished()
                    .filter { e -> e.book == b
                            && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllFinishedBySsn(@SSN ssn: String): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany<BorrowResponseDto> { b: Borrower ->
                findBorrows
                    .findFinished()
                    .filter { e -> e.borrower == b }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllFinishedBySsnAndYear(@SSN ssn: String, year: Int): Flux<BorrowResponseDto> {
        return borrowerFinder
            .find(ssn)
            .flatMapMany<BorrowResponseDto> { b: Borrower ->
                findBorrows
                    .findFinished()
                    .filter { e -> e.borrower == b
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
                    .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
            }
    }

    fun findAllFinishedByIsbnAndSsnAndYear(
        @ISBN isbn: String,
        @SSN ssn: String,
        year: Int
    ): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip<Book, Borrower>(bookMono, borrowerMono)
            .flatMapMany<Borrow> { tuple: Tuple2<Book, Borrower> ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findFinished()
                    .filter { e ->
                                e.book == book && e.borrower == borrower
                                && ZonedDateTime.parse(e.borrowedDate).year == year
                    }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }

    fun findAllFinishedByIsbnAndSsn(@ISBN isbn: String, @SSN ssn: String): Flux<BorrowResponseDto> {
        val bookMono = bookFinder.find(isbn)
        val borrowerMono = borrowerFinder.find(ssn)
        return Mono.zip<Book, Borrower>(bookMono, borrowerMono)
            .flatMapMany<Borrow> { tuple: Tuple2<Book, Borrower> ->
                val book = tuple.t1
                val borrower = tuple.t2
                findBorrows
                    .findFinished()
                    .filter { e -> e.book == book && e.borrower == borrower }
            }
            .flatMap { e -> Flux.just(BorrowResponseMapper.map(e)) }
    }
    
}