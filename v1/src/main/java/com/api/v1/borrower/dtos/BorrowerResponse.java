package com.api.v1.borrower.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BorrowerResponse(
        @NotBlank String fullName,
        @NotNull @Size(min=9, max=9) String ssn,
        @NotNull @Email String email,
        @NotBlank String address,
        @NotNull @Size(min=10, max=10) String phoneNumber,
        @NotNull @Size(min=1) String gender,
        String createdAt,
        Boolean activeStatus
) {
}
