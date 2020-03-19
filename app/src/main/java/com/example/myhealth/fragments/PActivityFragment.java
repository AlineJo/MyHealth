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
public class PActivityFragment extends Fragment {


    private String msg;

    public PActivityFragment() {
        // Required empty public constructor
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_pactivity, container, false);

        TextView tvMsg = parentView.findViewById(R.id.tv_msg);
        if (!msg.isEmpty()) {
            tvMsg.setText(msg);
        }

        return parentView;
    }

}
