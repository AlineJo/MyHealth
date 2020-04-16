package com.example.myhealth.model;

import java.util.ArrayList;

public class FoodGroup {

    ArrayList<FoodSubGroup> foodSubGroups;
    // if images are loaded from db, change data type to String!
    private int image;
    private String title;
    private String cardColor;// this refers to card highlight color

    public FoodGroup() {
        foodSubGroups = new ArrayList<>();
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public ArrayList<FoodSubGroup> getFoodSubGroups() {
        return foodSubGroups;
    }

    public void setFoodSubGroups(ArrayList<FoodSubGroup> foodSubGroups) {
        this.foodSubGroups = foodSubGroups;
    }
}
