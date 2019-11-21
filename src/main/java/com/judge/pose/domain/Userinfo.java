package com.judge.pose.domain;

import java.util.Date;

public class Userinfo {
    private String avator;

    private Integer age;

    private Integer gender;

    private Date registerTime;

    private Integer userId;

    public Userinfo(String avator, Integer age, Integer gender, Date registerTime, Integer userId) {
        this.avator = avator;
        this.age = age;
        this.gender = gender;
        this.registerTime = registerTime;
        this.userId = userId;
    }

    public Userinfo() {
        super();
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator == null ? null : avator.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}