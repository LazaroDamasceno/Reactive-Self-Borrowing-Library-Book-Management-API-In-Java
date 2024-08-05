package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BorrowerMapper {

    Mono<BorrowerResponse> mapFromMono(Mono<Borrower> borrower);
    Flux<BorrowerResponse> mapFromFlux(Flux<Borrower> borrowers);

}
