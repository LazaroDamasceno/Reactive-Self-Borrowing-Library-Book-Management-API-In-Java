package com.api.v1.book.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

import java.util.UUID;

@Document(collection = "v1_books")
class Book {

    @Id
    val id: UUID

    @Field
    var title: String

    @Field
    var subtitle: String

    @Field
    var isbn: String

    @Field
    var publisher: String

    @Field
    var version: Int

    @Field
    var numberOfPages: Int

    @Field
    var author: String

    @Field
    var field: String

    @Field
    val addedAt: String

    @Field
    val updatedAt: String = ""

    constructor(
        id: UUID,
        title: String,
        subtitle: String,
        isbn: String,
        publisher: String,
        version: Int,
        numberOfPages: Int,
        author: String,
        field: String,
        addedAt: String
    ) {
        this.id = id
        this.title = title
        this.subtitle = subtitle
        this.isbn = isbn
        this.publisher = publisher
        this.version = version
        this.numberOfPages = numberOfPages
        this.author = author
        this.field = field
        this.addedAt = addedAt
    }

}