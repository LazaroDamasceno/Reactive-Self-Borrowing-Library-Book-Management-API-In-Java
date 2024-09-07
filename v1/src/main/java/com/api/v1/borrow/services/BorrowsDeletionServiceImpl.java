package com.api.v1.borrow.services;

import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrow.exceptions.BorrowEntityNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class BorrowsDeletionServiceImpl implements BorrowsDeletionService {

    @Autowired
    private BorrowRepository repository;

    @Override
    public Mono<Void> deleteAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(new BorrowEntityNotExistsException());
                    return repository.deleteAll();
                });
    }

}
