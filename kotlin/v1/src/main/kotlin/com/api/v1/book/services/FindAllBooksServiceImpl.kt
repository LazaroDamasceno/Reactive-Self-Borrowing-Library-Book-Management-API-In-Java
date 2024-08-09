package com.api.v1.book.services

import com.api.v1.book.domain.BookRepository
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

    override fun findByFieldAndYear(@NotBlank field: String, year: Int): Flux<BookResponseDto> {
        return repository
            .findAll()
            .filter { e -> e.field == field && e.publishingYear == year }
            .flatMap { b -> Flux.just(BookResponseMapper.map(b)) }
    }

}