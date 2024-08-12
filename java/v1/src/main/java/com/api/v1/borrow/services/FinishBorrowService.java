package com.api.v1.borrow.services;

import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrower.domain.Borrower;
import reactor.core.publisher.Mono;

public interface FinishBorrowService {

    Mono<Void> finish(Borrow borrow, Borrower borrower);

}
