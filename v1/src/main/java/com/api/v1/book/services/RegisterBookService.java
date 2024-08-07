package com.api.v1.book.services;

import com.api.v1.book.helpers.BookRequestDto;
import com.api.v1.book.helpers.BookResponseDto;
import reactor.core.publisher.Mono;

public interface RegisterBookService {

    Mono<BookResponseDto> register(BookRequestDto request);

}
