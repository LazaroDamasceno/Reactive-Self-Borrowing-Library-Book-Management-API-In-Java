package com.api.v1.borrow.services;

import com.api.v1.borrow.domain.Borrow;
import reactor.core.publisher.Mono;

public interface FinishBorrowService {

    Mono<Borrow> finish(String isbn, String ssn);

}
