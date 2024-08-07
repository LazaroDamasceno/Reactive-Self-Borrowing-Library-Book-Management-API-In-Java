package com.api.v1.book.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super("Book was not found.");
    }

}
