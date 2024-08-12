package com.api.v1.borrow.mappers;

import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.dtos.BorrowResponseDto;

public class BorrowResponseMapper {

    public static BorrowResponseDto map(Borrow borrow) {
        return new BorrowResponseDto(
                borrow.getBook(),
                borrow.getBorrower(),
                borrow.getBorrowedDate(),
                borrow.getDueDate(),
                borrow.getExtendedDueDate(),
                borrow.getReturnedDate()
        );
    }

}
