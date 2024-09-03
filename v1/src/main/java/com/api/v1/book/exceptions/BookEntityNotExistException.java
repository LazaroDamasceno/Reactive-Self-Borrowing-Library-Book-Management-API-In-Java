package com.api.v1.book.exceptions;

public class BookEntityNotExistException extends RuntimeException {

    public BookEntityNotExistException() {
        super("The entity Book no longer exists.");
    }

}
