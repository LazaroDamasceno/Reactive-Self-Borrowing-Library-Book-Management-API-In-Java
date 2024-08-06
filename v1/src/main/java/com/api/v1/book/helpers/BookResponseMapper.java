package com.api.v1.book.helpers;

import com.api.v1.book.domain.Book;

public interface BookResponseMapper {

    public static BookResponse map(Book book) {
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
