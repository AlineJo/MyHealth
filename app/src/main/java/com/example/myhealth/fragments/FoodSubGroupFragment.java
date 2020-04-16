package com.example.myhealth.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhealth.R;
import com.example.myhealth.adapters.FoodSubGroupAdapter;
import com.example.myhealth.interfaces.MediatorInterface;
import com.example.myhealth.model.FoodSubGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodSubGroupFragment extends Fragment {


    private ArrayList<FoodSubGroup> mItems;
    private FoodSubGroupAdapter mAdapter;
    private Context mContext;
    private String mSuperGroupTitle;
    private MediatorInterface mMediatorCallback;

    public FoodSubGroupFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
        mMediatorCallback = (MediatorInterface) context;
    }


    public void setFoodSubGroup(ArrayList<FoodSubGroup> items, String title) {
        mItems = items;
        mSuperGroupTitle = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_food_sub_group, container, false);

        mAdapter = new FoodSubGroupAdapter();
        RecyclerView recyclerView = parentView.findViewById(R.id.recycler_view);
        setupRecyclerView(recyclerView);
        if (mItems != null) {
            mAdapter.update(mItems);

        }
        Button btnSubmit = parentView.findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFoodDetailsFragment();
            }
        });

        return parentView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setFoodSubGroupListener(new FoodSubGroupAdapter.FoodSubGroupListener() {
            @Override
            public void onClick(FoodSubGroup foodSubGroup) {


            }
        });
        recyclerView.setAdapter(mAdapter);
    }

    private void openFoodDetailsFragment() {
        FoodDetailsFragment fragment = new FoodDetailsFragment();
        fragment.setData(mItems, mSuperGroupTitle);

        mMediatorCallback.changeFragmentTo(fragment, FoodDetailsFragment.class.getSimpleName());
    }

}
