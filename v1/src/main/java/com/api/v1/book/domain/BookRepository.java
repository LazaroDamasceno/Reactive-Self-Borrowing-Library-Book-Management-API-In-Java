package com.api.v1.book.domain;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BookRepository extends ReactiveCrudRepository<Book, UUID> {

    @Query("{ 'isbn' : { $eq : ?0 } }")
    Mono<Book> getByIsbn(String isbn);

}
