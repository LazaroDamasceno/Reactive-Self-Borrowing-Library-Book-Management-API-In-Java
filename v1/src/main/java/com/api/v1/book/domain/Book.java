package com.api.v1.book.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    private String author;

    @Field
    private String field;

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

    public Book() {}

    public Book(
            String title,
            String subtitle,
            String isbn,
            String author,
            String field,
            int numberOfPages,
            int version,
            String description
    ) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.subtitle = subtitle;
        this.isbn = isbn;
        this.author = author;
        this.field = field;
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

    public String getAuthors() {
        return author;
    }

    public String getFields() {
        return field;
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
