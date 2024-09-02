package com.api.v1.borrow.builders;

import com.api.v1.book.domain.Book;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.dtos.NewBorrowRequestDto;
import com.api.v1.borrower.domain.Borrower;
import jakarta.validation.Valid;

import java.time.ZonedDateTime;
import java.util.UUID;

public class BorrowBuilder {

    private Book book;
    private Borrower borrower;
    private String borrowedDate;
    private String dueDate;

    protected BorrowBuilder() {}

    public static BorrowBuilder create() {
        return new BorrowBuilder();
    }

    public BorrowBuilder fromDto(NewBorrowRequestDto dto) {
        this.book = dto.book();
        this.borrower = dto.borrower();
        this.borrowedDate = ZonedDateTime.now().toString();
        this.dueDate = ZonedDateTime.now().plusDays(14).toString();
        return this;
    }

    public Borrow build() {
        return new Borrow(book, borrower, borrowedDate, dueDate);
    }

}
