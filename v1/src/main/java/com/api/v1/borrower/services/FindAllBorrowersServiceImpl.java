package com.api.v1.borrower.services;

import com.api.v1.borrower.helpers.BorrowerFluxMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.helpers.BorrowerResponseDto;

import reactor.core.publisher.Flux;

@Service
class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

    @Autowired
    private BorrowerRepository repository;

    @Override
    @Cacheable(value = "borrowers")
    public Flux<BorrowerResponseDto> findAll() {
        Flux<Borrower> borrowers = repository.findAll();
        return BorrowerFluxMapperUtil.mapFromFlux(borrowers);
    }
    
}