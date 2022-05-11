package com.example.foodhub.ui.home;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toolbar;

import com.example.foodhub.BaseActivity;
import com.example.foodhub.R;
import com.example.foodhub.databinding.ActivityHomeBinding;
import com.example.foodhub.ui.addresses.AddressesActivity;
import com.example.foodhub.ui.home.fragment.CartFragment;
import com.example.foodhub.ui.home.fragment.FavoriteFragment;
import com.example.foodhub.ui.home.fragment.HomeFragment;
import com.example.foodhub.ui.home.fragment.MapFragment;
import com.example.foodhub.ui.home.fragment.NotificationFragment;
import com.example.foodhub.ui.myorder.MyOrderActivity;
import com.example.foodhub.ui.profile.ProfileActivity;
import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;


public class HomeActivity extends BaseActivity {

    public ActivityHomeBinding binding;

public static SlidingRootNav drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());




        drawer = new SlidingRootNavBuilder(this)
                .withDragDistance(180)
                .withRootViewScale(0.75f)
                .withRootViewElevation(20)
                .withRootViewYTranslation(4)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.drawer_layout)
                .inject();


        drawerListeners();





    }


    public void replaceFragment(Fragment fragment) {
        if (fragment != null) {

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.home_frame, fragment);
            transaction.commit();

        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isMenuOpened()){
            drawer.closeMenu();
        }else{
            super.onBackPressed();
        }

    }
    



    public void exec(View view) {
        switch (view.getId()) {
            case R.id.home_icon_tap:
                replaceFragment(new HomeFragment());
                binding.homeIconTap.setColorFilter((getResources().getColor(R.color.main_color)));
                binding.mapIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
                binding.favoriteIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
                binding.notificationIconImage.setColorFilter(Color.parseColor("#D3D1D8"));
                break;
            case R.id.map_icon_tap:
                replaceFragment(new MapFragment());
                binding.mapIconTap.setColorFilter((getResources().getColor(R.color.main_color)));
                binding.homeIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
                binding.favoriteIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
                binding.notificationIconImage.setColorFilter(Color.parseColor("#D3D1D8"));


                break;
            case R.id.cart_icon_tap:
                replaceFragment(new CartFragment());
                binding.favoriteIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
                binding.mapIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
                binding.homeIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
                binding.notificationIconImage.setColorFilter(Color.parseColor("#D3D1D8"));
                break;
            case R.id.favorite_icon_tap:
                replaceFragment(new FavoriteFragment());
                binding.favoriteIconTap.setColorFilter((getResources().getColor(R.color.main_color)));
                binding.mapIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
                binding.homeIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
                binding.notificationIconImage.setColorFilter(Color.parseColor("#D3D1D8"));
                break;
            case R.id.notification_icon_tap:
                replaceFragment(new NotificationFragment());
                binding.notificationIconImage.setColorFilter((getResources().getColor(R.color.main_color)));
                binding.favoriteIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
                binding.mapIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
                binding.homeIconTap.setColorFilter(Color.parseColor("#D3D1D8"));

                break;
        }
    }


    private void drawerListeners(){
        drawer.getLayout().findViewById(R.id.item1).setOnClickListener(v->{
            goTo(MyOrderActivity.class);
            drawer.closeMenu();
        });
        drawer.getLayout().findViewById(R.id.item2).setOnClickListener(v->{
            goTo(ProfileActivity.class);
            drawer.closeMenu();
        });
        drawer.getLayout().findViewById(R.id.item3).setOnClickListener(v->{
            goTo(AddressesActivity.class);
            drawer.closeMenu();
        });
        drawer.getLayout().findViewById(R.id.item4).setOnClickListener(v->{

        });
        drawer.getLayout().findViewById(R.id.item5).setOnClickListener(v->{

        });
        drawer.getLayout().findViewById(R.id.item6).setOnClickListener(v->{

        });
        drawer.getLayout().findViewById(R.id.item7).setOnClickListener(v->{

        });

    }

}