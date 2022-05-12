package com.example.foodhub.ui.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodhub.databinding.FragmentFavoriteFoodItemBinding;
import com.example.foodhub.databinding.FragmentHistoryBinding;
import com.example.foodhub.ui.home.adapters.FavoriteFoodItemAdapter;
import com.example.foodhub.ui.home.adapters.FavoriteRestaurantAdapter;
import com.example.foodhub.ui.myorder.adapters.HistoryAdapter;
import com.example.foodhub.ui.restaurantdetails.adapters.FeaturedItemAdapter;

public class FavoriteFoodItemFragment extends Fragment {
    private FragmentFavoriteFoodItemBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentFavoriteFoodItemBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FavoriteFoodItemAdapter adapter =new FavoriteFoodItemAdapter();
        binding.favoriteFoodItemRv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.favoriteFoodItemRv.setAdapter(adapter);



    }
}
