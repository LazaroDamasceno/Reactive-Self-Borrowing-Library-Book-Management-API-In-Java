package com.api.v1.borrow.dtos;

import com.api.v1.book.dtos.BookResponseDto;
import com.api.v1.borrower.dtos.BorrowerResponseDto;

public record BorrowResponseDto(
        BookResponseDto bookDto,
        BorrowerResponseDto borrowerDto,
        String borrowedDate,
        String dueDate,
        String extendedDueDate,
        String returnedDate
) {
}
