package com.api.v1.borrow;

import java.math.BigInteger;
import java.time.LocalDate;

public class BorrowSinGeneratorUtil {

    private static int currentYear = LocalDate.now().getYear();
    private static String format = "%04d000".formatted(currentYear);
    private static BigInteger sin = new BigInteger(format);

    public static BigInteger generateSIN() {
        sin = sin.add(BigInteger.ONE);
        return sin;
    }

}