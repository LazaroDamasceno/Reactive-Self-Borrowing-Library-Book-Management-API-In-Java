package com.api.v1.book.services;

import com.api.v1.book.helpers.BookResponseDto;

import reactor.core.publisher.Flux;

public interface FindAllBooksService {
    
    Flux<BookResponseDto> findAll();

}
