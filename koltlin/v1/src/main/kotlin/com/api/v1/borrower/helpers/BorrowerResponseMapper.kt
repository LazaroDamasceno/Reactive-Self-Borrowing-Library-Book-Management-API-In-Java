package com.api.v1.borrower.helpers

import com.api.v1.borrower.domain.Borrower

class BorrowerResponseMapper {

    companion object {
        fun map(borrower: Borrower): BorrowerResponseDto {
            return BorrowerResponseDto(
                borrower.getFullName(),
                borrower.ssn,
                borrower.birthDate,
                borrower.email,
                borrower.address,
                borrower.gender,
                borrower.phoneNumber,
                borrower.createdAt,
                borrower.updatedAt
            )
        }
    }

}