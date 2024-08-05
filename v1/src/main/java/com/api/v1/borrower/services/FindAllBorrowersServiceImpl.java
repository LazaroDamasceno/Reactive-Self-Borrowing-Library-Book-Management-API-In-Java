package com.api.v1.borrower.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.helpers.dtos.BorrowerResponse;
import com.api.v1.borrower.helpers.mappers.FluxMapper;

import reactor.core.publisher.Flux;

@Service
final class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

    @Autowired
    private BorrowerRepository repository;

    @Autowired
    private FluxMapper mapper;

    @Override
    public Flux<BorrowerResponse> findAll() {
        Flux<Borrower> borrowers = repository.findAll();
        return mapper.mapFromFlux(borrowers);
    }
    
}