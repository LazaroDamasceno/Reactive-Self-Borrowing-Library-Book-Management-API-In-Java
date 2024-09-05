package com.api.v1.borrow.exceptions;

public class BorrowExtensionException extends RuntimeException {

    public BorrowExtensionException() {
        super("The borrow cannot be extended.");
    }

}
