package com.api.v1.book.services;

import com.api.v1.book.builders.BookBuilder;
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
            .flatMap(book -> {
                Book archivedBook = book.archive();
                return repository.save(archivedBook)
                        .then(Mono.defer(() -> {
                            Book updatedBook = BookBuilder.create().fromDto(request).build();
                            return repository.save(updatedBook)
                                    .flatMap(b -> Mono.just(BookDtoResponseMapper.map(b)));
                        }));
            });
    }

}
