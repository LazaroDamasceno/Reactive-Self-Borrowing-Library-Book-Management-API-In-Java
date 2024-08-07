package com.api.v1.book.builder;

import com.api.v1.book.domain.Book;
import com.api.v1.book.helpers.IsbnGeneratorUtil;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

public class BookBuilder {

    private final UUID id = UUID.randomUUID();
    private String title;
    private String subtitle;
    private final String isbn = IsbnGeneratorUtil.generateIsbn();
    private String author;
    private String field;
    private int numberOfPages;
    private int version;
    private final String addedAt = ZonedDateTime.now().toString();

    protected BookBuilder() {}

    public static BookBuilder create() {
        return new BookBuilder();
    }

    public BookBuilder withTitle(String title) {
        this.title = Objects.requireNonNull(title);
        return this;
    }

    public BookBuilder withSubtitle(String subtitle) {
        this.subtitle = Objects.requireNonNull(subtitle);
        return this;
    }

    public BookBuilder withAuthor(String author) {
        this.author = Objects.requireNonNull(author);
        return this;
    }

    public BookBuilder withField(String field) {
        this.field = Objects.requireNonNull(field);
        return this;
    }

    public BookBuilder withNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    public BookBuilder withVersion(int version) {
        this.version = version;
        return this;
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
