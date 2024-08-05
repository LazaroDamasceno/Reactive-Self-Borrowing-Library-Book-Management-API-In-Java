package com.api.v1.borrower.domain;

import java.util.UUID;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface BorrowerRepository extends ReactiveCrudRepository<Borrower, UUID> {
    
    @Query("{ 'ssn' : { $eq : ?0 } }")
    Mono<Borrower> getBySsn(String ssn);

}
