package com.api.v1.borrower.helpers;

import com.api.v1.borrower.domain.Borrower;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FindBorrowerBySsn {

    Mono<Borrower> findBySsn(String ssn);

}
