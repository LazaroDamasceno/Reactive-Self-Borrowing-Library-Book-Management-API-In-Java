package com.api.v1.book.helpers;

import com.api.v1.book.domain.Book;

import reactor.core.publisher.Mono;

public interface BookMonoMapper {

    static Mono<BookResponseDto> mapFromMono(Mono<Book> mono) {
        return mono.flatMap(b -> Mono.just(BookResponseMapper.map(b)));
    }

}
