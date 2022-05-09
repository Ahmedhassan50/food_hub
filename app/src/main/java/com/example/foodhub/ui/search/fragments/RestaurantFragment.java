package com.example.foodhub.ui.search.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.foodhub.databinding.FragmentRestaurantBinding;
import com.example.foodhub.ui.search.adapter.RestaurantSearchAdapter;

public class RestaurantFragment extends Fragment {
    private FragmentRestaurantBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentRestaurantBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RestaurantSearchAdapter adapter =new RestaurantSearchAdapter();

        binding.restaurantSearchRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        binding.restaurantSearchRv.setAdapter(adapter);

    }
}