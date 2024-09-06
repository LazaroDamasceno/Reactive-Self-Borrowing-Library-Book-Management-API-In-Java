package com.api.v1.borrow.exceptions;

public class BorrowNotFoundException extends RuntimeException {

    public BorrowNotFoundException(String id) {
        super("Borrow which given SIN is %s was not found.".formatted(id));
    }

}
