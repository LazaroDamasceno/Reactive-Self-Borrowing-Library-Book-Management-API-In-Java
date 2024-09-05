package com.api.v1.book.services;

import com.api.v1.book.domain.Book;
import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.dtos.BookResponseDto;
import com.api.v1.book.dtos.NewBookRequestDto;
import com.api.v1.book.mappers.BookDtoResponseMapper;
import com.api.v1.book.utils.BookFinderUtil;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
class UpdateBookServiceImpl implements UpdateBookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookFinderUtil finder;

    @Override
    public Mono<BookResponseDto> update(@Valid NewBookRequestDto request) {
        return finder
                .find(request.isbn())
                .flatMap(existingBook -> {
                    existingBook.update(request);
                    return repository.save(existingBook);
                })
                .flatMap(updateBook -> Mono.just(BookDtoResponseMapper.map(updateBook)));
    }

}
