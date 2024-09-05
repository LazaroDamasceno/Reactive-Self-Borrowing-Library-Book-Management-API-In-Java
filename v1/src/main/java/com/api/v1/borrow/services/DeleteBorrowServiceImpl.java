package com.api.v1.borrow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.book.domain.Book;
import com.api.v1.book.utils.BookFinderUtil;
import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrow.utils.BorrowFinderUtil;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.utils.BorrowerFinderUtil;

import reactor.core.publisher.Mono;

@Service
class DeleteBorrowServiceImpl implements DeleteBorrowService {

    @Autowired
    private BorrowRepository repository;

    @Autowired
    private BorrowFinderUtil borrowFinder;

    @Autowired
    private BorrowerFinderUtil borrowerFinder;

    @Autowired
    private BookFinderUtil bookFinder;

    @Override
    public Mono<Void> delete(@ISBN String isbn, @SSN String ssn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono.zip(bookMono, borrowerMono)
            .flatMap(tuple -> {
                Book book = tuple.getT1();
                Borrower borrower = tuple.getT2();
                return borrowFinder.findAny(borrower, book);
            })
            .flatMap(b -> repository.delete(b));
    }
    
}
