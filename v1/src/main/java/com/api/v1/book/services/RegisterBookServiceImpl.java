package com.api.v1.book.services;

import com.api.v1.book.builder.BookBuilder;
import com.api.v1.book.domain.Book;
import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.helpers.BookRequest;
import com.api.v1.book.helpers.BookResponse;
import com.api.v1.book.helpers.BookMonoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class RegisterBookServiceImpl implements RegisterBookService {

    @Autowired
    private BookRepository repository;

    @Override
    public Mono<BookResponse> register(@Valid BookRequest request) {
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
        return BookMonoMapper.mapFromMono(savedBook);
    }

}
