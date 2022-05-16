package com.example.foodhub.data.model;

import java.util.List;

public class HomeModel {
    List<Category> categories;
    List<Restaurant> restaurants;
    List<Meal> foods;

    public HomeModel(List<Category> categories, List<Restaurant> restaurants, List<Meal> meals) {
        this.categories = categories;
        this.restaurants = restaurants;
        this.foods = meals;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public List<Meal> getMeals() {
        return foods;
    }
}
