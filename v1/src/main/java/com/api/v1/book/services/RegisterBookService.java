package com.api.v1.book.services;

import com.api.v1.book.helpers.dtos.BookRequest;
import com.api.v1.book.helpers.dtos.BookResponse;
import reactor.core.publisher.Mono;

public interface RegisterBookService {

    Mono<BookResponse> register(BookRequest request);

}
