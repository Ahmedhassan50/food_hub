package com.example.foodhub;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected void  goTo(Class nextActivity){
        Intent intent =new Intent(this, nextActivity);
        startActivity(intent);
    }


}
