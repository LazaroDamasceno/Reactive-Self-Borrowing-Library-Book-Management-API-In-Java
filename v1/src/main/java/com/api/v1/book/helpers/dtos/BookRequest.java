package com.api.v1.book.helpers.dtos;

import jakarta.validation.constraints.NotBlank;

public record BookRequest(
        @NotBlank String title,
        String subtitle,
        @NotBlank String author,
        @NotBlank String field,
        @NotBlank int numberOfPages,
        @NotBlank int version
) {
}
