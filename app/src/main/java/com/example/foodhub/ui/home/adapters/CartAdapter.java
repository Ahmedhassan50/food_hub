package com.example.foodhub.ui.home.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.model.Meal;

import java.util.List;

public class CartAdapter extends  RecyclerView.Adapter<CartAdapter.CartViewHolder>{



    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.cart_item,parent,false);
        return new CartAdapter.CartViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CartAdapter.CartViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 2;
    }

    static class CartViewHolder extends RecyclerView.ViewHolder{

        public CartViewHolder(View itemView) {
            super(itemView);

        }
    }
}

