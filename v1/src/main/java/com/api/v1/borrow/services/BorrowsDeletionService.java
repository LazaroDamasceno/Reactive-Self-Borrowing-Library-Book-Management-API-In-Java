package com.api.v1.borrow.services;

import reactor.core.publisher.Mono;

public interface BorrowsDeletionService {

    Mono<Void> deleteAll();

}
