package com.api.v1.borrower.services;

import com.api.v1.annotations.SSN;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.utils.BorrowerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class DeleteBorrowerBySsnServiceImpl implements DeleteBorrowerBySsnService {

    @Autowired
    private BorrowerFinderUtil borrowerFinderUtil;

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Mono<Void> deleteBySsn(@SSN String ssn) {
        return borrowerFinderUtil
                .find(ssn)
                .flatMap(borrower -> repository
                        .findAll()
                        .filter(e -> e.getSsn().equals(borrower.getSsn()))
                        .flatMap(repository::delete)
                        .then());
    }

}
