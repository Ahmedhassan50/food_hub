package com.example.foodhub.ui.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodhub.R;
import com.example.foodhub.data.model.Category;
import com.example.foodhub.databinding.FragmentHomeBinding;
import com.example.foodhub.ui.home.adapters.CategoryAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;



    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        binding =FragmentHomeBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Category> categories =new ArrayList<>();
        categories.add(new Category(R.drawable.burger_image,"Burger"));
        categories.add(new Category(R.drawable.burger_image,"Donat"));
        categories.add(new Category(R.drawable.burger_image,"Pizza"));
        categories.add(new Category(R.drawable.burger_image,"Mexican"));
        categories.add(new Category(R.drawable.burger_image,"Asian"));


        CategoryAdapter adapter =new CategoryAdapter(categories);

        binding.categoryRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.categoryRv.setAdapter(adapter);


    }
}
