package com.api.v1.book.services;

import com.api.v1.book.dtos.BookResponseDto;

import reactor.core.publisher.Flux;

public interface FindAllBooksService {
    
    Flux<BookResponseDto> findAll();

    Flux<BookResponseDto> findByAuthor(String author);

    Flux<BookResponseDto> findByField(String field);

    Flux<BookResponseDto> findByYear(int year);

    Flux<BookResponseDto> findByAuthorAndField(String author, String field);

    Flux<BookResponseDto> findByAuthorAndYear(String author, int year);

    Flux<BookResponseDto> findByFieldAndYear(String field, int year);

}
