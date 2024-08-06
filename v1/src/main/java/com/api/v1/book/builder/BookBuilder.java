package com.api.v1.book.builder;

import com.api.v1.book.domain.Book;
import com.api.v1.book.helpers.IsbnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Component
public final class BookBuilder {

    @Autowired
    private IsbnGenerator isbnGenerator;

    private final UUID id = UUID.randomUUID();
    private String title;
    private String subtitle;
    private final String isbn = isbnGenerator.generateIsbn();
    private String author;
    private String field;
    private int numberOfPages;
    private int version;
    private String description;
    private final String addedAt = ZonedDateTime.now().toString();

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

    public BookBuilder withDescription(String description) {
        this.description = Objects.requireNonNull(description);
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
                this.description,
                this.addedAt
        );
    }
    
}
