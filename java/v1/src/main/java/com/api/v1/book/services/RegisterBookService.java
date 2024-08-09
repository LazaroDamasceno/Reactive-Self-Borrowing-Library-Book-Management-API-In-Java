package com.api.v1.book.services;

import com.api.v1.book.dtos.BookRequestDto;
import com.api.v1.book.dtos.BookResponseDto;
import reactor.core.publisher.Mono;

public interface RegisterBookService {

    Mono<BookResponseDto> register(BookRequestDto request);

}
