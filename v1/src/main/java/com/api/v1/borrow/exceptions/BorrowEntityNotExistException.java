package com.api.v1.borrow.exceptions;

public class BorrowEntityNotExistException extends RuntimeException {

    public BorrowEntityNotExistException() {
        super("The entity Borrow no longer exists.");
    }

}
