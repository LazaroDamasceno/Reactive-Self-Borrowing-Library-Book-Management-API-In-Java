package com.api.v1.borrow.services;

import reactor.core.publisher.Mono;

public interface ExtendBorrowService {

    Mono<Void> extend(String isbn, String ssn);

}
