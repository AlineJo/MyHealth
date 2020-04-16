package com.example.myhealth.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhealth.R;
import com.example.myhealth.model.FoodGroup;

import java.util.ArrayList;

public class FoodGroupAdapter extends RecyclerView.Adapter<FoodGroupAdapter.MyViewHolder> {

    private ArrayList<FoodGroup> mItems;
    private FoodAdapterListener mListener;

    public FoodGroupAdapter() {
        mItems = new ArrayList<FoodGroup>();
    }

    public void update(ArrayList<FoodGroup> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    public void update(FoodGroup foodGroup) {
        mItems.add(foodGroup);
        notifyItemChanged(mItems.indexOf(foodGroup), foodGroup);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_food_group, parent, false);

        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final FoodGroup foodGroup = mItems.get(position);


        holder.ivImg.setImageResource(foodGroup.getImage());
        holder.tvTitle.setText(foodGroup.getTitle());
        holder.tvTitle.setBackgroundColor(Color.parseColor(foodGroup.getCardColor()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onClick(foodGroup);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    public void setupFoodAdapterListener(FoodAdapterListener listener) {
        mListener = listener;
    }

    public interface FoodAdapterListener {
        void onClick(FoodGroup foodGroup);
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImg;
        TextView tvTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImg = itemView.findViewById(R.id.iv_img);
            tvTitle = itemView.findViewById(R.id.tv_titles);

        }
    }
}
