package com.api.v1.borrow.utils;

import java.math.BigInteger;
import java.time.LocalDate;

public class BorrowIdGeneratorUtil {

    private static final int currentYear = LocalDate.now().getYear();
    private static final String format = "%04d000".formatted(currentYear);
    private static BigInteger sin = new BigInteger(format);

    public static BigInteger generateSIN() {
        sin = sin.add(BigInteger.ONE);
        return sin;
    }

}