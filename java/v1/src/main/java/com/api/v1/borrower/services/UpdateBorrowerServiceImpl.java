package com.api.v1.borrower.services;

import com.api.v1.annotations.SSN;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.utils.BorrowerFinderUtil;
import com.api.v1.borrower.dtos.UpdateBorrowerRequestDto;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
class UpdateBorrowerServiceImpl implements UpdateBorrowerService {

    @Autowired
    private BorrowerRepository repository;

    @Autowired
    private BorrowerFinderUtil finder;

    @Override
    public Mono<Borrower> update(@SSN String ssn, @Valid UpdateBorrowerRequestDto request) {
        return finder.find(ssn)
            .flatMap(b -> Mono.defer(() -> {
                b.update(request);
                return repository.save(b);
        }));
    }

}
