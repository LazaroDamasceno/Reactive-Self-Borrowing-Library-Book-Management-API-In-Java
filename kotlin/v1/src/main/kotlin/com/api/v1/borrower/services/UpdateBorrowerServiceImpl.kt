package com.api.v1.borrower.services

import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.domain.BorrowerRepository
import com.api.v1.borrower.utils.BorrowerFinderUtil
import com.api.v1.borrower.dtos.UpdateBorrowerRequestDto
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
internal class UpdateBorrowerServiceImpl: UpdateBorrowerService {

    @Autowired
    private lateinit var repository: BorrowerRepository

    @Autowired
    private lateinit var finder: BorrowerFinderUtil

    override fun update(
            @NotNull @Size(min=9, max=9) ssn: String,
            @Valid request: UpdateBorrowerRequestDto
    ): Mono<Borrower> {
        return finder
            .find(ssn)
            .flatMap {
                b -> Mono.defer {
                    b.update(request)
                    repository.save(b)
            }}
    }

}