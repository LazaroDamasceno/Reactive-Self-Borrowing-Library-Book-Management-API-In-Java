package com.api.v1.book.helpers.dtos;

public record BookResponse(
        String fullTitle,
        String isbn,
        String author,
        String field,
        int numberOfPages,
        int version,
        String addedAt,
        String updatedAt
) {
}
