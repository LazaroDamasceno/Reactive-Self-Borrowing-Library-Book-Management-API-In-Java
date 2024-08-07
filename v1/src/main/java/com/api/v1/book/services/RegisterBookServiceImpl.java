package com.api.v1.book.services;

import com.api.v1.book.builder.BookBuilder;
import com.api.v1.book.domain.Book;
import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.helpers.BookRequestDto;
import com.api.v1.book.helpers.BookResponseDto;
import com.api.v1.book.helpers.BookDtoResponseMapper;
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
        Book book = BookBuilder
                .create()
                .withTitle(request.title())
                .withSubtitle(request.subtitle())
                .withAuthor(request.author())
                .withField(request.field())
                .withNumberOfPages(request.numberOfPages())
                .withVersion(request.version())
                .build();
        Mono<Book> savedBook = repository.save(book);
        return savedBook.flatMap(b -> Mono.just(BookDtoResponseMapper.map(b)));
    }

}
