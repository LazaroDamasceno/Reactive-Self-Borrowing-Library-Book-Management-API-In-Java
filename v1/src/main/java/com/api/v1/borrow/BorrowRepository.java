package com.api.v1.borrow;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.math.BigInteger;

public interface BorrowRepository extends ReactiveCrudRepository<Borrow, BigInteger> {
}
