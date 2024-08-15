package com.api.v1.borrower.exceptions;

public class DuplicatedSsnException extends RuntimeException {

    public DuplicatedSsnException(String message) {
        super(message);
    }

}
