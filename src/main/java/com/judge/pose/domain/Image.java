package com.judge.pose.domain;

public class Image {
    private Integer id;

    private String address;

    private String description;

    public Image(Integer id, String address, String description) {
        this.id = id;
        this.address = address;
        this.description = description;
    }

    public Image() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}