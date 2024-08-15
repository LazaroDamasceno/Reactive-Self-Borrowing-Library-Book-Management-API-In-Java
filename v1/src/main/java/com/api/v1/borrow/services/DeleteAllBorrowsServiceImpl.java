package com.api.v1.borrow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.borrow.domain.BorrowRepository;

import reactor.core.publisher.Mono;

@Service
class DeleteAllBorrowsServiceImpl implements DeleteAllBorrowsService {

    @Autowired
    private BorrowRepository repository;

    @Override
    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }
    
}
