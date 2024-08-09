package com.api.v1.borrower.builders;

import com.api.v1.borrower.domain.Borrower;
import com.api.v1.borrower.helpers.NewBorrowerRequestDto;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

public class BorrowerBuilder {

    private final UUID id = UUID.randomUUID();
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private String ssn;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;
    private final String createdAt = ZonedDateTime.now().toString();

    protected BorrowerBuilder() {}

    public static BorrowerBuilder fromDto(NewBorrowerRequestDto dto) {
        BorrowerBuilder builder = new BorrowerBuilder();
        builder.firstName = dto.firstName();
        builder.middleName = dto.middleName();
        builder.lastName = dto.lastName();
        builder.birthDate = dto.birthDate();
        builder.ssn = dto.ssn();
        builder.email = dto.email();
        builder.address = dto.address();
        builder.phoneNumber = dto.phoneNumber();
        builder.gender = dto.gender();
        return builder;
    } 

    public Borrower build() {
        return new Borrower(
            this.id,
            this.firstName,
            this.middleName,
            this.lastName,
            this.birthDate,
            this.ssn,
            this.email,
            this.address,
            this.phoneNumber, 
            this.gender,
            this.createdAt
        );
    }    

}
