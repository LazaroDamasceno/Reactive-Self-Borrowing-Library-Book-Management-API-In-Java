package com.api.v1.borrower.services;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.helpers.NewBorrowerRequestDto;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

public interface BorrowerSelfRegistrationService {

    Mono<Borrower> selfRegister(@Valid NewBorrowerRequestDto request);

}
