package com.example.myhealth.model;

public class UserGuid {
    private String title;
    private int cloudShape;
    private int textColor;

    public UserGuid() {

    }

    public UserGuid(String title, int cloudShape, int textColor) {
        this.title = title;
        this.cloudShape = cloudShape;
        this.textColor = textColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCloudShape() {
        return cloudShape;
    }

    public void setCloudShape(int cloudShape) {
        this.cloudShape = cloudShape;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}
