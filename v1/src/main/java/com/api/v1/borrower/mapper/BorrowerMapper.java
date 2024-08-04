package com.api.v1.borrower.mapper;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.dtos.BorrowerResponse;

import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Mono;

public class BorrowerMapper {
    
    public static Mono<BorrowerResponse> mapFromBorrower(@NotNull Borrower borrower) {
        BorrowerResponse response = new BorrowerResponse(
            borrower.getFullName(), 
            borrower.getSsn(), 
            borrower.getEmail(),
            borrower.getAddress(), 
            borrower.getPhoneNumber(), 
            borrower.getGender()
        );
        return Mono.just(response);
    }

}
