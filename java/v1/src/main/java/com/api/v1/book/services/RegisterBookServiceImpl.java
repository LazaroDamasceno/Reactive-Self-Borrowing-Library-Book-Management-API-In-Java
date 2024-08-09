package com.api.v1.book.services;

import com.api.v1.book.builders.BookBuilder;
import com.api.v1.book.domain.Book;
import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.exceptions.DuplicatedIsbnException;
import com.api.v1.book.dtos.BookRequestDto;
import com.api.v1.book.dtos.BookResponseDto;
import com.api.v1.book.mappers.BookDtoResponseMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class RegisterBookServiceImpl implements RegisterBookService {

    @Autowired
    private BookRepository repository;

    @Override
    public Mono<BookResponseDto> register(@Valid BookRequestDto request) {
        return repository
                .getByIsbn(request.isbn())
                .hasElement()
                .flatMap(exists -> {
                    if (exists) return duplicatedSsnError();
                    else return defer(request);
                });
    }

    private Mono<BookResponseDto> duplicatedSsnError() {
        String message = "Input ISBN is already used.";
        return Mono.error(new DuplicatedIsbnException(message));
    }

    private Mono<BookResponseDto> defer(BookRequestDto request) {
        return Mono.defer(() -> {
            Book book = BookBuilder.fromDto(request).build();
            Mono<Book> savedBook = repository.save(book);
            return savedBook.flatMap(b -> Mono.just(BookDtoResponseMapper.map(b)));
        });
    }

}
