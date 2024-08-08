package com.api.v1.borrower.helpers;

import jakarta.validation.constraints.*;

public record NewBorrowerRequestDto(
    @NotBlank String firstName,
    String middleName,
    @NotBlank String lastName,
    @NotNull @Size(min=9, max=9) String ssn,
    @NotNull @Email String email,
    @NotBlank String address,
    @NotNull @Size(min=10, max=10) String phoneNumber,
    @NotNull @Size(min=1) String gender
) {
    
}
