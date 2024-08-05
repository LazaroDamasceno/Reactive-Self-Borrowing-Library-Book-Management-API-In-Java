package com.api.v1.borrower.helpers.mappers;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.helpers.dtos.BorrowerResponse;

import reactor.core.publisher.Mono;

public interface  MonoMapper {

    Mono<BorrowerResponse> mapFromMono(Mono<Borrower> mono);
    
}
