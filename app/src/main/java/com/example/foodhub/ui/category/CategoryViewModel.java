package com.example.foodhub.ui.category;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodhub.data.model.HomeModel;
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.remote.RetrofitModule;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel  extends ViewModel {

    public MutableLiveData<List<Meal>> catMeals=new MutableLiveData<>();



    public void getCategoryMeals(String id){
//        Log.e("idddddddd",id+"");
        RetrofitModule.foodHubApiService().categoryDetails("foods",id).enqueue(new Callback<List<Meal>>() {
            @Override
            public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {
                catMeals.postValue(response.body());
//                Log.e("homeData",response.body()+"");
            }

            @Override
            public void onFailure(Call<List<Meal>> call, Throwable t) {
//                Log.e("fail",t.getMessage()+"");
            }
        });

    }


}
