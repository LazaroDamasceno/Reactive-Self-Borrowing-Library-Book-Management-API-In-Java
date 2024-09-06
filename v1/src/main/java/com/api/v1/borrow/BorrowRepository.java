package com.api.v1.borrow;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BorrowRepository extends ReactiveCrudRepository<Borrow, ObjectId> {
}
