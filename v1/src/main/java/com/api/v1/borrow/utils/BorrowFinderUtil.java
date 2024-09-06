package com.api.v1.borrow.utils;

import com.api.v1.borrow.domain.Borrow;
import com.api.v1.borrow.domain.BorrowRepository;
import com.api.v1.borrow.exceptions.BorrowNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Component
public class BorrowFinderUtil {

    @Autowired
    private BorrowRepository borrowRepository;

    public Mono<Borrow> find(String id) {
        return borrowRepository
                .findAll()
                .filter(e -> e.getReturningDate() == null
                    && e.getId().equals(new BigInteger(id))
                )
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new BorrowNotFoundException(new BigInteger(id))));
    }

}
