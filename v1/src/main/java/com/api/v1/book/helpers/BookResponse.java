package com.api.v1.book.helpers;

import jakarta.validation.constraints.NotBlank;

public record BookResponse(
        String title,
        String subtitle,
        String author,
        String field,
        int numberOfPages,
        int version,
        String description
) {
}
