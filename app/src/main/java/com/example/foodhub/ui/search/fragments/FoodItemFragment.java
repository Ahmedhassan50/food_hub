package com.example.foodhub.ui.search.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.foodhub.data.model.Meal;
import com.example.foodhub.databinding.FragmentFoodItemBinding;
import com.example.foodhub.ui.search.SearchActivity;
import com.example.foodhub.ui.search.adapter.FoodItemSearchAdapter;
import com.example.foodhub.ui.search.adapter.RestaurantSearchAdapter;

import java.util.List;


public class FoodItemFragment extends Fragment {
    private FragmentFoodItemBinding binding;
private FoodItemSearchAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentFoodItemBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter =new FoodItemSearchAdapter();

        binding.foodItemSearchRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        binding.foodItemSearchRv.setAdapter(adapter);


        SearchActivity.searchViewModel.searchedMeals.observe(getActivity(), new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> meals) {
                adapter.setData(meals);
            }
        });


    }
}
