package com.api.v1.book.services;

import com.api.v1.book.helpers.BookResponse;

import reactor.core.publisher.Flux;

public interface FindAllBooksService {
    
    Flux<BookResponse> findAll();

}
