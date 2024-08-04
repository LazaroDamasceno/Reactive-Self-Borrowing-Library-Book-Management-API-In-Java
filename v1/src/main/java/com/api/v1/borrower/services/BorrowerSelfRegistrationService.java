package com.api.v1.borrower.services;

import com.api.v1.borrower.dtos.BorrowerRequest;
import com.api.v1.borrower.dtos.BorrowerResponse;

import reactor.core.publisher.Mono;

public interface BorrowerSelfRegistrationService {

    Mono<BorrowerResponse> selfRegister(BorrowerRequest request);
    
}
