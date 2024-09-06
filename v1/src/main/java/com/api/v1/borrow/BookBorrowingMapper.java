package com.api.v1.borrow;

public class BookBorrowingMapper {

    public static BookBorrowingResponseDto map(Borrow borrow) {
        return new BookBorrowingResponseDto(
                borrow.getId(),
                borrow.getBorrower(),
                borrow.getBook(),
                borrow.getBorrowingDate(),
                borrow.getDueDate()
        );
    }

}
