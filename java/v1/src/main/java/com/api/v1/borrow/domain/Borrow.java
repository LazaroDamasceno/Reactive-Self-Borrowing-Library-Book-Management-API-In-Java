package com.api.v1.borrow.domain;

import com.api.v1.book.domain.Book;
import com.api.v1.borrower.domain.Borrower;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.ZonedDateTime;
import java.util.UUID;

@Document
public class Borrow {

    @Id
    private UUID id;

    @Field
    private Book book;

    @Field
    private Borrower borrower;

    @Field
    private final String borrowedDate;

    @Field
    private final String dueDate;

    @Field
    private String extendedDueDate;

    @Field
    private String returnedDate;

    public Borrow(
            UUID id,
            Book book,
            Borrower borrower,
            String borrowedDate,
            String dueDate
    ) {
        this.id = id;
        this.book = book;
        this.borrower = borrower;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public void extendDueDate() {
        this.extendedDueDate = ZonedDateTime.now().toString();
    }

    public void finishBorrow() {
        this.returnedDate = ZonedDateTime.now().toString();
    }

    public UUID getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getExtendedDueDate() {
        return extendedDueDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

}
