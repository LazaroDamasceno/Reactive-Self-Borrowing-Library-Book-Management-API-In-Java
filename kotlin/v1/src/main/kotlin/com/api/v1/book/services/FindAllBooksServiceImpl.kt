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

}