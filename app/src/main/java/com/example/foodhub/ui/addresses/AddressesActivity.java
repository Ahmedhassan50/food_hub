package com.example.foodhub.ui.addresses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodhub.BaseActivity;
import com.example.foodhub.databinding.ActivityAddressesBinding;
import com.example.foodhub.databinding.ActivityOrdreDetailsBinding;
import com.example.foodhub.ui.addresses.adapters.AddressAdapter;
import com.example.foodhub.ui.home.adapters.CartAdapter;

public class AddressesActivity extends BaseActivity {
    private ActivityAddressesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding =ActivityAddressesBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        AddressAdapter adapter =new AddressAdapter();

        binding.addressRv.setLayoutManager(new LinearLayoutManager(this));
        binding.addressRv.setNestedScrollingEnabled(false);
        binding.addressRv.setAdapter(adapter);

        binding.backBtn.setOnClickListener(v->{
            finish();
        });

        binding.addAddressBtn.setOnClickListener(v->{
            goTo(AddAddressActivity.class);
        });
    }
}