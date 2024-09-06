package com.api.v1.book.services;

import com.api.v1.book.builders.BookBuilder;
import com.api.v1.book.domain.Book;
import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.exceptions.DuplicatedIsbnException;
import com.api.v1.book.dtos.NewBookRequestDto;
import com.api.v1.book.dtos.BookResponseDto;
import com.api.v1.book.mappers.BookResponseMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class RegisterBookServiceImpl implements RegisterBookService {

    @Autowired
    private BookRepository repository;

    @Override
    public Mono<BookResponseDto> register(@Valid NewBookRequestDto request) {
        return repository
                .findAll()
                .filter(e -> e.getIsbn().equals(request.isbn()))
                .hasElements()
                .flatMap(exists -> {
                    if (exists) return handleDuplicatedIsbn();
                    else return handleRegistration(request);
                });
    }

    private Mono<BookResponseDto> handleDuplicatedIsbn() {
        String message = "Input ISBN is already used.";
        return Mono.error(new DuplicatedIsbnException(message));
    }

    private Mono<BookResponseDto> handleRegistration(NewBookRequestDto request) {
        return Mono.defer(() -> {
            Book book = BookBuilder.create().fromDto(request).build();
            Mono<Book> savedBook = repository.save(book);
            return savedBook.flatMap(b -> Mono.just(BookResponseMapper.map(b)));
        });
    }

}
