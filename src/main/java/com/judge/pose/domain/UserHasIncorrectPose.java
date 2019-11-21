package com.judge.pose.domain;

public class UserHasIncorrectPose {
    private Integer userId;

    private Integer incorrectPoseId;

    private Integer times;

    public UserHasIncorrectPose(Integer userId, Integer incorrectPoseId, Integer times) {
        this.userId = userId;
        this.incorrectPoseId = incorrectPoseId;
        this.times = times;
    }

    public UserHasIncorrectPose() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIncorrectPoseId() {
        return incorrectPoseId;
    }

    public void setIncorrectPoseId(Integer incorrectPoseId) {
        this.incorrectPoseId = incorrectPoseId;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}