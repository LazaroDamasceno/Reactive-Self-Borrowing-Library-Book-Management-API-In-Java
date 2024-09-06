package com.api.v1.borrow;

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
    private Borrower borrower;

    @Field
    private Book book;

    @Field
    private String borrowingDate;

    @Field
    private String dueDate;

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

    public BigInteger getId() {
        return id;
    }

    public String getReturningDate() {
        return returningDate;
    }

}
