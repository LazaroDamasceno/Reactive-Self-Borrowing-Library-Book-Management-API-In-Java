package com.api.v1.book.builders;

import com.api.v1.book.domain.Book;
import com.api.v1.book.helpers.BookRequestDto;

import java.time.ZonedDateTime;
import java.util.UUID;

public class BookBuilder {

    private final UUID id = UUID.randomUUID();
    private String title;
    private String subtitle;
    private String isbn;
    private String author;
    private String field;
    private int numberOfPages;
    private int version;
    private final String addedAt = ZonedDateTime.now().toString();

    protected BookBuilder() {}

    public static BookBuilder fromDto(BookRequestDto dto) {
        BookBuilder builder = new BookBuilder();
        builder.title = dto.title();
        builder.subtitle = dto.subtitle();
        builder.isbn = dto.isbn();
        builder.author = dto.author();
        builder.field = dto.field();
        builder.numberOfPages = dto.numberOfPages();
        builder.version = dto.version();
        return builder;
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
