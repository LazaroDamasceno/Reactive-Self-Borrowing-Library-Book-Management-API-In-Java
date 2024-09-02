package com.api.v1.borrower.domain;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "v1_borrowers")
public class Borrower {

    @Field
    private String firstName;

    @Field
    private String middleName;

    @Field
    private String lastName;

    @Field
    private LocalDate birthDate;

    @Field
    private String ssn;

    @Field
    private String email;

    @Field
    private String address;

    @Field
    private String phoneNumber;

    @Field
    private String gender;

    @Field
    private String createdAt;

    @Field
    private String archivedAt;

    public Borrower() {}

    public Borrower(
            String firstName,
            String middleName,
            String lastName,
            LocalDate birthDate,
            String ssn,
            String email,
            String address,
            String phoneNumber,
            String gender,
            String createdAt
    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.ssn = ssn;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.createdAt = createdAt;
    }

    public String getFullName() {
        if (middleName.isEmpty()) {
            return "%s %s".formatted(firstName, lastName);
        }
        return "%s %s %s".formatted(firstName, middleName, lastName);
    }

    public Borrower archive() {
        archivedAt = ZonedDateTime.now().toString();
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getArchivedAt() {
        return archivedAt;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

}
