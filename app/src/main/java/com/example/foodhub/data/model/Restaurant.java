package com.example.foodhub.data.model;

public class Restaurant {
   private int image;
   private double rate;
   private int rateNumber;
   private String name;
   private String delivery;
   private String deliveryTime;

    public Restaurant(int image, double rate, int rateNumber, String name, String delivery, String deliveryTime) {
        this.image = image;
        this.rate = rate;
        this.rateNumber = rateNumber;
        this.name = name;
        this.delivery = delivery;
        this.deliveryTime = deliveryTime;
    }


    public int getImage() {
        return image;
    }

    public double getRate() {
        return rate;
    }

    public int getRateNumber() {
        return rateNumber;
    }

    public String getName() {
        return name;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

}
