package com.example.foodhub.ui.search.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.ui.home.adapters.CartAdapter;


public class RestaurantSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int FIRST_ELEMENT = 1;
    private static final int NORMAL_ELEMENT = 2;

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return FIRST_ELEMENT;
        }
        return NORMAL_ELEMENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.restaurant_search_item, parent, false);
        View firstV = inflater.inflate(R.layout.first_search_element, parent, false);

        if (viewType == FIRST_ELEMENT) {
            return new FirstElementSearchViewHolder(firstV);
        }
        return new RestaurantSearchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getClass() == FirstElementSearchViewHolder.class) {

        } else {

        }

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    static class RestaurantSearchViewHolder extends RecyclerView.ViewHolder {

        public RestaurantSearchViewHolder(View itemView) {
            super(itemView);

        }
    }

    static class FirstElementSearchViewHolder extends RecyclerView.ViewHolder {

        public FirstElementSearchViewHolder(View itemView) {
            super(itemView);

        }
    }
}
