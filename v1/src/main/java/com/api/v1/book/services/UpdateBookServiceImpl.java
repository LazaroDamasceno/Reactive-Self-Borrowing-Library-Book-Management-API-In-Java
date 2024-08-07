package com.api.v1.book.services;

import com.api.v1.book.domain.Book;
import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.helpers.BookRequestDto;
import com.api.v1.book.helpers.IsbnBookFinderUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class UpdateBookServiceImpl implements UpdateBookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private IsbnBookFinderUtil finder;

    @Override
    public Mono<Book> update(@NotNull @Size(min=13, max=13) String isbn, @Valid BookRequestDto request) {
        Mono<Book> mono = finder.find(isbn);
        return mono.flatMap(b -> Mono.defer(() -> {
            b.update(request);
            return repository.save(b);
        }));
    }

}
