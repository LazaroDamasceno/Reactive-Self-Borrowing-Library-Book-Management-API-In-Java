package com.api.v1.book.builders;

import com.api.v1.book.domain.Book;
import com.api.v1.book.dtos.NewBookRequestDto;

import java.time.ZonedDateTime;
import java.util.UUID;

public class BookBuilder {

    private final UUID id = UUID.randomUUID();
    private String title;
    private String subtitle;
    private String isbn;
    private int publishingYear;
    private String author;
    private String field;
    private int numberOfPages;
    private int version;
    private final String addedAt = ZonedDateTime.now().toString();

    protected BookBuilder() {}

    public static BookBuilder create() {
        return new BookBuilder();
    }

    public BookBuilder fromDto(NewBookRequestDto dto) {
        this.title = dto.title();
        this.subtitle = dto.subtitle();
        this.isbn = dto.isbn();
        this.publishingYear = dto.publishingYear();
        this.author = dto.author();
        this.field = dto.field();
        this.numberOfPages = dto.numberOfPages();
        this.version = dto.version();
        return this;
    }

    public Book build() {
        return new Book(
                id,
                title,
                subtitle,
                isbn,
                publishingYear,
                author,
                field,
                numberOfPages,
                version,
                addedAt
        );
    }
    
}
