package com.api.v1.borrower.domain;

import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BorrowerRepository extends ReactiveCrudRepository<Borrower, UUID> {

}
