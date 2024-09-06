package com.api.v1.borrow.exceptions;

public class UnfinishableBorrowException extends RuntimeException {

    public UnfinishableBorrowException(String id) {
        super("borrow which id %s is unfinishable");
    }

}
