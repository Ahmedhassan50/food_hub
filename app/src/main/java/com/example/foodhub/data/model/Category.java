package com.example.foodhub.data.model;

import com.google.gson.annotations.SerializedName;

public class Category {


    private String id;
    @SerializedName("cat_name")
    private String name;
    @SerializedName("cat_pic")
    private String image;

    public Category(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
