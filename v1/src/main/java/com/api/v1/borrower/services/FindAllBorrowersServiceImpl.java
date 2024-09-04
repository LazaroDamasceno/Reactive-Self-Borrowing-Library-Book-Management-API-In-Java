package com.api.v1.borrower.services;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.exceptions.EmptyFluxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.domain.BorrowerRepository;
import com.api.v1.borrower.mappers.BorrowerResponseMapper;
import com.api.v1.borrower.dtos.BorrowerResponseDto;

import reactor.core.publisher.Flux;

@Service
class FindAllBorrowersServiceImpl implements FindAllBorrowersService {

    @Autowired
    private BorrowerRepository repository;

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