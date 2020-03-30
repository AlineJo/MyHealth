package com.example.myhealth.fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.myhealth.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoalsFragment extends Fragment {

    private int mYear;
    private int mMonth;
    private int mDay;
    private Context mContext;
    private int mHour;
    private int mMinute;

    public GoalsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_goals, container, false);

        getCurrentDate();

        EditText etCalories = parentView.findViewById(R.id.et_calories);
        Spinner spinnerGoals = parentView.findViewById(R.id.spinner_goals);
        final EditText etTime = parentView.findViewById(R.id.et_time);
        final EditText etDateStart = parentView.findViewById(R.id.et_date_start);
        final EditText etDateEnd = parentView.findViewById(R.id.et_date_end);
        Button btnSubmit = parentView.findViewById(R.id.btn_submit);

        etTime.setFocusable(false);
        etDateStart.setFocusable(false);
        etDateEnd.setFocusable(false);

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayTimePicker(etTime);
            }
        });
        etDateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayDatePicker(etDateStart);
            }
        });
        etDateEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayDatePicker(etDateEnd);

            }
        });

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, getDemoGoals());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerGoals.setAdapter(adapter);


        return parentView;
    }

    private ArrayList<String> getDemoGoals() {


        ArrayList<String> goals = new ArrayList<>();
        goals.add("تخفيف الوزن ٨ كيلو جرام");
        goals.add("شرب ٨ اكواب ماء");
        goals.add("الجري مسافة ٣ كم يوميا");
        goals.add("النوم ٨ ساعات");

        return goals;

    }




    private void displayDatePicker(final TextView textView) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        textView.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    void displayTimePicker(final TextView textView) {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(mContext,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        textView.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void getCurrentDate() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
    }
}
