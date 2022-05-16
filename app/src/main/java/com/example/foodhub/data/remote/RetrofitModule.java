package com.example.foodhub.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModule {
    public static final String BASE_URL="https://direct-app.net/food/";
    public static FoodHupServices foodHubApiService() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(FoodHupServices.class);
    }
}
