package com.example.bookmanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private Long id;
    private String title;
    private String isbn;
    private Long authorId;
    private String description;
    private List<Long> reviewIds;

    public Book() {
        this.reviewIds = new ArrayList<>();
    }

    public Book(Long id, String title, String isbn, Long authorId, String description) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.authorId = authorId;
        this.description = description;
        this.reviewIds = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getReviewIds() {
        return reviewIds;
    }

    public void setReviewIds(List<Long> reviewIds) {
        this.reviewIds = reviewIds;
    }
}
