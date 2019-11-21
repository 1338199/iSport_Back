package com.judge.pose.domain;

public class ExercisesHasImage {
    private Integer exercisesId;

    private Integer imageId;

    private Integer index_;

    public ExercisesHasImage(Integer exercisesId, Integer imageId, Integer index) {
        this.exercisesId = exercisesId;
        this.imageId = imageId;
        this.index_ = index;
    }

    public ExercisesHasImage() {
        super();
    }

    public Integer getExercisesId() {
        return exercisesId;
    }

    public void setExercisesId(Integer exercisesId) {
        this.exercisesId = exercisesId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getIndex() {
        return index_;
    }

    public void setIndex(Integer index) {
        this.index_ = index;
    }
}