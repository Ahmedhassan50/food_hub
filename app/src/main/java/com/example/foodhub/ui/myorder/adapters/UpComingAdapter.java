package com.example.foodhub.ui.myorder.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.ui.myorder.OrderDetailsActivity;

public class UpComingAdapter  extends  RecyclerView.Adapter<UpComingAdapter.UpComingViewHolder>{


    @Override
    public UpComingAdapter.UpComingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.upcoming_order_item,parent,false);
        return new UpComingAdapter.UpComingViewHolder(v);
    }

    @Override
    public void onBindViewHolder( UpComingAdapter.UpComingViewHolder holder, int position) {
        holder.itemView.setOnClickListener(v->{
            Intent i =new Intent(holder.itemView.getContext(), OrderDetailsActivity.class);
            holder.itemView.getContext().startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class UpComingViewHolder extends RecyclerView.ViewHolder{

        public UpComingViewHolder( View itemView) {
            super(itemView);

        }
    }
}

