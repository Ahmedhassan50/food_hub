package com.example.foodhub.data.model;

public class AddOn {
    int image;
    String name;
    double price;

    public AddOn(int image, String name, double price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


}
