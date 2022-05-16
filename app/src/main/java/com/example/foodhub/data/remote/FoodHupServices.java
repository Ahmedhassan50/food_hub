package com.example.foodhub.data.remote;


import android.util.JsonReader;

import com.example.foodhub.data.model.HomeModel;
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.model.Restaurant;
import com.example.foodhub.data.model.RestaurantDetails;
import com.example.foodhub.data.model.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FoodHupServices {


    @FormUrlEncoded
    @POST("serv.php")
    Call<User> login(@Field("email") String email,
                     @Field("pass") String pass,
                     @Field("type") String type,
                     @Field("method") String method
    );

    @FormUrlEncoded
    @POST("serv.php")
    Call<HomeModel> home(@Field("method") String home);


    @FormUrlEncoded
    @POST("serv.php")
    Call<ResponseBody> signUp(@Field("method") String method,
                              @Field("type") String type,
                              @Field("email") String email,
                              @Field("pass") String pass,
                              @Field("name") String name,
                              @Field("mobile") String mobile);


    @FormUrlEncoded
    @POST("serv.php")
    Call<List<Meal>> categoryDetails(@Field("method") String method,
                                     @Field("cat_id") String id
                              );


    @FormUrlEncoded
    @POST("serv.php")
    Call<Meal> mealDetails(@Field("method") String method,
                                     @Field("food_id") String id
    );

    @FormUrlEncoded
    @POST("serv.php")
    Call<RestaurantDetails> restaurantDetails(@Field("method") String method,
                                        @Field("restaurant_id") String id
    );


    @FormUrlEncoded
    @POST("serv.php")
    Call<List<Meal>> searchMeal(@Field("method") String method,
                                              @Field("keyword") String keyword
    );


    @FormUrlEncoded
    @POST("serv.php")
    Call<List<Restaurant>> searchRestaurant(@Field("method") String method,
                                            @Field("keyword") String keyword
    );

}
