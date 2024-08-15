package com.api.v1.borrow.services;

import com.api.v1.borrow.domain.Borrow;
import reactor.core.publisher.Mono;

public interface ExtendBorrowService {

    Mono<Borrow> extend(String isbn, String ssn);

}
