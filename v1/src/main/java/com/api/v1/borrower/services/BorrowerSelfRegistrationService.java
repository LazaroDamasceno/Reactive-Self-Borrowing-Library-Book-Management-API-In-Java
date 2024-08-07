package com.api.v1.borrower.services;

import com.api.v1.borrower.helpers.NewBorrowerRequestDto;
import com.api.v1.borrower.helpers.BorrowerResponseDto;

import reactor.core.publisher.Mono;

public interface BorrowerSelfRegistrationService {

    Mono<BorrowerResponseDto> sefRegister(NewBorrowerRequestDto request);

}
