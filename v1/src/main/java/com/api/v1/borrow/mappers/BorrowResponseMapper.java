package com.api.v1.borrow.mappers;

import com.api.v1.book.mappers.BookDtoResponseMapper;
import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.dtos.BorrowResponseDto;
import com.api.v1.borrower.mappers.BorrowerDtoResponseMapper;

public class BorrowResponseMapper {

    public static BorrowResponseDto map(Borrow borrow) {
        return new BorrowResponseDto(
                BookDtoResponseMapper.map(borrow.getBook()),
                BorrowerDtoResponseMapper.map(borrow.getBorrower()),
                borrow.getBorrowedDate(),
                borrow.getDueDate(),
                borrow.getExtendedDueDate(),
                borrow.getReturnedDate()
        );
    }

}
