package com.api.v1.borrow.dtos;

import com.api.v1.book.domain.Book;
import com.api.v1.borrower.domain.Borrower;
import jakarta.validation.constraints.NotNull;

public record NewBorrowRequestDto(
        @NotNull Book book,
        @NotNull Borrower borrower
) {
}
