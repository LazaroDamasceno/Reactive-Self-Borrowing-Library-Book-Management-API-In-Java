package com.api.v1.borrow.services;

import reactor.core.publisher.Mono;

public interface DeleteAllBorrowsService {

    Mono<Void> deleteAll();
    
}
