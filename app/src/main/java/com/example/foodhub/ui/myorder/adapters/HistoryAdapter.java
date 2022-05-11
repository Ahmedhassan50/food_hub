package com.example.foodhub.ui.myorder.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodhub.R;
import com.example.foodhub.ui.myorder.OrderDetailsActivity;
import com.example.foodhub.ui.restaurantdetails.RestaurantDetailsActivity;


public class HistoryAdapter extends  RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{


    @Override
    public HistoryAdapter.HistoryViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.history_order_item,parent,false);
        return new HistoryAdapter.HistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder( HistoryAdapter.HistoryViewHolder holder, int position) {

        holder.itemView.setOnClickListener(v->{
            Intent i =new Intent(holder.itemView.getContext(), OrderDetailsActivity.class);
            holder.itemView.getContext().startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder{

        public HistoryViewHolder( View itemView) {
            super(itemView);

        }
    }
}
