package com.api.v1.borrower.services;

import com.api.v1.borrower.helpers.NewBorrowerRequest;
import com.api.v1.borrower.helpers.BorrowerResponse;

import reactor.core.publisher.Mono;

public interface BorrowerSelfRegistrationService {

    Mono<BorrowerResponse> sefRegister(NewBorrowerRequest request);

}
