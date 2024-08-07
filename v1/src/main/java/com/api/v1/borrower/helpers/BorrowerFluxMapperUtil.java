package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;

import reactor.core.publisher.Flux;

public interface BorrowerFluxMapperUtil {

    static Flux<BorrowerResponseDto> mapFromFlux(Flux<Borrower> flux) {
        return flux.flatMap(b -> Flux.just(BorrowerResponseMapperUtil.mapFromBorrower(b)));
    }
    
}
