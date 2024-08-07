package com.api.v1.book.helpers;

import com.api.v1.book.domain.Book;

public interface BookResponseMapper {

    public static BookResponseDto map(Book book) {
        return new BookResponseDto(
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
