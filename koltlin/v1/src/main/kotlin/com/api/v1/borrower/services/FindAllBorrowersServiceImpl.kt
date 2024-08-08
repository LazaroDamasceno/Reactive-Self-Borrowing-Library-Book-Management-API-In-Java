package com.api.v1.borrower.services

import com.api.v1.borrower.domain.BorrowerRepository
import com.api.v1.borrower.helpers.BorrowerResponseDto
import com.api.v1.borrower.helpers.BorrowerResponseMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class FindAllBorrowersServiceImpl: FindAllBorrowersService {

    @Autowired
    private lateinit var repository: BorrowerRepository

    override fun findAll(): Flux<BorrowerResponseDto> {
        return repository
            .findAll()
            .flatMap { b -> Flux.just(BorrowerResponseMapper.map(b)) }
            .cache()
    }

}