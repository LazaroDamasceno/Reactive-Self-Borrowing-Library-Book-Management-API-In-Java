package com.api.v1.borrow.builders;

import com.api.v1.book.domain.Book;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.dtos.NewBorrowRequestDto;
import com.api.v1.borrower.domain.Borrower;
import jakarta.validation.Valid;

import java.time.ZonedDateTime;
import java.util.UUID;

public class BorrowBuilder {

    private final UUID id;
    private final Book book;
    private final Borrower borrower;
    private final String borrowedDate;
    private final String dueDate;

    private BorrowBuilder(NewBorrowRequestDto dto) {
        this.id = UUID.randomUUID();
        this.book = dto.book();
        this.borrower = dto.borrower();
        this.borrowedDate = ZonedDateTime.now().toString();
        this.dueDate = ZonedDateTime.now().toString();
    }

    public static BorrowBuilder fromDto(@Valid NewBorrowRequestDto dto) {
        return new BorrowBuilder(dto);
    }

    public Borrow build() {
        return new Borrow(id, book, borrower, borrowedDate, dueDate);
    }

}
