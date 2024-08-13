package com.api.v1.borrow.domain;

import com.api.v1.book.domain.Book;
import com.api.v1.borrower.domain.Borrower;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BorrowRepository extends ReactiveCrudRepository<Borrow, UUID> {

    @Query("""
            {
                'borrower': { $eq borrower },
                'book': { $eq book }
            }
    """)
    Mono<Borrow> get(Borrower borrower, Book book);

}
