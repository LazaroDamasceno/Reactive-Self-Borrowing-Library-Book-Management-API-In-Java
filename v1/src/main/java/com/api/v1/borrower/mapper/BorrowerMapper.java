package com.api.v1.borrower.mapper;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.dtos.BorrowerResponse;

import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class BorrowerMapper {
    
    public static Mono<BorrowerResponse> mapFromBorrower(@NotNull Mono<Borrower> borrower) {
        return borrower.map(b ->
            new BorrowerResponse(
                b.getFullName(), 
                b.getSsn(), 
                b.getEmail(),
                b.getAddress(), 
                b.getPhoneNumber(), 
                b.getGender()
        ));
    }

    public static Flux<BorrowerResponse> mapFromFlux(Flux<Borrower> borrowers) {
        return borrowers
            .map(borrower -> new BorrowerResponse(
                borrower.getFullName(), 
                borrower.getSsn(), 
                borrower.getEmail(),
                borrower.getAddress(), 
                borrower.getPhoneNumber(), 
                borrower.getGender()
        ));
    }

}
