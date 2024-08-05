package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
final class BorrowerMapperImpl implements BorrowerMapper {

    @Override
    public Mono<BorrowerResponse> mapFromMono(Mono<Borrower> borrower) {
        return borrower.map(b ->
            new BorrowerResponse(
                b.getFullName(), 
                b.getSsn(), 
                b.getEmail(),
                b.getAddress(), 
                b.getPhoneNumber(), 
                b.getGender(),
                b.getCreatedAt(),
                b.getAIsActive()
        ));
    }

    @Override
    public Flux<BorrowerResponse> mapFromFlux(Flux<Borrower> borrowers) {
        return borrowers
            .map(borrower -> 
                new BorrowerResponse(
                    borrower.getFullName(), 
                    borrower.getSsn(), 
                    borrower.getEmail(),
                    borrower.getAddress(), 
                    borrower.getPhoneNumber(), 
                    borrower.getGender(),
                    borrower.getCreatedAt(),
                    borrower.getAIsActive()
        ));
    }

}
