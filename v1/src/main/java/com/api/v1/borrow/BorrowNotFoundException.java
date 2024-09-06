package com.api.v1.borrow;

import java.math.BigInteger;

public class BorrowNotFoundException extends RuntimeException {

    public BorrowNotFoundException(BigInteger id) {
        super("Borrow which given id is %s was not found.".formatted(id));
    }

}
