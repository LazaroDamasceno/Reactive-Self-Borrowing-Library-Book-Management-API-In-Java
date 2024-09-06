package com.api.v1.borrow.exceptions;

public class BorrowFinishingException extends RuntimeException {

    public BorrowFinishingException() {
        super("Borrow cannot be finished.");
    }

}
