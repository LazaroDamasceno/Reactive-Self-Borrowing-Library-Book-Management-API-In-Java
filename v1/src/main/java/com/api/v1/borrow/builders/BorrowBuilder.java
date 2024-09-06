package com.api.v1.borrow.builders;

import com.api.v1.book.domain.Book;
import com.api.v1.borrow.utils.BorrowSinGeneratorUtil;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrower.domain.Borrower;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class BorrowBuilder {

    private final BigInteger id = BorrowSinGeneratorUtil.generateSIN();
    private Borrower borrower;
    private Book book;
    private final String borrowingDate = ZonedDateTime.now().toString();
    private final String dueDate = ZonedDateTime.now().plusDays(15).toString();

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
        return new Borrow(id, borrower, book, borrowingDate, dueDate);
    }

}
