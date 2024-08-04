package com.api.v1.borrower.services;

import reactor.core.publisher.Mono;

public interface DeleteAllBorrowersService {
    
    Mono<Void> deleteAll();

}
