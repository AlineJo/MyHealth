package com.example.myhealth.dialogs;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myhealth.R;


public class AddGoalFragmentDialog extends DialogFragment {


    public static final String KEY_SHOULD_EDIT = "should_edit";
    public static final String KEY_NEW_TITLE = "new_title";
    public static final String KEY_INDEX = "INDEX";

    // TODO: Rename and change types of parameters
    private boolean mShouldEdit;
    private String mTitle;
    private GoalsDialogInterface mListener;
    private int mIndex;

    public AddGoalFragmentDialog() {
        // Required empty public constructor
    }

    public static AddGoalFragmentDialog newInstance(boolean shouldEdit, String newTitle, int index) {
        AddGoalFragmentDialog fragment = new AddGoalFragmentDialog();
        Bundle args = new Bundle();
        args.putBoolean(KEY_SHOULD_EDIT, shouldEdit);
        args.putString(KEY_NEW_TITLE, newTitle);
        args.putInt(KEY_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        try {
            Dialog dialog = getDialog();
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(KEY_NEW_TITLE);
            mShouldEdit = getArguments().getBoolean(KEY_SHOULD_EDIT);
            mIndex = getArguments().getInt(KEY_INDEX);
        }
    }


    public void setGoalsListener(Fragment fragment) {
        mListener = (GoalsDialogInterface) fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_add_goal_dialog, container, false);

        TextView tvDialogTitle = parentView.findViewById(R.id.tv_dialog_title);
        final EditText etTitle = parentView.findViewById(R.id.et_title);
        Button btnSubmit = parentView.findViewById(R.id.btn_submit);
        Button btnCancel = parentView.findViewById(R.id.btn_cancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        if (mShouldEdit) {

            tvDialogTitle.setText("تعديل الآهداف");
            etTitle.setText(mTitle);
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){

                        if(etTitle.getText().toString().isEmpty()){
                            etTitle.setError("رجاءا اكتب الهدف");
                        }
                        else{
                            mListener.editGoal(mIndex,etTitle.getText().toString());
                            dismiss();
                        }
                    }
                }
            });

        } else {
            tvDialogTitle.setText("اضافة اهداف");
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){

                        if(etTitle.getText().toString().isEmpty()){
                            etTitle.setError("رجاءا اكتب الهدف");
                        }
                        else{

                            mListener.addGoal(etTitle.getText().toString());
                            dismiss();
                        }
                    }
                }
            });

        }

        return parentView;
    }

    public interface GoalsDialogInterface {
        void addGoal(String goal);

        void editGoal(int index, String goal);

    }
}
