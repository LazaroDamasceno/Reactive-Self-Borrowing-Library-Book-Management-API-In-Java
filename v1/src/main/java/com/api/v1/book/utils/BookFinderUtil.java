package com.api.v1.book.utils;

import com.api.v1.annotations.ISBN;
import com.api.v1.book.domain.Book;
import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BookFinderUtil {

    @Autowired
    private BookRepository repository;

    public Mono<Book> find(@ISBN String isbn) {
        return repository
                .findAll()
                .filter(e -> e.getIsbn().equals(isbn))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(BookNotFoundException::new));
    }

}
