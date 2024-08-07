package com.api.v1.book.helpers;

import com.api.v1.book.domain.Book;
import reactor.core.publisher.Flux;

public interface  BookFluxMapper {

    static Flux<BookResponseDto> mapFromFLux(Flux<Book> flux) {
        return flux.flatMap(b -> Flux.just(BookResponseMapper.map(b)));
    }

}
