package com.api.v1.borrower.domain;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import reactor.core.publisher.Mono;

public interface BorrowerRepository extends ReactiveCrudRepository<Borrower, UUID> {

    Mono<Borrower> findBySsn(@NotNull @Size(min=9, max=9) String ssn);
    
}
