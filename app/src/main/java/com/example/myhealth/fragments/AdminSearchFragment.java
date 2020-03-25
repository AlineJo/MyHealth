package com.example.myhealth.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhealth.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminSearchFragment extends Fragment {

    public AdminSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_admin_search, container, false);


        return parentView;
    }
}
