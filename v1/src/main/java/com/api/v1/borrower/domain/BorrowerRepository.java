package com.api.v1.borrower.domain;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface BorrowerRepository extends ReactiveCrudRepository<Borrower, UUID> {

    Mono<Borrower> findBySsn(String ssn);
    
}
