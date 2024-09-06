package com.api.v1.borrow;

public class BorrowMapper {

    public static BorrowingResponseDto map(Borrow borrow) {
        return new BorrowingResponseDto(
                borrow.getId(),
                borrow.getBorrower(),
                borrow.getBook(),
                borrow.getBorrowingDate(),
                borrow.getDueDate()
        );
    }

}
