package com.api.v1.borrower.services;

import com.api.v1.borrower.dtos.BorrowerResponse;
import com.api.v1.borrower.dtos.UpdatedBorrowerRequest;
import reactor.core.publisher.Mono;

public interface UpdateBorrowerService {

    Mono<BorrowerResponse> update(String ssn, UpdatedBorrowerRequest request);

}
