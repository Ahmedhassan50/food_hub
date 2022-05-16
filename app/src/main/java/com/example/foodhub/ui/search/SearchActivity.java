package com.example.foodhub.ui.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.foodhub.data.remote.ServiceStatus;
import com.example.foodhub.databinding.ActivitySearchBinding;
import com.example.foodhub.ui.auth.AuthViewModel;
import com.example.foodhub.ui.search.adapter.TapAdapter;
import com.example.foodhub.ui.search.fragments.FoodItemFragment;
import com.example.foodhub.ui.search.fragments.RestaurantFragment;
import com.google.android.material.tabs.TabLayout;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;
    public static SearchViewModel searchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        TapAdapter tapAdapter = new TapAdapter(getSupportFragmentManager(), getLifecycle());
        tapAdapter.addFragment(new FoodItemFragment(), "Food Item");
        tapAdapter.addFragment(new RestaurantFragment(), "Restaurant");


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


        binding.loginBackBtn.setOnClickListener(v -> {
            finish();
        });


        binding.searchEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(binding.searchTab.getSelectedTabPosition()==0){
                    searchViewModel.getSearchedMeals(charSequence.toString());
                }else {
                    searchViewModel.getSearchedRestaurants(charSequence.toString());
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        searchViewModel.searchStatus.observe(this, new Observer<ServiceStatus>() {
            @Override
            public void onChanged(ServiceStatus serviceStatus) {
                if (serviceStatus == ServiceStatus.LOADING) {
                    binding.searchProgress.setVisibility(View.VISIBLE);
                } else {
                    binding.searchProgress.setVisibility(View.INVISIBLE);
                }
            }
        });


    }


}