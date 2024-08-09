package com.api.v1.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.utils.BookFinderUtil;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import reactor.core.publisher.Mono;

@Service
class DeleteBookByIsbnServiceImpl implements DeleteBookByIsbnService {

    @Autowired
    private BookFinderUtil finder;

    @Autowired
    private BookRepository repository;

    @Override
    public Mono<Void> deleteByIsbn(@NotNull @Size(min=13, max=13) String isbn) {
        return finder.find(isbn).flatMap(
            b -> Mono.defer(() -> {
                return repository.delete(b);
        }));
    }
    
}
