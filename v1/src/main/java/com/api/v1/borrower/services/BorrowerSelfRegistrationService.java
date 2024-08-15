package com.api.v1.borrower.services;

import com.api.v1.borrower.dtos.BorrowerResponseDto;
import com.api.v1.borrower.dtos.NewBorrowerRequestDto;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

public interface BorrowerSelfRegistrationService {

    Mono<BorrowerResponseDto> selfRegister(@Valid NewBorrowerRequestDto request);

}
