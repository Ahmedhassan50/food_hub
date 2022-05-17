package com.example.foodhub.data.model;

import com.google.gson.annotations.SerializedName;

public class Restaurant {

   private String id;
    private String name;
    @SerializedName("pic")
   private String image;
    private String delivery;
    @SerializedName("delivery_time")
    private String deliveryTime;
    private String tags;
    @SerializedName("rating")
    private String rate;
    @SerializedName("cover_photo")
    private String cover;
    @SerializedName("number_of_ratings")
    private String rateNumber;
    private String address;
    @SerializedName("lat")
    private String latitude;
    @SerializedName("lng")
    private String longitude;

public Restaurant(){

}
    public Restaurant(String id, String name, String image, String delivery, String deliveryTime, String tags, String rate, String cover, String rateNumber, String address, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.delivery = delivery;
        this.deliveryTime = deliveryTime;
        this.tags = tags;
        this.rate = rate;
        this.cover = cover;
        this.rateNumber = rateNumber;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getDelivery() {
        return delivery;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public String getTags() {
        return tags;
    }

    public String getRate() {
        return rate;
    }

    public String getCover() {
        return cover;
    }

    public String getRateNumber() {
        return rateNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
