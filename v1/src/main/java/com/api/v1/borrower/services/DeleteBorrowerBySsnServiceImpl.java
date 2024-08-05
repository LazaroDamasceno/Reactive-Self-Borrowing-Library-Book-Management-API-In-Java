package com.api.v1.borrower.services;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.helpers.retrievers.FindBorrowerBySsn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteBorrowerBySsnServiceImpl implements DeleteBorrowerBySsnService {

    @Autowired
    private FindBorrowerBySsn findBorrowerBySsn;

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Mono<Void> deleteBySsn(@NotNull @Size(min=9, max=9) String ssn) {
        Mono<Borrower> mono = findBorrowerBySsn.findBySsn(ssn);
        return mono.flatMap(b -> repository.delete(b));
    }

}
