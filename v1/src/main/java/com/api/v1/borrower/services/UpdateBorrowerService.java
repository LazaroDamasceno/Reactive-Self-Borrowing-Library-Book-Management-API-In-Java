package com.api.v1.borrower.services;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.helpers.UpdateBorrowerRequestDto;

import reactor.core.publisher.Mono;

public interface UpdateBorrowerService {

    Mono<Borrower> update(String ssn, UpdateBorrowerRequestDto request);

}
