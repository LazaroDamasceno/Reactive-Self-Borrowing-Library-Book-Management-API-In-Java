package com.api.v1.borrower.services;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.exceptions.BorrowerNotFoundException;
import com.api.v1.borrower.helpers.FindBorrowerBySsn;
import com.api.v1.borrower.helpers.UpdateBorrowerRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
class UpdateBorrowerServiceImpl implements UpdateBorrowerService {

    @Autowired
    private BorrowerRepository repository;

    @Autowired
    private FindBorrowerBySsn findBorrowerBySsn;

    @Override
    public Mono<Borrower> update(@NotNull @Size(min=9, max=9) String ssn, @Valid UpdateBorrowerRequest request) {
        return findBorrowerBySsn.find(ssn)
            .flatMap(b -> Mono.defer(() -> {
                b.update(request);
                return repository.save(b);
        }));
    }

}
