package com.api.v1.book.helpers.mappers;

import com.api.v1.book.domain.Book;
import com.api.v1.book.helpers.dtos.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public final class BookFluxMapper {

    @Autowired
    private BookResponseMapper mapper;

    public Flux<BookResponse> mapFromFLux(Flux<Book> flux) {
        return flux.flatMap(b -> Flux.just(mapper.map(b)));
    }

}
