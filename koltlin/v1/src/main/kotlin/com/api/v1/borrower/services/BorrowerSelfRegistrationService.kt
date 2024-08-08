package com.api.v1.borrower.services

import com.api.v1.borrower.helpers.BorrowerResponseDto
import com.api.v1.borrower.helpers.NewBorrowerRequestDto
import reactor.core.publisher.Mono

interface BorrowerSelfRegistrationService {

    fun selfRegister(request: NewBorrowerRequestDto): Mono<BorrowerResponseDto>

}