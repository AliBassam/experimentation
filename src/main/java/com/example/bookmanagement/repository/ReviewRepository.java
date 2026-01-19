package com.example.bookmanagement.repository;

import com.example.bookmanagement.model.Review;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReviewRepository {
    private final Map<Long, Review> reviews = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public Review save(Review review) {
        if (review.getId() == null) {
            review.setId(idCounter.getAndIncrement());
        }
        reviews.put(review.getId(), review);
        return review;
    }

    public Optional<Review> findById(Long id) {
        return Optional.ofNullable(reviews.get(id));
    }

    public List<Review> findAll() {
        return new ArrayList<>(reviews.values());
    }

    public List<Review> findByBookId(Long bookId) {
        return reviews.values().stream()
                .filter(review -> review.getBookId() != null && review.getBookId().equals(bookId))
                .toList();
    }

    public void deleteById(Long id) {
        reviews.remove(id);
    }

    public boolean existsById(Long id) {
        return reviews.containsKey(id);
    }
}
