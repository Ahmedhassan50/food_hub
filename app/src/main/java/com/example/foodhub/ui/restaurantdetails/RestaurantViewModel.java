package com.example.foodhub.ui.restaurantdetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.model.RestaurantDetails;
import com.example.foodhub.data.remote.RetrofitModule;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantViewModel  extends ViewModel {

    public MutableLiveData<RestaurantDetails> restaurantDetails=new MutableLiveData<>();




    public void getRestaurantDetails(String id){
        RetrofitModule.foodHubApiService().restaurantDetails("restaurant",id).enqueue(new Callback<RestaurantDetails>() {
            @Override
            public void onResponse(Call<RestaurantDetails> call, Response<RestaurantDetails> response) {
                restaurantDetails.postValue(response.body());
            }

            @Override
            public void onFailure(Call<RestaurantDetails> call, Throwable t) {

            }
        });
    }


}
