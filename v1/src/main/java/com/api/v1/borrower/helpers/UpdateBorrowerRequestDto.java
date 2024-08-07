package com.api.v1.borrower.helpers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateBorrowerRequestDto(
        @NotBlank String firstName,
        String middleName,
        @NotBlank String lastName,
        @NotNull @Email String email,
        @NotBlank String address,
        @NotNull @Size(min=10, max=10) String phoneNumber,
        @NotNull @Size(min=1) String gender
) {
}
