package com.example.foodhub.ui.auth;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.JsonReader;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodhub.data.model.LoginRequest;
import com.example.foodhub.data.model.User;
import com.example.foodhub.data.remote.RetrofitModule;
import com.example.foodhub.data.remote.ServiceStatus;
import com.example.foodhub.shared.components.UserCredential;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthViewModel extends AndroidViewModel {

    MutableLiveData<ServiceStatus> loginStatus=new MutableLiveData<>();
    MutableLiveData<ServiceStatus> SignUpStatus=new MutableLiveData<>();

    public AuthViewModel(@NonNull Application application) {
        super(application);
    }


    public void login(String email,String password){
        SharedPreferences pref = getApplication().getSharedPreferences("user", Context.MODE_PRIVATE);

        loginStatus.postValue(ServiceStatus.LOADING);

        RetrofitModule.foodHubApiService().login(email,password,"user","login").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()){
                    loginStatus.postValue(ServiceStatus.SUCCESS);
                  UserCredential userCredential=  UserCredential.getInstance();
                  userCredential.setUserData(response.body());
                }else{
                    loginStatus.postValue(ServiceStatus.ERROR);
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loginStatus.postValue(ServiceStatus.ERROR);
            }
        });

    }

    public void signUp(String name,String email,String password,String mobile){
        SharedPreferences pref = getApplication().getSharedPreferences("user", Context.MODE_PRIVATE);

        loginStatus.postValue(ServiceStatus.LOADING);

        RetrofitModule.foodHubApiService().signUp("signup","user",email,password,name,mobile).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()){
                    loginStatus.postValue(ServiceStatus.SUCCESS);
                }else{
                    loginStatus.postValue(ServiceStatus.ERROR);
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                loginStatus.postValue(ServiceStatus.ERROR);
                Log.e("errot",t.getMessage());
            }
        });

    }


}
