package com.api.v1.borrow;

import java.math.BigInteger;
import java.time.LocalDate;

public class BorrowIdGeneratorUtil {

    private static int currentYear = LocalDate.now().getYear();
    private static String batch = "%d000".formatted(currentYear);
    private static BigInteger id = new BigInteger(batch);

    public static BigInteger generateId() {
        id = id.add(BigInteger.ONE);
        return id;
    }

}
