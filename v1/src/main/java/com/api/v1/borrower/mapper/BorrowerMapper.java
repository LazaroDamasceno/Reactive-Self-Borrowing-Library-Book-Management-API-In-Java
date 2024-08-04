package com.api.v1.borrower.mapper;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.dtos.BorrowerResponse;

import jakarta.validation.constraints.NotNull;

public class BorrowerMapper {
    
    public static BorrowerResponse mapFromBorrower(@NotNull Borrower borrower) {
        return new BorrowerResponse(
            borrower.getFullName(), 
            borrower.getSsn(), 
            borrower.getEmail(),
            borrower.getAddress(), 
            borrower.getPhoneNumber(), 
            borrower.getGender()
        );
    }

}
