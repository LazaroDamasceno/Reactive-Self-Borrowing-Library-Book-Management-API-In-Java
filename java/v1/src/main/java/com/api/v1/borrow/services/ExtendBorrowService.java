package com.api.v1.borrow.services;

import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrower.domain.Borrower;
import reactor.core.publisher.Mono;

public interface ExtendBorrowService {

    Mono<Void> extend(Borrow borrow, Borrower borrower);

}
