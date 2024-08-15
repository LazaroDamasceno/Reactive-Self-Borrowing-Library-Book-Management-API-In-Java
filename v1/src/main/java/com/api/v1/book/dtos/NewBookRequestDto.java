package com.api.v1.book.dtos;

import com.api.v1.annotations.ISBN;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

public record NewBookRequestDto(
        @NotBlank String title,
        String subtitle,
        @ISBN String isbn,
        @NotBlank String author,
        int publishingYear,
        @NotBlank String field,
        @Min(1) int numberOfPages,
        @Min(1) int version
) {
}
