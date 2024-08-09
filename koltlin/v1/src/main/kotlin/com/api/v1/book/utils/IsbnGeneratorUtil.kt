package com.api.v1.book.utils

import java.security.SecureRandom

class IsbnGeneratorUtil {

    companion object {
        fun generator(): String {
            val min: Long = 1000000000000L
            val max: Long = 9999999999999L
            return SecureRandom().nextLong(min, max+1).toString()
        }
    }

}
