package com.api.v1.borrow.utils;

import com.api.v1.book.domain.Book;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrow.exceptions.BorrowNotFoundException;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.exceptions.BorrowerNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BorrowFinderUtil {

    @Autowired
    private BorrowRepository repository;

    public Mono<Borrow> find(@NotNull Borrower borrower, @NotNull Book book) {
        String message = "Borrow was not found.";
        return repository
                .findAll()
                .filter(e -> e.getBorrower().equals(borrower) &&
                        e.getBook().equals(book) &&
                        e.getReturnedDate() == null
                )
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new BorrowNotFoundException(message)));
    }

}
