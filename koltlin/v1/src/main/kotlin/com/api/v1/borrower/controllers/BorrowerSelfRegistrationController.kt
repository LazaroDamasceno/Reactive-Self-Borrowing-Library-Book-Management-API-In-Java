package com.api.v1.borrower.controllers

import com.api.v1.borrower.helpers.BorrowerResponseDto
import com.api.v1.borrower.helpers.NewBorrowerRequestDto
import com.api.v1.borrower.services.BorrowerSelfRegistrationService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/v1/borrowers")
class BorrowerSelfRegistrationController {

    private val service: BorrowerSelfRegistrationService

    constructor(service: BorrowerSelfRegistrationService) {
        this.service = service
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun selfRegister(@Valid @RequestBody request: NewBorrowerRequestDto): Mono<BorrowerResponseDto> {
        return service.selfRegister(request)
    }

}