package com.api.v1.book.dtos;

public record BookResponseDto(
        String fullTitle,
        String isbn,
        String author,
        String field,
        int publishingYear,
        int numberOfPages,
        int version
) {
}
