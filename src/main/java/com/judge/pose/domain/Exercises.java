package com.judge.pose.domain;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;
import java.util.Map;

public class Exercises {
    @Id
    private Integer id;

    private String description;

    private String title;

    private String type;

    private List<Image> images;

    public Exercises(Integer id, String description, String title, String type) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.type = type;
    }

    public Exercises() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Transient
    public List<Image> getImages() {
        return images;
    }
    @Transient
    public void setImages(List<Image> images) {
        this.images = images;
    }
}