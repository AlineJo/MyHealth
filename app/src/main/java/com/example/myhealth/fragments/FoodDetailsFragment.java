package com.example.myhealth.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myhealth.R;
import com.example.myhealth.model.FoodSubGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodDetailsFragment extends Fragment {


    private ArrayList<FoodSubGroup> mItems;
    private String mSuperGroupTitle;

    public FoodDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_food_details, container, false);


        TextView tvLabel = parentView.findViewById(R.id.tv_label);
        TextView tvTitles = parentView.findViewById(R.id.tv_titles);
        TextView tvCalories = parentView.findViewById(R.id.tv_calories);

        tvLabel.setText(mSuperGroupTitle);

        double totalCalories = 0;

        for (int i = 0; i < mItems.size(); i++) {
            FoodSubGroup subGroup = mItems.get(i);
            if (subGroup.isSelected()) {
                totalCalories += subGroup.getCalories();
                tvTitles.append(subGroup.getTitle());
                if (i != mItems.size() - 1) {
                    System.out.print(", ");
                }
            }

        }


        tvCalories.setText(totalCalories + "");

        return parentView;
    }

    public void setData(ArrayList<FoodSubGroup> items, String superGroupTitle) {
        mItems = items;
        mSuperGroupTitle = superGroupTitle;
    }
}
