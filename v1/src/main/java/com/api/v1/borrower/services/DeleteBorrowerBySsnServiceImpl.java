package com.api.v1.borrower.services;

import com.api.v1.borrower.domain.BorrowerRepository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.exceptions.BorrowerNotFoundException;

import reactor.core.publisher.Mono;

@Service
class DeleteBorrowerBySsnServiceImpl implements DeleteBorrowerBySsnService {

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Mono<Void> deleteBySsn(@NotNull @Size(min=9, max=9) String ssn) {
        return repository
                .getBySsn(ssn)
                .switchIfEmpty(Mono.error(BorrowerNotFoundException::new))
                .flatMap(repository::delete);
    }


}
