package com.api.v1.borrower.controllers

import com.api.v1.borrower.helpers.BorrowerResponseDto
import com.api.v1.borrower.services.FindAllBorrowersService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("api/v1/borrowers")
class FindAllBorrowersControllers {

    private val service: FindAllBorrowersService

    constructor(service: FindAllBorrowersService) {
        this.service = service
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    fun findAll(): Flux<BorrowerResponseDto> {
        return service.findAll()
    }

}