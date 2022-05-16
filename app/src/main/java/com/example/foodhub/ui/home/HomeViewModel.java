package com.example.foodhub.ui.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodhub.data.model.HomeModel;
import com.example.foodhub.data.remote.RetrofitModule;
import com.example.foodhub.data.remote.ServiceStatus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

  public   MutableLiveData<HomeModel> homeData=new MutableLiveData<>();

    public void getHomeData(){
        RetrofitModule.foodHubApiService().home("home").enqueue(new Callback<HomeModel>() {
            @Override
            public void onResponse(Call<HomeModel> call, Response<HomeModel> response) {
                homeData.postValue(response.body());
//                Log.e("homeData",response.body()+"");
            }

            @Override
            public void onFailure(Call<HomeModel> call, Throwable t) {
//                Log.e("homeData",t.getMessage()+"");
            }
        });
    }
}
