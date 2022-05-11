package com.example.foodhub.ui.addresses.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.ui.myorder.OrderDetailsActivity;
import com.example.foodhub.ui.myorder.adapters.HistoryAdapter;

public class AddressAdapter extends  RecyclerView.Adapter<AddressAdapter.AddressViewHolder>{


    @Override
    public AddressAdapter.AddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.address_item,parent,false);
        return new AddressAdapter.AddressViewHolder(v);
    }

    @Override
    public void onBindViewHolder( AddressAdapter.AddressViewHolder holder, int position) {

        /*holder.itemView.setOnClickListener(v->{
            Intent i =new Intent(holder.itemView.getContext(), OrderDetailsActivity.class);
            holder.itemView.getContext().startActivity(i);
        });*/
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class AddressViewHolder extends RecyclerView.ViewHolder{

        public AddressViewHolder( View itemView) {
            super(itemView);

        }
    }
}
