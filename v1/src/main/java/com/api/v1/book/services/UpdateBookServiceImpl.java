package com.api.v1.book.services;

import com.api.v1.book.domain.Book;
import com.api.v1.book.domain.BookRepository;
import com.api.v1.book.helpers.BookRequest;
import com.api.v1.book.helpers.FindBookByIsbn;
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
    private FindBookByIsbn findBookByIsbn;

    @Override
    public Mono<Book> update(@NotNull @Size(min=13, max=13) String isbn, @Valid BookRequest request) {
        Mono<Book> mono = findBookByIsbn.find(isbn);
        return mono.flatMap(b -> Mono.defer(() -> {
            b.update(request);
            return repository.save(b);
        }));
    }

}
