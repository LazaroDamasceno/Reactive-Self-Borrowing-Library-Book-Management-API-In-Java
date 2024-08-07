package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;

import reactor.core.publisher.Mono;

public interface BorrowerMonoMapperUtil {

    static Mono<BorrowerResponseDto> mapFromMono(Mono<Borrower> mono) {
        return mono.flatMap(b -> Mono.just(BorrowerResponseMapperUtil.mapFromBorrower(b)));
    }
    
}
