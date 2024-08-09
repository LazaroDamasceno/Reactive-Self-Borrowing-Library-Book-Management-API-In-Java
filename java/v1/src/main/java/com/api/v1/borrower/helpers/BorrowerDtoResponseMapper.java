package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;

public class BorrowerDtoResponseMapper {

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
