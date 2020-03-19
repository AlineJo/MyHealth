package com.example.myhealth.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myhealth.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LifeStyleFragment extends Fragment {


    public LifeStyleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_life_style, container, false);

        TextView tvText = parentView.findViewById(R.id.fragment_text);
        tvText.setText("HelloFrom LifeStyleFragment!!!");

        return parentView;
    }

}
