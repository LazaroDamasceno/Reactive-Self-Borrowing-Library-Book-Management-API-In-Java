package com.api.v1.book.helpers.mappers;

import com.api.v1.book.domain.Book;
import com.api.v1.book.helpers.dtos.BookResponse;
import org.springframework.stereotype.Component;

@Component
public final class BookResponseMapper {

    public BookResponse map(Book book) {
        return new BookResponse(
                book.getFullTitle(),
                book.getIsbn(),
                book.getAuthor(),
                book.getField(),
                book.getNumberOfPages(),
                book.getVersion(),
                book.getAddedAt(),
                book.getUpdatedAt()
        );
    }

}
