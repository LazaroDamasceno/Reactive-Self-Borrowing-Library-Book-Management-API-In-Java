package com.api.v1.borrower.services;

import com.api.v1.borrower.dtos.BorrowerRequest;

import reactor.core.publisher.Mono;

public interface BorrowerSelfRegistrationService {

    Mono<Void> sefRegister(BorrowerRequest request);

}
