package com.example.foodhub.data.model;

import com.google.gson.annotations.SerializedName;

public class Meal {

    private String id;
    @SerializedName("resturant_id")
    private String restaurantId;
    private String name;
    @SerializedName("pic")
    private String image;
    private String price;
    private String description;
    @SerializedName("rating")
    private String rate;
    @SerializedName("number_of_ratings")
    private String rateNumber;

    public Meal(String id, String restaurantId, String name, String image, String price, String description, String rate, String rateNumber) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.rate = rate;
        this.rateNumber = rateNumber;
    }


    public String getId() {
        return id;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getRate() {
        return rate;
    }

    public String getRateNumber() {
        return rateNumber;
    }
}
