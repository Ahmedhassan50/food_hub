package com.example.foodhub.ui.search.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.foodhub.databinding.FragmentFoodItemBinding;
import com.example.foodhub.ui.search.adapter.FoodItemSearchAdapter;
import com.example.foodhub.ui.search.adapter.RestaurantSearchAdapter;


public class FoodItemFragment extends Fragment {
    private FragmentFoodItemBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentFoodItemBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FoodItemSearchAdapter adapter =new FoodItemSearchAdapter();

        binding.foodItemSearchRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        binding.foodItemSearchRv.setAdapter(adapter);


    }
}
