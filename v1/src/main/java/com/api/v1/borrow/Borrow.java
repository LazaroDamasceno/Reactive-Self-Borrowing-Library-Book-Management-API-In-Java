package com.api.v1.borrow;

import com.api.v1.book.domain.Book;
import com.api.v1.borrower.domain.Borrower;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.ZonedDateTime;

@Document(collection = "v1_borrows")
public class Borrow {

    @Id
    private ObjectId id = new ObjectId();

    @Field
    private Borrower borrower;

    @Field
    private Book book;

    @Field
    private String BorrowingDate = ZonedDateTime.now().toString();

    @Field
    private String dueDate = ZonedDateTime.now().plusDays(15).toString();

    public Borrow(Borrower borrower, Book book) {
        this.borrower = borrower;
        this.book = book;
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

    public ObjectId getId() {
        return id;
    }

}
