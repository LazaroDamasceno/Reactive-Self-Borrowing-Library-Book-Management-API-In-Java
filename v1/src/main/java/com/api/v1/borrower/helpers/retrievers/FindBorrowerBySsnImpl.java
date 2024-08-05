package com.api.v1.borrower.helpers.retrievers;

import com.api.v1.borrower.exceptions.BorrowerNotFoundException;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
final class FindBorrowerBySsnImpl implements FindBorrowerBySsn {

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Mono<Borrower> findBySsn(@NotNull @Size(min=9, max=9) String ssn) {
        return repository
                .getBySsn(ssn)
                .switchIfEmpty(Mono.error(new BorrowerNotFoundException()));
    }

}
