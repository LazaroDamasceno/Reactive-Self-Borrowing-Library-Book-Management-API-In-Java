package com.api.v1.book.helpers

import com.api.v1.book.domain.Book
import com.api.v1.book.domain.BookRepository
import com.api.v1.book.exceptions.BookNotFoundException
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class BookFinderUtil {

    @Autowired
    private lateinit var repository: BookRepository

    fun find(@NotNull @Size(min=13, max=13) isbn: String): Mono<Book> {
        return repository
            .getByIsbn(isbn)
            .switchIfEmpty(Mono.error(BookNotFoundException()))
    }

}