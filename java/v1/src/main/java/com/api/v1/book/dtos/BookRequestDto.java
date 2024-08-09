package com.api.v1.book.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BookRequestDto(
        @NotBlank String title,
        String subtitle,
        @NotNull @Size(min=13, max=13) String isbn,
        @NotBlank String author,
        @NotBlank String field,
        @Min(1) int numberOfPages,
        @Min(1) int version
) {
}
