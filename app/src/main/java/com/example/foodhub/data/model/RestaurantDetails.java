package com.example.foodhub.data.model;

import java.util.List;

public class RestaurantDetails {
    private Restaurant restaurant;
    private List<Meal> items;


    public RestaurantDetails(Restaurant restaurant, List<Meal> meals) {
        this.restaurant = restaurant;
        this.items = meals;
    }


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<Meal> getMeals() {
        return items;
    }
}
