package com.example.foodhub.ui.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.foodhub.databinding.ActivitySearchBinding;
import com.example.foodhub.ui.search.adapter.TapAdapter;
import com.example.foodhub.ui.search.fragments.FoodItemFragment;
import com.example.foodhub.ui.search.fragments.RestaurantFragment;
import com.google.android.material.tabs.TabLayout;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        TapAdapter tapAdapter =new TapAdapter(getSupportFragmentManager(),getLifecycle());
        tapAdapter.addFragment(new FoodItemFragment(),"Food Item");
        tapAdapter.addFragment(new RestaurantFragment(),"Restaurant");


        binding.searchTab.addTab(binding.searchTab.newTab().setText("Food Item"));
        binding.searchTab.addTab(binding.searchTab.newTab().setText("Restaurant"));

        binding.searchViewPager.setAdapter(tapAdapter);
        binding.searchTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.searchViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.searchViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.searchTab.selectTab(binding.searchTab.getTabAt(position));
            }
        });


        binding.loginBackBtn.setOnClickListener(v->{
            finish();
        });

    }
}