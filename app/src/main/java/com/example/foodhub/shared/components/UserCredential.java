package com.example.foodhub.shared.components;

import com.example.foodhub.data.model.User;

public class UserCredential {

    private static UserCredential INSTANCE ;

    private User UserData;


    private UserCredential() {
    }

    public static UserCredential getInstance(){
        if(INSTANCE == null){
            INSTANCE = new UserCredential();
        }
        return INSTANCE;
    }

    public User getUserData() {
        return UserData;
    }

    public void setUserData(User userData) {
        UserData = userData;
    }
}
