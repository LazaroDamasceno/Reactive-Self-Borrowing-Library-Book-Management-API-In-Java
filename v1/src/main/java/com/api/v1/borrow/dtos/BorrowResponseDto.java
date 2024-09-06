package com.api.v1.borrow.dtos;

import com.api.v1.book.dtos.BookResponseDto;
import com.api.v1.borrower.dtos.BorrowerResponseDto;

import java.math.BigInteger;

public record BorrowResponseDto(
        BigInteger id,
        BorrowerResponseDto borrower,
        BookResponseDto book,
        String borrowingDate,
        String dueDate
) {
}
