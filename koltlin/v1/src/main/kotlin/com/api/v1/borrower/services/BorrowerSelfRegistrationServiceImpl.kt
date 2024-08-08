package com.api.v1.borrower.services

import com.api.v1.borrower.builder.BorrowerBuilder
import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.domain.BorrowerRepository
import com.api.v1.borrower.helpers.BorrowerResponseDto
import com.api.v1.borrower.helpers.BorrowerResponseMapper
import com.api.v1.borrower.helpers.NewBorrowerRequestDto
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class BorrowerSelfRegistrationServiceImpl: BorrowerSelfRegistrationService {

    @Autowired
    private lateinit var repository: BorrowerRepository

    override fun selfRegister(@Valid request: NewBorrowerRequestDto): Mono<BorrowerResponseDto> {
        val borrower: Borrower = BorrowerBuilder.fromDto(request).build();
        val savedBorrower: Mono<Borrower> = repository.save(borrower)
        return savedBorrower.flatMap { b -> Mono.just(BorrowerResponseMapper.map(b)) }
    }

}