package com.api.v1.book.services;

import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.helpers.BookResponseDto;
import com.api.v1.book.helpers.BookDtoResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
class FindAllBooksServiceImpl implements FindAllBooksService {

    @Autowired
    private BookRepository repository;

    @Override
    public Flux<BookResponseDto> findAll() {
        return repository.findAll().flatMap(b -> Flux.just(BookDtoResponseMapper.mapToDtoResponse(b)));
    }

}
