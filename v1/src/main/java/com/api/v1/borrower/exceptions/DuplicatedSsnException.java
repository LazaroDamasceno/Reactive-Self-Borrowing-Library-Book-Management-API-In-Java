package com.api.v1.borrower.exceptions;

public class DuplicatedSsnException extends RuntimeException {
    
    public DuplicatedSsnException() {
        super("The input SSN was already registered.");
    }

}
