package com.api.v1.borrower.services

import com.api.v1.borrower.domain.BorrowerRepository
import com.api.v1.borrower.helpers.BorrowerResponseDto
import com.api.v1.borrower.helpers.BorrowerResponseMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class FindAllBorrowersServiceImpl: FindAllBorrowersService {

    private val repository: BorrowerRepository

    constructor(repository: BorrowerRepository) {
        this.repository = repository
    }

    override fun findAll(): Flux<BorrowerResponseDto> {
        return repository
            .findAll()
            .flatMap { b -> Flux.just(BorrowerResponseMapper.map(b)) }
            .cache()
    }

}