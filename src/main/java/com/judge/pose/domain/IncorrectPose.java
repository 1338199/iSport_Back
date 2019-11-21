package com.judge.pose.domain;

public class IncorrectPose {
    private Integer id;

    private String position;

    public IncorrectPose(Integer id, String position) {
        this.id = id;
        this.position = position;
    }

    public IncorrectPose() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }
}