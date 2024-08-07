package com.api.v1.book.services;

import reactor.core.publisher.Mono;

public interface DeleteBookByIsbnService {

    Mono<Void> deleteByIsbn(String isbn);

}
