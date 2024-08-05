package com.api.v1.borrower.domain;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "v1_borrowers")
public final class Borrower {
    
    @Id
    private UUID id;

    @Field
    private String firstName;

    @Field
    private String middleName;

    @Field
    private String lastName;

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
    private Boolean isActive;

    public Borrower() {}

    public Borrower(
            String firstName, 
            String middleName, 
            String lastName, 
            String ssn, 
            String email, 
            String address,
            String phoneNumber, 
            String gender
    ) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.createdAt = ZonedDateTime.now().toString();
        this.isActive = true;
    }

    public String getFullName() {
        if (middleName.isBlank()) {
            return "%s %s".formatted(firstName, lastName);
        }
        return "%s %s %s".formatted(firstName, middleName, lastName);
    }

    public void deactive() { 
        this.isActive = false;
    };

    public UUID getId() {
        return id;
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

    public String getSsn() {
        return ssn;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Boolean getAIsActive() {
        return isActive;
    }

}
