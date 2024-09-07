package com.api.v1.borrow.services;

import reactor.core.publisher.Mono;

public interface BorrowTerminationService {

    Mono<Void> terminate(String id);

}
