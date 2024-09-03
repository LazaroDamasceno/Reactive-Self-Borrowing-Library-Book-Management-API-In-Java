package com.api.v1.book.services;

import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.exceptions.BookEntityNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class DeleteAllBooksServiceImpl implements DeleteAllBooksService {

    @Autowired
    private BookRepository repository;

    @Override
    public Mono<Void> deleteAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (!exists) return Mono.error(BookEntityNotExistException::new);
                    return repository.deleteAll();
                });
    }

}
