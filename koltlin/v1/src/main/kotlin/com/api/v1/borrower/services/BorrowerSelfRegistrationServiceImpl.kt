package com.api.v1.borrower.services

import com.api.v1.borrower.builder.BorrowerBuilder
import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.domain.BorrowerRepository
import com.api.v1.borrower.helpers.BorrowerResponseDto
import com.api.v1.borrower.helpers.BorrowerResponseMapper
import com.api.v1.borrower.helpers.NewBorrowerRequestDto
import jakarta.validation.Valid
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class BorrowerSelfRegistrationServiceImpl: BorrowerSelfRegistrationService {

    private val repository: BorrowerRepository ;

    constructor(repository: BorrowerRepository) {
        this.repository = repository
    }

    override fun selfRegister(@Valid request: NewBorrowerRequestDto): Mono<BorrowerResponseDto> {
        val borrower: Borrower = BorrowerBuilder
            .create()
            .withFirstName(request.firstName)
            .withMiddleName(request.middleName)
            .withLastName(request.lastName)
            .withSsn(request.ssn)
            .withBirthDate(request.birthDate)
            .withEmail(request.email)
            .withAddress(request.address)
            .withGender(request.gender)
            .withPhoneNumber(request.phoneNumber)
            .build();
        val savedBorrower: Mono<Borrower> = repository.save(borrower)
        return savedBorrower.flatMap { b -> Mono.just(BorrowerResponseMapper.map(b)) }
    }

}