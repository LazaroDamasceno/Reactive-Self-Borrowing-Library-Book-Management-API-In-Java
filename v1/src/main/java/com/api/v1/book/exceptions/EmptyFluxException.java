package com.api.v1.book.exceptions;

public class EmptyFluxException extends RuntimeException {

    public EmptyFluxException() {
        super("The flux has no elements.");
    }

}
