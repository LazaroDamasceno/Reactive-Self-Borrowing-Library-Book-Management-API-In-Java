package com.api.v1.borrow;

public class BorrowingMapper {

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
