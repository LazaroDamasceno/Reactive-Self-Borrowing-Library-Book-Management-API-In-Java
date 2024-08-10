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


}