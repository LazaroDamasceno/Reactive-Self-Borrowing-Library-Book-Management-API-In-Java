package com.api.v1.borrower.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrower.domain.BorrowerRepository;

import reactor.core.publisher.Mono;

@Service
class DeleteAllBorrowersServiceImpl implements DeleteAllBorrowersService {

    @Autowired
    private BorrowerRepository repository;

    @Override
    public Mono<Void> deleteAll() {
        
        return repository.deleteAll();
    }
    
}
