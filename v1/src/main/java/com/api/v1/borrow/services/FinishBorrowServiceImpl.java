package com.api.v1.borrow.services;

import com.api.v1.annotations.ISBN;
import com.api.v1.annotations.SSN;
import com.api.v1.book.domain.Book;
import com.api.v1.book.utils.BookFinderUtil;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrow.utils.BorrowFinderUtil;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.utils.BorrowerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class FinishBorrowServiceImpl implements FinishBorrowService {

    @Autowired
    private BorrowRepository repository;

    @Autowired
    private BorrowFinderUtil borrowFinder;

    @Autowired
    private BookFinderUtil bookFinder;

    @Autowired
    private BorrowerFinderUtil borrowerFinder;

    @Override
    public Mono<Borrow> finish(@ISBN String isbn, @SSN String ssn) {
        Mono<Book> bookMono = bookFinder.find(isbn);
        Mono<Borrower> borrowerMono = borrowerFinder.find(ssn);
        return Mono.zip(bookMono, borrowerMono)
                .flatMap(tuple -> {
                    Book book = tuple.getT1();
                    Borrower borrower = tuple.getT2();
                    return borrowFinder.findActive(borrower, book);
                })
                .flatMap(b -> {
                    b.finishBorrow();
                    return repository.save(b);
                });
    }

}
