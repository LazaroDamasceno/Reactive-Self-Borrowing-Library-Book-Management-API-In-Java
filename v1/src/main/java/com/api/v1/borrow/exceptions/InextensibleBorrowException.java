package com.api.v1.borrow.exceptions;

public class InextensibleBorrowException extends RuntimeException {

    public InextensibleBorrowException(String id) {
        super("Borrow which id is %s cannot be extended".formatted(id));
    }
}
