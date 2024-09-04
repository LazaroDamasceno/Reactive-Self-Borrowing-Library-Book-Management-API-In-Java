package com.api.v1.borrower.services;

import reactor.core.publisher.Mono;

public interface DeleteBorrowerBySsnService {

    Mono<Void> deleteBySsn(String ssn);

}
