package com.api.v1.borrower.services;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.helpers.BorrowerResponseDto;
import com.api.v1.borrower.helpers.NewBorrowerRequestDto;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

public interface BorrowerSelfRegistrationService {

    Mono<BorrowerResponseDto> selfRegister(@Valid NewBorrowerRequestDto request);

}
