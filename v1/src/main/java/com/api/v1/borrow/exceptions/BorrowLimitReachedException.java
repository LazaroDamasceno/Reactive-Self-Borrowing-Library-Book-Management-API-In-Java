package com.api.v1.borrow.exceptions;

public class BorrowLimitReachedException extends RuntimeException {

    public BorrowLimitReachedException() {
        super("The borrowing limit has been reached.");
    }

}
