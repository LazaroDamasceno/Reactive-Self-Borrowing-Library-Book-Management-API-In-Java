package com.api.v1.borrow.exceptions;

public class UnfinishableBorrowException extends RuntimeException {

    public UnfinishableBorrowException(String id) {
        super("Borrow which id is %s is unfinishable.".formatted(id));
    }

}
