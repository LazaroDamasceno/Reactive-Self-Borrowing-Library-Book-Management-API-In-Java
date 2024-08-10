package com.api.v1.book.services

import com.api.v1.book.domain.BookRepository
import com.api.v1.book.dtos.BetweenYearsDto
import com.api.v1.book.dtos.BookResponseDto
import com.api.v1.book.mappers.BookResponseMapper
import jakarta.validation.constraints.NotBlank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
internal class FindAllBooksServiceImpl: FindAllBooksService {

    @Autowired
    private lateinit var repository: BookRepository

    override fun findAll(): Flux<BookResponseDto> {
        return repository
            .findAll()
            .flatMap {
                b -> Flux.just(BookResponseMapper.map(b))
            }
    }

    override fun findByAuthor(@NotBlank author: String): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.author == author }
            .flatMap { b -> Flux.just(BookResponseMapper.map(b)) }
    }

    override fun findByField(@NotBlank field: String): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.field == field }
            .flatMap { b -> Flux.just(BookResponseMapper.map(b)) }
    }

    override fun findByYear(@NotBlank year: Int): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.publishingYear == year }
            .flatMap { b -> Flux.just(BookResponseMapper.map(b)) }
    }

    override fun findBetweenYears(firstYear: Int, lastYear: Int): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter {e ->
                        (
                            e.publishingYear.compareTo(firstYear) == 0
                                    ||
                            e.publishingYear.compareTo(firstYear) == 1
                        ) && (
                            e.publishingYear.compareTo(lastYear) == 0
                                    ||
                            e.publishingYear.compareTo(lastYear) == -1
                        ) && (
                            firstYear.compareTo(lastYear) == 0
                                    ||
                            firstYear.compareTo(lastYear) == -1
                        )
            }
            .flatMap { b -> Flux.just(BookResponseMapper.map(b)) }
    }

    override fun findByAuthorAndField(@NotBlank author: String, @NotBlank field: String): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.field == field && e.author == author }
            .flatMap { b -> Flux.just(BookResponseMapper.map(b)) }
    }

    override fun findByAuthorAndYear(@NotBlank author: String, year: Int): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.publishingYear == year && e.author == author }
            .flatMap { b -> Flux.just(BookResponseMapper.map(b)) }
    }

    override fun findByAuthorBetweenYears(author: String, dto: BetweenYearsDto): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e ->
                    e.author == author
                    &&  ((
                                e.publishingYear.compareTo(dto.firstYear) == 0
                                        ||
                                e.publishingYear.compareTo(dto.firstYear) == 1

                        ) && (
                                e.publishingYear.compareTo(dto.lastYear) == 0
                                        ||
                                e.publishingYear.compareTo(dto.lastYear) == -1
                        ) && (
                                dto.firstYear.compareTo(dto.lastYear) == 0
                                        ||
                                dto.firstYear.compareTo(dto.lastYear) == -1
            ))}
            .flatMap { b -> Flux.just(BookResponseMapper.map(b)) }
    }

    override fun findByFieldAndYear(@NotBlank field: String, year: Int): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.field == field && e.publishingYear == year }
            .flatMap { b -> Flux.just(BookResponseMapper.map(b)) }
    }

    override fun findByAuthorAndYearAndField(author: String, field: String, year: Int): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter {
                e -> e.author == author && e.field == field && e.publishingYear == year
            }
            .flatMap { b -> Flux.just(BookResponseMapper.map(b)) }
    }

    override fun findByAuthorAndFieldBetweenYears(
        author: String,
        field: String,
        dto: BetweenYearsDto
    ): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e ->
                        e.author == author
                        &&
                        e.field == field
                        &&  ((
                            e.publishingYear.compareTo(dto.firstYear) == 0
                                ||
                            e.publishingYear.compareTo(dto.firstYear) == 1
                        ) && (
                            e.publishingYear.compareTo(dto.lastYear) == 0
                                    ||
                            e.publishingYear.compareTo(dto.lastYear) == -1
                        ) && (
                            dto.firstYear.compareTo(dto.lastYear) == 0
                                ||
                            dto.firstYear.compareTo(dto.lastYear) == -1
                        ))}
            .flatMap { b -> Flux.just(BookResponseMapper.map(b)) }
    }

}