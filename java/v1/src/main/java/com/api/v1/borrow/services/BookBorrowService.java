package com.api.v1.borrow.services;

import com.api.v1.book.domain.Book;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrower.domain.Borrower;
import reactor.core.publisher.Mono;

public interface BookBorrowService {

    Mono<Borrow> borrowBook(Book book, Borrower borrower);

}
