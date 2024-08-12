package com.api.v1.borrow.exceptions;

public class BorrowNotFoundException extends RuntimeException {

    public BorrowNotFoundException(String message) {
        super(message);
    }

}
