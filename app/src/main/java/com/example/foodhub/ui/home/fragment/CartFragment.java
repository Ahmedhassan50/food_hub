package com.example.foodhub.ui.home.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodhub.R;
import com.example.foodhub.databinding.FragmentCartBinding;
import com.example.foodhub.databinding.FragmentHomeBinding;
import com.example.foodhub.ui.checkout.CheckOutActivity;
import com.example.foodhub.ui.home.HomeActivity;
import com.example.foodhub.ui.home.adapters.CartAdapter;
import com.example.foodhub.ui.search.SearchActivity;

public class CartFragment extends Fragment {
    private FragmentCartBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentCartBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CartAdapter adapter =new CartAdapter();
        binding.backBtn.setOnClickListener(v->{
            backHome();

        });

        binding.cartRv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.cartRv.setNestedScrollingEnabled(false);
        binding.cartRv.setAdapter(adapter);

        binding.checkOut.setOnClickListener(v->{
            Intent i =new Intent(getContext(), CheckOutActivity.class);
            getContext().startActivity(i);
        });

    }





    public void backHome(){
        ((HomeActivity) getActivity()).replaceFragment(new HomeFragment());
        ((HomeActivity) getActivity()).binding.homeIconTap.setColorFilter((getResources().getColor(R.color.main_color)));
        ((HomeActivity) getActivity()).binding.mapIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
        ((HomeActivity) getActivity()).binding.favoriteIconTap.setColorFilter(Color.parseColor("#D3D1D8"));
        ((HomeActivity) getActivity()).binding.notificationIconImage.setColorFilter(Color.parseColor("#D3D1D8"));

    }
}
