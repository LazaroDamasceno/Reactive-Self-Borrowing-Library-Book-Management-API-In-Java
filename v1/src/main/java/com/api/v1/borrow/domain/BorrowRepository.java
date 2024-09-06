package com.api.v1.borrow.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.math.BigInteger;

public interface BorrowRepository extends ReactiveCrudRepository<Borrow, BigInteger> {
}
