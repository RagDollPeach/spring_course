package com.example.entity.book.review;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_review_like")
public class BookReviewLikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_id",columnDefinition = "INT NOT NULL")
    private Integer reviewId;

    @Column(name = "user_id",columnDefinition = "INT NOT NULL")
    private Integer userId;

    @Column(columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime time;

    @Column(columnDefinition = "SMALLINT NOT NULL")
    private short value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }
}
