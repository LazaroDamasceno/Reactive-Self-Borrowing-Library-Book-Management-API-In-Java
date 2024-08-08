package com.api.v1.book.helpers;

import java.security.SecureRandom;

public interface IsbnGeneratorUtil {

    static String generateIsbn() {
        long min = 1000000000000L;
        long max = 9999999999999L;
        long isbn = new SecureRandom().nextLong(min, max+1);
        return String.valueOf(isbn);
    }

}
