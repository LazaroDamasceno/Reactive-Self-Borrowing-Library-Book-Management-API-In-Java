package com.api.v1.borrow;

public class BorrowNotFoundException extends RuntimeException {

    public BorrowNotFoundException(String id) {
        super("Borrow which given id is %s was not found.".formatted(id));
    }

}
