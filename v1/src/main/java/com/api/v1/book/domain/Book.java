package com.api.v1.book.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import reactor.core.publisher.Flux;

import java.time.ZonedDateTime;
import java.util.UUID;

@Document(collection = "v1_books")
public final class Book {

    @Id
    private UUID id;

    @Field
    private String title;

    @Field
    private String subtitle;

    @Field
    private String isbn;

    @Field
    private Flux<String> authors;

    @Field
    private Flux<String> fields;

    @Field
    private int numberOfPages;

    @Field
    private int version;

    @Field
    private String description;

    @Field
    private String addedAt;

    @Field
    private String updatedAt;

    public Book(
            String title,
            String subtitle,
            String isbn,
            Flux<String> authors,
            Flux<String> fields,
            int numberOfPages,
            int version,
            String description,
            String addedAt
    ) {
        this.title = title;
        this.subtitle = subtitle;
        this.isbn = isbn;
        this.authors = authors;
        this.fields = fields;
        this.numberOfPages = numberOfPages;
        this.version = version;
        this.description = description;
        this.addedAt = ZonedDateTime.now().toString();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public Flux<String> getAuthors() {
        return authors;
    }

    public Flux<String> getFields() {
        return fields;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

}
