package com.api.v1.book.helpers;

import com.api.v1.book.domain.Book;

public class BookDtoResponseMapper {

    public static BookResponseDto mapToDtoResponse(Book book) {
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
