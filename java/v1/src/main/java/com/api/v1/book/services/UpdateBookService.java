package com.api.v1.book.services;

import com.api.v1.book.domain.Book;
import com.api.v1.book.dtos.UpdateBookRequestDto;

import reactor.core.publisher.Mono;

public interface UpdateBookService {

    Mono<Book> update(String isbn, UpdateBookRequestDto request);

}
