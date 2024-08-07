package com.api.v1.book.services;

import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.helpers.BookResponse;
import com.api.v1.book.helpers.BookResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FindAllBooksServiceImpl implements FindAllBooksService {

    @Autowired
    private BookRepository repository;

    @Override
    public Flux<BookResponse> findAll() {
        return repository.findAll().flatMap(b -> Flux.just(BookResponseMapper.map(b)));
    }

}
