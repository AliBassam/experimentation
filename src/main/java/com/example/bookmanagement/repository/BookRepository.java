package com.example.bookmanagement.repository;

import com.example.bookmanagement.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BookRepository {
    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(idCounter.getAndIncrement());
        }
        books.put(book.getId(), book);
        return book;
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public List<Book> findByAuthorId(Long authorId) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthorId() != null && book.getAuthorId().equals(authorId)) {
                result.add(book);
            }
        }
        return result;
    }

    public void deleteById(Long id) {
        books.remove(id);
    }

    public boolean existsById(Long id) {
        return books.containsKey(id);
    }
}
