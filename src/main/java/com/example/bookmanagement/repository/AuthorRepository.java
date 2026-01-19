package com.example.bookmanagement.repository;

import com.example.bookmanagement.model.Author;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AuthorRepository {
    private final Map<Long, Author> authors = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public Author save(Author author) {
        if (author.getId() == null) {
            author.setId(idCounter.getAndIncrement());
        }
        authors.put(author.getId(), author);
        return author;
    }

    public Optional<Author> findById(Long id) {
        return Optional.ofNullable(authors.get(id));
    }

    public List<Author> findAll() {
        return new ArrayList<>(authors.values());
    }

    public void deleteById(Long id) {
        authors.remove(id);
    }

    public boolean existsById(Long id) {
        return authors.containsKey(id);
    }
}
