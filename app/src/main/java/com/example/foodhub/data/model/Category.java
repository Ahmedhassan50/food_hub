package com.example.foodhub.data.model;

public class Category {

   private int image;
    private String name;

    public Category(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

}
