package com.example.foodhub.data.model;

public class Meal {

    private int image;
    private double rate;
    private double price;
    private int rateNumber;
    private String name;
    private String restaurantName;

    public Meal(int image, double rate, double price, int rateNumber, String name, String restaurantName) {
        this.image = image;
        this.rate = rate;
        this.price = price;
        this.rateNumber = rateNumber;
        this.name = name;
        this.restaurantName = restaurantName;
    }

    public int getImage() {
        return image;
    }


    public double getRate() {
        return rate;
    }



    public double getPrice() {
        return price;
    }



    public int getRateNumber() {
        return rateNumber;
    }



    public String getName() {
        return name;
    }



    public String getRestaurantName() {
        return restaurantName;
    }


}
