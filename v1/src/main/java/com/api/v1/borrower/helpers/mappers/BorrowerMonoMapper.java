package com.api.v1.borrower.helpers.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.helpers.dtos.BorrowerResponse;

import reactor.core.publisher.Mono;

@Component
public final class BorrowerMonoMapper {

    @Autowired
    private BorrowerResponseMapper mapper;

    public Mono<BorrowerResponse> mapFromMono(Mono<Borrower> mono) {
        return mono.flatMap(b -> Mono.just(mapper.mapFromBorrower(b)));
    }
    
}
