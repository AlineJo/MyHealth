package com.example.myhealth.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhealth.R;
import com.example.myhealth.model.FoodSubGroup;

import java.util.ArrayList;

public class FoodSubGroupAdapter extends RecyclerView.Adapter<FoodSubGroupAdapter.MyViewHolder> {

    ArrayList<FoodSubGroup> mItems;
    private FoodSubGroupListener mListener;

    public FoodSubGroupAdapter() {
        mItems = new ArrayList<>();
    }


    public void update(ArrayList<FoodSubGroup> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    public void update(FoodSubGroup foodSubGroup) {
        mItems.add(foodSubGroup);
        notifyItemChanged(mItems.indexOf(foodSubGroup), foodSubGroup);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_food_sub_group, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        final FoodSubGroup foodSubGroup = mItems.get(position);

        holder.ivImg.setImageResource(foodSubGroup.getImage());
        holder.tvQuantity.setText(foodSubGroup.getQuantity());
        holder.tvQuantity.setBackgroundColor(Color.parseColor(foodSubGroup.getCardColor()));
        holder.tvTitle.setText(foodSubGroup.getTitle());
        holder.tvSubTitle.setText(foodSubGroup.getSubTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {

                    mListener.onClick(foodSubGroup);

                    boolean b = !holder.checkBox.isChecked();
                    foodSubGroup.setSelected(b);
                    holder.checkBox.setChecked(b);
                    notifyItemChanged(position, foodSubGroup);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setFoodSubGroupListener(FoodSubGroupListener listener) {
        mListener = listener;
    }

    public interface FoodSubGroupListener {
        void onClick(FoodSubGroup foodSubGroup);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImg;
        TextView tvQuantity;
        TextView tvTitle;
        TextView tvSubTitle;
        CheckBox checkBox;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImg = itemView.findViewById(R.id.iv_img);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
            tvTitle = itemView.findViewById(R.id.tv_titles);
            tvSubTitle = itemView.findViewById(R.id.tv_sub_title);
            checkBox = itemView.findViewById(R.id.checkbox);

        }
    }
}
