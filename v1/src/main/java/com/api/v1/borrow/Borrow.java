package com.api.v1.borrow;

import com.api.v1.book.domain.Book;
import com.api.v1.borrower.domain.Borrower;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.time.ZonedDateTime;

@Document(collection = "v1_borrows")
public class Borrow {

    @Id
    private BigInteger id;

    @Field
    private Borrower borrower;

    @Field
    private Book book;

    @Field
    private String BorrowingDate;

    @Field
    private String dueDate;

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
        BorrowingDate = borrowingDate;
        this.dueDate = dueDate;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public Book getBook() {
        return book;
    }

    public String getBorrowingDate() {
        return BorrowingDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public BigInteger getId() {
        return id;
    }

}
