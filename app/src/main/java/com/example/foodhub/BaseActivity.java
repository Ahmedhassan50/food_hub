package com.example.foodhub;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected void  goTo(Class nextActivity){
        Intent intent =new Intent(this, nextActivity);
        startActivity(intent);
    }

    protected void transparentStatusBar(){
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

                | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        );
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }


}
