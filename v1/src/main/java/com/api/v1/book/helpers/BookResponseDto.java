package com.api.v1.book.helpers;

public record BookResponseDto(
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
