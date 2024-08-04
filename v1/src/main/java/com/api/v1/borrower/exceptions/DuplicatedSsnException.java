package com.api.v1.borrower.exceptions;

public class DuplicatedSsnException extends RuntimeException {

    public DuplicatedSsnException() {
        super("The input was already registered. Please, inout another one.");
    }
    
}
