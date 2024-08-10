package com.api.v1.book.services

import com.api.v1.book.dtos.BetweenYearsDto
import com.api.v1.book.dtos.BookResponseDto
import reactor.core.publisher.Flux

interface FindAllBooksService {

    fun findAll(): Flux<BookResponseDto>
    fun findByAuthor(author: String): Flux<BookResponseDto>
    fun findByField(field: String): Flux<BookResponseDto>
    fun findByYear(year: Int): Flux<BookResponseDto>
    fun findBetweenYears(firstYear: Int, lastYear: Int): Flux<BookResponseDto>
    fun findByAuthorAndField(author: String, field: String): Flux<BookResponseDto>
    fun findByAuthorAndYear(author: String, year: Int): Flux<BookResponseDto>
    fun findByAuthorBetweenYears(author: String, dto: BetweenYearsDto): Flux<BookResponseDto>
    fun findByFieldAndYear(field: String, year: Int): Flux<BookResponseDto>
    fun findByAuthorAndYearAndField(author: String, field: String, year: Int): Flux<BookResponseDto>
    fun findByAuthorAndFieldBetweenYears(author:String, field:String, dto: BetweenYearsDto): Flux<BookResponseDto>

}