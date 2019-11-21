package com.judge.pose.domain;

public class UserPassedImage {
    private Integer userId;

    private Integer imageId;

    private Double score;

    public UserPassedImage(Integer userId, Integer imageId, Double score) {
        this.userId = userId;
        this.imageId = imageId;
        this.score = score;
    }

    public UserPassedImage() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}