package com.api.v1.borrower.builder

import com.api.v1.borrower.domain.Borrower
import com.api.v1.borrower.helpers.NewBorrowerRequestDto
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*

class BorrowerBuilder {
    private val id: UUID = UUID.randomUUID()
    private lateinit var firstName: String
    private lateinit var middleName: String
    private lateinit var lastName: String
    private lateinit var ssn: String
    private lateinit var birthDate: LocalDate
    private lateinit var email: String
    private lateinit var address: String
    private lateinit var gender: String
    private lateinit var phoneNumber: String
    private val createdAt: String = ZonedDateTime.now().toString()

    companion object {
        fun fromDto(dto: NewBorrowerRequestDto): BorrowerBuilder {
            val builder = BorrowerBuilder()
            builder.firstName = dto.firstName
            builder.middleName = dto.middleName
            builder.lastName = dto.lastName
            builder.ssn = dto.ssn
            builder.birthDate = dto.birthDate
            builder.email = dto.email
            builder.address = dto.address
            builder.gender = dto.gender
            builder.phoneNumber = dto.phoneNumber
            return builder
        }
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
