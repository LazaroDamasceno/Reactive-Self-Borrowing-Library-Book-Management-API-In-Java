package com.api.v1.borrower.services

import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.domain.BorrowerRepository
import com.api.v1.borrower.helpers.BorrowerFinderUtil
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class DeleteBorrowerBySsnServiceImpl: DeleteBorrowerBySsnService {

    @Autowired
    private lateinit var repository: BorrowerRepository

    @Autowired
    private lateinit var finder: BorrowerFinderUtil

    override fun deleteBySsn(@NotNull @Size(min=9, max=9) ssn: String): Mono<Void> {
        return finder.find(ssn).flatMap { b -> Mono.defer { repository.delete(b) } }
    }

}