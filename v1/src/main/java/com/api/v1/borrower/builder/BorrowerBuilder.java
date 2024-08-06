package com.api.v1.borrower.builder;

import com.api.v1.borrower.domain.Borrower;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Component
public class BorrowerBuilder {

    private final UUID id = UUID.randomUUID();
    private String firstName;
    private String middleName;
    private String lastName;
    private String ssn;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;
    private final String createdAt = ZonedDateTime.now().toString();

    public BorrowerBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public BorrowerBuilder withMiddleName(String middleName) {
        this.middleName = Objects.requireNonNull(middleName);
        return this;
    }

    public BorrowerBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BorrowerBuilder withSsn(String ssn) {
        this.ssn = ssn;
        return this;
    }

    public BorrowerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public BorrowerBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public BorrowerBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public BorrowerBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Borrower build() {
        return new Borrower(
            this.id,
            this.firstName,
            this.middleName,
            this.lastName,
            this.ssn,
            this.email,
            this.address,
            this.phoneNumber, 
            this.gender,
            this.createdAt
        );
    }    

}
