package com.api.v1.borrow;

public class BorrowMapper {

    public static BorrowResponseDto map(Borrow borrow) {
        return new BorrowResponseDto(
                borrow.getId(),
                borrow.getBorrower(),
                borrow.getBook(),
                borrow.getBorrowingDate(),
                borrow.getDueDate()
        );
    }

}
