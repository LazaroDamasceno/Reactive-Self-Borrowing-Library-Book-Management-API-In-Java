package com.api.v1.borrow.services;

import reactor.core.publisher.Mono;

public interface BorrowDeletionByIdService {

    Mono<Void> deleteById(String id);

}
