package com.api.v1.borrow;

public class BorrowNotFoundException extends RuntimeException {

    public BorrowNotFoundException(Object sin) {
        super("Borrow which given SIN is %s was not found.".formatted(sin));
    }

}
