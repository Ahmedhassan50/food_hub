package com.example.foodhub.ui.home.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.foodhub.R;
import com.example.foodhub.databinding.FragmentCartBinding;
import com.example.foodhub.databinding.FragmentFavoriteBinding;
import com.example.foodhub.ui.home.HomeActivity;
import com.example.foodhub.ui.myorder.fragments.HistoryFragment;
import com.example.foodhub.ui.myorder.fragments.UpComingFragment;
import com.example.foodhub.ui.search.adapter.TapAdapter;
import com.google.android.material.tabs.TabLayout;

public class FavoriteFragment extends Fragment {
    private FragmentFavoriteBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentFavoriteBinding.inflate(inflater);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TapAdapter tapAdapter =new TapAdapter(getChildFragmentManager(),getLifecycle());
        tapAdapter.addFragment(new FavoriteFoodItemFragment(),"Food Item");
        tapAdapter.addFragment(new FavoriteRestaurantFragment(),"Restaurant");


        binding.favoriteTab.addTab(binding.favoriteTab.newTab().setText("Food Item"));
        binding.favoriteTab.addTab(binding.favoriteTab.newTab().setText("Restaurant"));

        binding.favoriteViewPager.setAdapter(tapAdapter);
        binding.favoriteTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.favoriteViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.favoriteViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.favoriteTab.selectTab(binding.favoriteTab.getTabAt(position));
            }
        });


        binding.backBtn.setOnClickListener(v->{
            backHome();
        });
    }

    private void backHome(){
        ((HomeActivity) getActivity()).replaceFragment(new HomeFragment());
        ((HomeActivity) getActivity()).binding.homeIconTap.setColorFilter((getResources().getColor(R.color.main_color)));
        ((HomeActivity) getActivity()).binding.mapIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
        ((HomeActivity) getActivity()).binding.favoriteIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
        ((HomeActivity) getActivity()).binding.notificationIconImage.setColorFilter(Color.parseColor("#D3D1D8"));

    }
}
