package com.api.v1.book.services;

import com.api.v1.book.domain.Book;
import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.dtos.UpdateBookRequestDto;
import com.api.v1.book.utils.BookFinderUtil;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.annotations.ISBN;

import reactor.core.publisher.Mono;

@Service
class UpdateBookServiceImpl implements UpdateBookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookFinderUtil finder;

    @Override
    public Mono<Book> update(@ISBN String isbn, @Valid UpdateBookRequestDto request) {
        Mono<Book> mono = finder.find(isbn);
        return mono.flatMap(b -> Mono.defer(() -> {
            b.update(request);
            return repository.save(b);
        }));
    }

}
