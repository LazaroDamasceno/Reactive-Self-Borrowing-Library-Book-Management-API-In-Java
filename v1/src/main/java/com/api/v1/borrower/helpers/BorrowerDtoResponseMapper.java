package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;

public class BorrowerDtoResponseMapper {

    public static BorrowerResponseDto mapToDtoResponse(Borrower borrower) {
        return new BorrowerResponseDto(
                borrower.getFullName(),
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
