package com.example.foodhub.ui.mealdetails.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodhub.R;
import com.example.foodhub.data.model.AddOn;


import java.util.List;

public class AddOnAdapter extends  RecyclerView.Adapter<AddOnAdapter.AddOnViewHolder>{

    private List<AddOn> addOns;
    public AddOnAdapter(List<AddOn>addOns){
        this.addOns=addOns;
    }
    private int selectedPosition=0;

    @NonNull
    @Override
    public AddOnAdapter.AddOnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.add_on_item,parent,false);
        return new AddOnAdapter.AddOnViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AddOnAdapter.AddOnViewHolder holder, int position) {
        AddOn addOn =addOns.get(position);

        holder.addOnName.setText(addOn.getName());
        holder.addOnPrice.setText("+$"+addOn.getPrice());
        holder.addOnImage.setImageResource(addOn.getImage());



        if(position==selectedPosition){
            holder.addOnRadio.setChecked(true);
        }else {
            holder.addOnRadio.setChecked(false);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                selectedPosition =holder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });




    }

    @Override
    public int getItemCount() {
        return addOns.size();
    }

    static class AddOnViewHolder extends RecyclerView.ViewHolder{
        ImageView addOnImage;
        TextView addOnName;
        TextView addOnPrice;
        RadioButton addOnRadio;
        public AddOnViewHolder(@NonNull View itemView) {
            super(itemView);
            addOnImage =itemView.findViewById(R.id.add_on_image);
            addOnName =itemView.findViewById(R.id.add_on_name);
            addOnPrice = itemView.findViewById(R.id.add_on_price);
            addOnRadio =itemView.findViewById(R.id.on_item_radio);
        }
    }
}

