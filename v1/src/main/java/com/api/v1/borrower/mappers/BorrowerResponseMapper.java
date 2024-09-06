package com.api.v1.borrower.mappers;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.dtos.BorrowerResponseDto;

public class BorrowerResponseMapper {

    public static BorrowerResponseDto map(Borrower borrower) {
        return new BorrowerResponseDto(
                borrower.getFullName(),
                borrower.getBirthDate(),
                borrower.getSsn(),
                borrower.getEmail(),
                borrower.getAddress(),
                borrower.getPhoneNumber(),
                borrower.getGender(),
                borrower.getCreatedAt(),
                borrower.getUpdatedAt()
        );
    }

}
