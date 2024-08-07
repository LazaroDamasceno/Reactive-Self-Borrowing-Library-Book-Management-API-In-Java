package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;

interface BorrowerResponseMapperUtil {

    static BorrowerResponseDto mapFromBorrower(Borrower borrower) {
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
