package com.api.v1.borrower.services;

import com.api.v1.annotations.SSN;
import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.utils.BorrowerFinderUtil;
import com.api.v1.exceptions.EmptyFluxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.mappers.BorrowerResponseMapper;
import com.api.v1.borrower.dtos.BorrowerResponseDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

    @Autowired
    private BorrowerRepository repository;

    @Autowired
    private BorrowerFinderUtil borrowerFinderUtil;

    @Override
    public Mono<BorrowerResponseDto> findBySsn(@SSN String ssn) {
        return borrowerFinderUtil
                .find(ssn)
                .flatMap(b -> Mono.just(BorrowerResponseMapper.map(b)));
    }

    @Override
    public Flux<BorrowerResponseDto> findAll() {
        return repository
                .findAll().hasElements().flatMapMany(exists -> {
                    if (!exists) return Flux.error(new EmptyFluxException());
                    return allBorrowers().flatMap(b -> Flux.just(BorrowerResponseMapper.map(b)));
                });

    }

    private Flux<Borrower> allBorrowers() {
        return repository.findAll();
    }
    
}