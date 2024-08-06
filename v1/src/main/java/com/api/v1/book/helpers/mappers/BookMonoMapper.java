package com.api.v1.book.helpers.mappers;

import com.api.v1.book.domain.Book;
import com.api.v1.book.helpers.dtos.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public final class BookMonoMapper {

    @Autowired
    private BookResponseMapper mapper;

    public Mono<BookResponse> mapFromMono(Mono<Book> mono) {
        return mono.flatMap(b -> Mono.just(mapper.map(b)));
    }

}
