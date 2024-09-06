package com.api.v1.borrow;

import com.api.v1.book.mappers.BookResponseMapper;
import com.api.v1.borrower.mappers.BorrowerResponseMapper;

public class BorrowResponseMapper {

    public static BorrowResponseDto map(Borrow borrow) {
        return new BorrowResponseDto(
                borrow.getId(),
                BorrowerResponseMapper.map(borrow.getBorrower()),
                BookResponseMapper.map(borrow.getBook()),
                borrow.getBorrowingDate(),
                borrow.getDueDate()
        );
    }

}
