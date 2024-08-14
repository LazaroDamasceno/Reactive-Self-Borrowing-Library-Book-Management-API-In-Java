package com.api.v1.borrow.services

import com.api.v1.borrow.dtos.BorrowResponseDto
import reactor.core.publisher.Mono

interface BorrowBookService {

    fun borrow(isbn: String, ssn: String): Mono<BorrowResponseDto>

}