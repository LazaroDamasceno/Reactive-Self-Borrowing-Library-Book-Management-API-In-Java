package com.api.v1.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.v1.annotations.ISBN;
import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.utils.BookFinderUtil;

import reactor.core.publisher.Mono;

@Service
class DeleteBookByIsbnServiceImpl implements DeleteBookByIsbnService {

    @Autowired
    private BookFinderUtil finder;

    @Autowired
    private BookRepository repository;

    @Override
    public Mono<Void> deleteByIsbn(@ISBN String isbn) {
        return finder.find(isbn).flatMap(b -> repository.delete(b));
    }
    
}
