package com.api.v1.borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Component
public class BorrowFinderUtil {

    @Autowired
    private BorrowRepository borrowRepository;

    public Mono<Borrow> find(String id) {
        BigInteger biId = new BigInteger(id);
        return borrowRepository
                .findAll()
                .filter(e -> e.getReturningDate() == null)
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new BorrowNotFoundException(biId)));
    }

}
