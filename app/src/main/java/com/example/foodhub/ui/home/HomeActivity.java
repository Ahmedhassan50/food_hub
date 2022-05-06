package com.example.foodhub.ui.home;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import com.example.foodhub.BaseActivity;
import com.example.foodhub.R;
import com.example.foodhub.databinding.ActivityHomeBinding;
import com.example.foodhub.ui.home.fragment.CartFragment;
import com.example.foodhub.ui.home.fragment.FavoriteFragment;
import com.example.foodhub.ui.home.fragment.HomeFragment;
import com.example.foodhub.ui.home.fragment.MapFragment;
import com.example.foodhub.ui.home.fragment.NotificationFragment;

public class HomeActivity extends BaseActivity {

    private ActivityHomeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

    }


    private void replaceFragment(Fragment fragment) {
        if (fragment != null) {

            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.home_frame, fragment);
            transaction.commit();

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

}