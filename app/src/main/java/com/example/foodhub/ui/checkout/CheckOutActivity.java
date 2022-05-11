package com.example.foodhub.ui.checkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodhub.R;
import com.example.foodhub.databinding.ActivityAddAddressBinding;
import com.example.foodhub.databinding.ActivityCheckOutBinding;
import com.example.foodhub.ui.checkout.adapters.PaymentMethodsAdapter;

public class CheckOutActivity extends AppCompatActivity {
    private ActivityCheckOutBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckOutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int [] paymentImages ={R.drawable.master_card_icon,R.drawable.paybal,R.drawable.apple};

        PaymentMethodsAdapter adapter = new PaymentMethodsAdapter(paymentImages);

        binding.paymentMethodsRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.paymentMethodsRv.setAdapter(adapter);
    }



}