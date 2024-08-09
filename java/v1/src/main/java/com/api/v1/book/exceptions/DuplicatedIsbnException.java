package com.api.v1.book.exceptions;

public class DuplicatedIsbnException extends RuntimeException {

    public DuplicatedIsbnException(String message) {
        super(message);
    }

}
