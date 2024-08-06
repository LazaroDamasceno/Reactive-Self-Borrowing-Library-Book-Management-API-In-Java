package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;

class BorrowerResponseMapper {

    public static BorrowerResponse mapFromBorrower(Borrower borrower) {
        return new BorrowerResponse(
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
