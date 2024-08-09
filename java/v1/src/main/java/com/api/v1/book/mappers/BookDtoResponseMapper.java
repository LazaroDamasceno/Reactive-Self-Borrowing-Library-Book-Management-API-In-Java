package com.api.v1.book.mappers;

import com.api.v1.book.domain.Book;
import com.api.v1.book.dtos.BookResponseDto;

public class BookDtoResponseMapper {

    public static BookResponseDto map(Book book) {
        return new BookResponseDto(
                book.getFullTitle(),
                book.getIsbn(),
                book.getAuthor(),
                book.getField(),
                book.getPublishingYear(),
                book.getNumberOfPages(),
                book.getVersion(),
                book.getAddedAt(),
                book.getUpdatedAt()
        );
    }

}
