package com.api.v1.book.domain;

import com.api.v1.book.dtos.NewBookRequestDto;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.ZonedDateTime;

@Document(collection = "v1_books")
public class Book {

    @Id
    private ObjectId id = new ObjectId();

    @Field
    private String title;

    @Field
    private String subtitle;

    @Field
    private String isbn;

    @Field
    private int publishingYear;

    @Field
    private String author;

    @Field
    private String field;

    @Field
    private int numberOfPages;

    @Field
    private int version;

    @Field
    private String addedAt;

    @Field
    private String archivedAt;

    protected Book() {}

    public Book(
            String title,
            String subtitle,
            String isbn,
            int publishingYear,
            String author,
            String field,
            int numberOfPages,
            int version,
            String addedAt
    ) {
        this.title = title;
        this.subtitle = subtitle;
        this.isbn = isbn;
        this.publishingYear = publishingYear;
        this.author = author;
        this.field = field;
        this.numberOfPages = numberOfPages;
        this.version = version;
        this.addedAt = addedAt;
    }

    public Book update(NewBookRequestDto request) {
        this.id = new ObjectId();
        this.title = request.title();
        this.subtitle = request.subtitle();
        this.publishingYear = request.publishingYear();
        this.author = request.author();
        this.field = request.field();
        this.numberOfPages = request.numberOfPages();
        this.version = request.version();
        this.archivedAt = null;
        return this;
    }

    public String getFullTitle() {
        if (subtitle.isEmpty()) return title;
        return "%s: %s".formatted(title, subtitle);
    }

    public void inactive() {
        this.archivedAt = ZonedDateTime.now().toString();
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

    public String getAuthor() {
        return author;
    }

    public String getField() {
        return field;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getVersion() {
        return version;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public String getArchivedAt() {
        return archivedAt;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public ObjectId getId() {
        return id;
    }

}
