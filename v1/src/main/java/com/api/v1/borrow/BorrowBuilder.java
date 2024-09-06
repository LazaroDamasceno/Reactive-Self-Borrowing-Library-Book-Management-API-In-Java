package com.api.v1.borrow;

import com.api.v1.book.domain.Book;
import com.api.v1.borrower.domain.Borrower;

public class BorrowBuilder {

    private Borrower borrower;
    private Book book;

    public static BorrowBuilder create() {
        return new BorrowBuilder();
    }

    public BorrowBuilder withBorrower(Borrower borrower) {
        this.borrower = borrower;
        return this;
    }

    public BorrowBuilder withBook(Book book) {
        this.book = book;
        return this;
    }

    public Borrow build() {
        return new Borrow(borrower, book);
    }

}
