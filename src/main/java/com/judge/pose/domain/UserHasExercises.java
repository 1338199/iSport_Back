package com.judge.pose.domain;

public class UserHasExercises {
    private Integer userId;

    private Integer exercisesId;


    public UserHasExercises(Integer userId, Integer exercisesId) {
        this.userId = userId;
        this.exercisesId = exercisesId;
    }

    public UserHasExercises() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getExercisesId() {
        return exercisesId;
    }

    public void setExercisesId(Integer exercisesId) {
        this.exercisesId = exercisesId;
    }

}