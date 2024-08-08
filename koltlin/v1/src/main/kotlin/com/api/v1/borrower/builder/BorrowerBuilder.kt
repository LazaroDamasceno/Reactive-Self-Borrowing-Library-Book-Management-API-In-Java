package com.api.v1.borrower.builder

import com.api.v1.borrower.domain.Borrower
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*

class BorrowerBuilder {
    private val id: UUID = UUID.randomUUID()
    private var firstName: String = ""
    private var middleName: String = ""
    private var lastName: String = ""
    private var ssn: String = ""
    private lateinit var birthDate: LocalDate
    private var email: String = ""
    private var address: String = ""
    private var gender: String = ""
    private var phoneNumber: String = ""
    private val createdAt: String = ZonedDateTime.now().toString()

    companion object {
        fun create(): BorrowerBuilder {
            return BorrowerBuilder()
        }
    }

    fun withFirstName(firstName: String): BorrowerBuilder {
        this.firstName = firstName
        return this
    }

    fun withMiddleName(middleName: String): BorrowerBuilder {
        this.middleName = middleName
        return this
    }

    fun withLastName(lastName: String): BorrowerBuilder {
        this.lastName = lastName
        return this
    }

    fun withSsn(ssn: String): BorrowerBuilder {
        this.ssn = ssn
        return this
    }

    fun withBirthDate(birthDate: LocalDate): BorrowerBuilder {
        this.birthDate = birthDate
        return this
    }

    fun withEmail(email: String): BorrowerBuilder {
        this.email = email
        return this
    }

    fun withAddress(address: String): BorrowerBuilder {
        this.address = address
        return this
    }

    fun withGender(gender: String): BorrowerBuilder {
        this.gender = gender
        return this
    }

    fun withPhoneNumber(phoneNumber: String): BorrowerBuilder {
        this.phoneNumber = phoneNumber
        return this
    }

    fun build(): Borrower {
        return Borrower(
            id,
            firstName,
            middleName,
            lastName,
            ssn,
            birthDate,
            email,
            address,
            gender,
            phoneNumber,
            createdAt
        )
    }

}
