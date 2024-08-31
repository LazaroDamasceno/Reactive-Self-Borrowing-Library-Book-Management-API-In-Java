package com.api.v1.borrower.services;

import com.api.v1.borrower.domain.Borrower;

import com.api.v1.borrower.dtos.BorrowerResponseDto;
import com.api.v1.borrower.dtos.NewBorrowerRequestDto;
import reactor.core.publisher.Mono;

public interface UpdateBorrowerService {

    Mono<BorrowerResponseDto> update(NewBorrowerRequestDto request);

}
