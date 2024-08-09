package com.api.v1.book.controllers

import com.api.v1.book.dtos.BookResponseDto
import com.api.v1.book.services.FindAllBooksService
import jakarta.validation.constraints.NotBlank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
@RequestMapping("api/v1/books")
internal class FindAllBooksController {

    @Autowired
    private lateinit var service: FindAllBooksService

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    fun findAll(): Flux<BookResponseDto> {
        return service.findAll()
    }

    @GetMapping("by-author/{author}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findByAuthor(@PathVariable author: @NotBlank String): Flux<BookResponseDto> {
        return service.findByAuthor(author)
    }

    @GetMapping("by-field/{field}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findByField(@PathVariable field: @NotBlank String): Flux<BookResponseDto> {
        return service.findByField(field)
    }

    @GetMapping("by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findByYear(@PathVariable year: Int): Flux<BookResponseDto> {
        return service.findByYear(year)
    }

    @GetMapping("by-author/{author}/and/by-field/{field}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findByAuthorAndField(
        @PathVariable author: @NotBlank String,
        @PathVariable field: @NotBlank String
    ): Flux<BookResponseDto> {
        return service.findByAuthorAndField(author, field)
    }

    @GetMapping("by-author/{author}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findByAuthorAndYear(@PathVariable author: @NotBlank String, @PathVariable year: Int): Flux<BookResponseDto> {
        return service.findByAuthorAndYear(author, year)
    }

    @GetMapping("by-field/{field}/and/by-year/{year}")
    @ResponseStatus(value = HttpStatus.OK)
    fun findByFieldAndYear(
        @PathVariable field: @NotBlank String,
        @PathVariable year: Int
    ): Flux<BookResponseDto> {
        return service.findByFieldAndYear(field, year)
    }
}