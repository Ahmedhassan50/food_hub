package com.example.foodhub.ui.search;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.model.Restaurant;
import com.example.foodhub.data.remote.RetrofitModule;
import com.example.foodhub.data.remote.ServiceStatus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewModel extends ViewModel {

    public MutableLiveData<List<Meal>> searchedMeals = new MutableLiveData<>();
    public MutableLiveData<List<Restaurant>> searchedRestaurants = new MutableLiveData<>();
    MutableLiveData<ServiceStatus> searchStatus=new MutableLiveData<>();

    public void getSearchedMeals(String keyword) {
        searchStatus.postValue(ServiceStatus.LOADING);
        RetrofitModule.foodHubApiService().searchMeal("search_food", keyword).enqueue(new Callback<List<Meal>>() {
            @Override
            public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {
                Meal dummy =new Meal("","","","","","","","");
                response.body().add(0,dummy);

                searchedMeals.postValue(response.body());
                searchStatus.postValue(ServiceStatus.SUCCESS);
            }

            @Override
            public void onFailure(Call<List<Meal>> call, Throwable t) {
                searchStatus.postValue(ServiceStatus.ERROR);

            }
        });
    }



    public void getSearchedRestaurants(String keyword) {
        searchStatus.postValue(ServiceStatus.LOADING);
        RetrofitModule.foodHubApiService().searchRestaurant("search_restaurant", keyword).enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                Restaurant dummy =new Restaurant("","","","","","","","","","");
                response.body().add(0,dummy);

                searchedRestaurants.postValue(response.body());
                searchStatus.postValue(ServiceStatus.SUCCESS);
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                searchStatus.postValue(ServiceStatus.ERROR);

            }
        });
    }

}
