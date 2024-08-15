package com.api.v1.borrow.dtos;

import com.api.v1.book.domain.Book;
import com.api.v1.borrower.domain.Borrower;

public record BorrowResponseDto(
        Book book,
        Borrower borrower,
        String borrowedDate,
        String dueDate,
        String extendedDueDate,
        String returnedDate
) {
}
