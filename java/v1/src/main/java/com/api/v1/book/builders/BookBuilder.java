package com.api.v1.book.builders;

import com.api.v1.book.domain.Book;
import com.api.v1.book.dtos.BookRequestDto;

import java.time.ZonedDateTime;
import java.util.UUID;

public class BookBuilder {

    private final UUID id = UUID.randomUUID();
    private final String title;
    private final String subtitle;
    private final String isbn;
    private final String author;
    private final String field;
    private final int numberOfPages;
    private final int version;
    private final String addedAt = ZonedDateTime.now().toString();

    private BookBuilder(BookRequestDto dto) {
        this.title = dto.title();
        this.subtitle = dto.subtitle();
        this.isbn = dto.isbn();
        this.author = dto.author();
        this.field = dto.field();
        this.numberOfPages = dto.numberOfPages();
        this.version = dto.version();
    }

    public static BookBuilder fromDto(BookRequestDto dto) {
        return new BookBuilder(dto);
    }
    
    public Book build() {
        return new Book(
                this.id,
                this.title,
                this.subtitle,
                this.isbn,
                this.author,
                this.field,
                this.numberOfPages,
                this.version,
                this.addedAt
        );
    }
    
}
