package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;

import reactor.core.publisher.Mono;

public class BorrowerMonoMapper {

    public static Mono<BorrowerResponse> mapFromMono(Mono<Borrower> mono) {
        return mono.flatMap(b -> Mono.just(BorrowerResponseMapper.mapFromBorrower(b)));
    }
    
}
