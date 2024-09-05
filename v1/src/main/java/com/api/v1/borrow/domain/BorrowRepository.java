package com.api.v1.borrow.domain;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BorrowRepository extends ReactiveCrudRepository<Borrow, ObjectId> {

}
