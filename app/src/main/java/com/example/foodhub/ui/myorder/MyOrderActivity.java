package com.example.foodhub.ui.myorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.foodhub.databinding.ActivityMyOrderBinding;
import com.example.foodhub.ui.myorder.fragments.HistoryFragment;
import com.example.foodhub.ui.myorder.fragments.UpComingFragment;
import com.example.foodhub.ui.search.adapter.TapAdapter;
import com.example.foodhub.ui.search.fragments.FoodItemFragment;
import com.example.foodhub.ui.search.fragments.RestaurantFragment;
import com.google.android.material.tabs.TabLayout;

public class MyOrderActivity extends AppCompatActivity {

    private ActivityMyOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMyOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        TapAdapter tapAdapter =new TapAdapter(getSupportFragmentManager(),getLifecycle());
        tapAdapter.addFragment(new UpComingFragment(),"Upcoming");
        tapAdapter.addFragment(new HistoryFragment(),"History");


        binding.myorderTab.addTab(binding.myorderTab.newTab().setText("Upcoming"));
        binding.myorderTab.addTab(binding.myorderTab.newTab().setText("History"));

        binding.myorderViewPager.setAdapter(tapAdapter);
        binding.myorderTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.myorderViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.myorderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.myorderTab.selectTab(binding.myorderTab.getTabAt(position));
            }
        });


        binding.backBtn.setOnClickListener(v->{
            finish();
        });
    }
}