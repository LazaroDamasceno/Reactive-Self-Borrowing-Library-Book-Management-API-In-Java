package com.api.v1.borrow.exceptions;

public class BorrowEntityNotExistsException extends RuntimeException {

    public BorrowEntityNotExistsException() {
        super("The entity Borrow no longer exists.");
    }

}
