package com.example.bookmanagement.model;

public class Review {
    private Long id;
    private Long bookId;
    private String reviewerName;
    private Integer rating;
    private String comment;

    public Review() {
    }

    public Review(Long id, Long bookId, String reviewerName, Integer rating, String comment) {
        this.id = id;
        this.bookId = bookId;
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
