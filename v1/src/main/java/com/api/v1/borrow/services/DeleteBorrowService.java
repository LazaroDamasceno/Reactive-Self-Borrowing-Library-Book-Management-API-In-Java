package com.api.v1.borrow.services;

import reactor.core.publisher.Mono;

public interface DeleteBorrowService {
    
    Mono<Void> delete(String isbn, String ssn);

}
