package com.api.v1.borrower.services;

import com.api.v1.borrower.helpers.dtos.BorrowerRequest;
import com.api.v1.borrower.helpers.dtos.BorrowerResponse;

import reactor.core.publisher.Mono;

public interface BorrowerSelfRegistrationService {

    Mono<BorrowerResponse> sefRegister(BorrowerRequest request);

}
