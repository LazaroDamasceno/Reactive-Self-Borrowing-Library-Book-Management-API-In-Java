package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;

import reactor.core.publisher.Flux;

public class BorrowerFluxMapper {

    public static Flux<BorrowerResponse> mapFromFlux(Flux<Borrower> flux) {
        return flux.flatMap(b -> Flux.just(BorrowerResponseMapper.mapFromBorrower(b)));
    }
    
}
