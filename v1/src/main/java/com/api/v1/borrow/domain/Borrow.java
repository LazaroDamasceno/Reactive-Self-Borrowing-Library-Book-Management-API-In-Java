package com.api.v1.borrow.domain;

import com.api.v1.book.domain.Book;
import com.api.v1.borrower.domain.Borrower;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Document(collection = "v1_borrows")
public class Borrow {

    @Id
    private BigInteger id;

    @Field
    private final Borrower borrower;

    @Field
    private final Book book;

    @Field
    private final String borrowingDate;

    @Field
    private final String dueDate;

    @Field
    private String returningDate;

    public Borrow(
            BigInteger id,
            Borrower borrower,
            Book book,
            String borrowingDate,
            String dueDate
    ) {
        this.id = id;
        this.borrower = borrower;
        this.book = book;
        this.borrowingDate = borrowingDate;
        this.dueDate = dueDate;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public Book getBook() {
        return book;
    }

    public String getBorrowingDate() {
        return borrowingDate;
    }

    public String getDueDate() {
        return dueDate;
    }


    public String getReturningDate() {
        return returningDate;
    }

    public BigInteger getId() {
        return id;
    }

}
