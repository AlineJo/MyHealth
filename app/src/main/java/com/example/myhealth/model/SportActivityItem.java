package com.example.myhealth.model;

public class SportActivityItem {

    private String title;
    private String description;
    private int img;

    public SportActivityItem(String title, String description, int img) {
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImg() {
        return img;
    }
}
