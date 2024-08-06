package com.api.v1.borrower.helpers.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.helpers.dtos.BorrowerResponse;

import reactor.core.publisher.Flux;

@Component
public final class BorrowerFluxMapper {

    @Autowired
    private BorrowerResponseMapper mapper;

    public Flux<BorrowerResponse> mapFromFlux(Flux<Borrower> flux) {
        return flux.flatMap(b -> Flux.just(mapper.mapFromBorrower(b)));
    }
    
}
