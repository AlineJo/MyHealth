package com.example.myhealth.fragments;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myhealth.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppInfoFragment extends Fragment {

    public AppInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_app_info, container, false);

        TextView tvInfo = parentView.findViewById(R.id.tv_info);
        tvInfo.setMovementMethod(new ScrollingMovementMethod());

        return parentView;
    }
}
