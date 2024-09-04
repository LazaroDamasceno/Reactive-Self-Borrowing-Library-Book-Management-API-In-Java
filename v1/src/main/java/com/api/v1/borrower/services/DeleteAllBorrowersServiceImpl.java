package com.api.v1.borrower.services;

import com.api.v1.exceptions.EmptyFluxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.domain.BorrowerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class DeleteAllBorrowersServiceImpl implements DeleteAllBorrowersService {

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Mono<Void> deleteAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(EmptyFluxException::new);
                    return repository.deleteAll();
                });
    }
    
}
