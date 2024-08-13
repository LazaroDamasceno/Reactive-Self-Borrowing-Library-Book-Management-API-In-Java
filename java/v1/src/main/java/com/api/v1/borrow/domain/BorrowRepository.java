package com.api.v1.borrow.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface BorrowRepository extends ReactiveCrudRepository<Borrow, UUID> {}
