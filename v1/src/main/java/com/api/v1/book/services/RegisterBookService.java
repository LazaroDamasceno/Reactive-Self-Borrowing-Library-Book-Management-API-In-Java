package com.api.v1.book.services;

import com.api.v1.book.helpers.BookRequest;
import com.api.v1.book.helpers.BookResponse;
import reactor.core.publisher.Mono;

public interface RegisterBookService {

    Mono<BookResponse> register(BookRequest request);

}
