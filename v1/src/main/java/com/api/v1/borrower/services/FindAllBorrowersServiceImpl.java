package com.api.v1.borrower.services;

import com.api.v1.borrower.helpers.mappers.BorrowerFluxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.helpers.dtos.BorrowerResponse;

import reactor.core.publisher.Flux;

@Service
final class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

    @Autowired
    private BorrowerRepository repository;

    @Autowired
    private BorrowerFluxMapper mapper;

    @Override
    public Flux<BorrowerResponse> findAll() {
        Flux<Borrower> borrowers = repository.findAll();
        return mapper.mapFromFlux(borrowers);
    }
    
}