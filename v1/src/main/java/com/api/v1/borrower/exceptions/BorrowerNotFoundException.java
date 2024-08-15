package com.api.v1.borrower.exceptions;

public class BorrowerNotFoundException extends RuntimeException {

    public BorrowerNotFoundException() {
        super("Borrower was not found.");
    }

}
