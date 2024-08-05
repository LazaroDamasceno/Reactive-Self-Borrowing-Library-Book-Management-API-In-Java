package com.api.v1.borrower.helpers.mappers;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.helpers.dtos.BorrowerResponse;

final class BorrowerResponseMapper {

    public BorrowerResponse mapFromBorrower(Borrower borrower) {
        return new BorrowerResponse(
            borrower.getFullName(), 
            borrower.getSsn(), 
            borrower.getEmail(),
            borrower.getAddress(), 
            borrower.getPhoneNumber(), 
            borrower.getGender(),
            borrower.getCreatedAt(),
            borrower.getAIsActive()
        );
    }
    
}
