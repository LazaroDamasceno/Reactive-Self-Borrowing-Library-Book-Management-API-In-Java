package com.api.v1.book.services;

import reactor.core.publisher.Mono;

public interface DeleteAllBooksService {

    Mono<Void> deleteAll();

}
