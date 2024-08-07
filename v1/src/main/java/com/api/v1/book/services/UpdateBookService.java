package com.api.v1.book.services;

import com.api.v1.book.domain.Book;
import com.api.v1.book.helpers.BookRequest;
import reactor.core.publisher.Mono;

public interface UpdateBookService {

    Mono<Book> update(String isbn, BookRequest request);

}
