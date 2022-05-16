package com.example.foodhub.ui.mealdetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.remote.RetrofitModule;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealViewModel extends ViewModel {

    public MutableLiveData<Meal> mealDetails=new MutableLiveData<>();


    public void getMealDetails(String id){
        RetrofitModule.foodHubApiService().mealDetails("food",id).enqueue(new Callback<Meal>() {
            @Override
            public void onResponse(Call<Meal> call, Response<Meal> response) {
                mealDetails.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Meal> call, Throwable t) {

            }
        });
    }

}
