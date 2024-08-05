package com.api.v1.borrower.services;

import com.api.v1.borrower.helpers.BorrowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.helpers.BorrowerResponse;

import reactor.core.publisher.Flux;

@Service
final class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Flux<BorrowerResponse> findAll() {
        Flux<Borrower> borrowers = repository.findAll();
        return BorrowerMapper.mapFromFlux(borrowers);
    }
    
}