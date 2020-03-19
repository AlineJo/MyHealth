package com.example.myhealth.activities;


import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myhealth.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LifestyleActivity extends AppCompatActivity {


    public LifestyleActivity() {
        // Required empty public constructor
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifestyle_form);

        View includeView1 = findViewById(R.id.inc_q1);
        View includeView2 = findViewById(R.id.inc_q2);
        View includeView3 = findViewById(R.id.inc_q3);
        View includeView4 = findViewById(R.id.inc_q4);
        View includeView5 = findViewById(R.id.inc_q5);
        View includeView6 = findViewById(R.id.inc_q6);

        TextView tvQuestion1 = includeView1.findViewById(R.id.tv_question);
        TextView tvQuestion2 = includeView2.findViewById(R.id.tv_question);
        TextView tvQuestion3 = includeView3.findViewById(R.id.tv_question);
        TextView tvQuestion4 = includeView4.findViewById(R.id.tv_question);
        TextView tvQuestion5 = includeView5.findViewById(R.id.tv_question);
        TextView tvQuestion6 = includeView6.findViewById(R.id.tv_question);

        RadioGroup radioGroup1 = includeView1.findViewById(R.id.radio_group);
        RadioGroup radioGroup2 = includeView2.findViewById(R.id.radio_group);
        RadioGroup radioGroup4 = includeView4.findViewById(R.id.radio_group);
        RadioGroup radioGroup5 = includeView5.findViewById(R.id.radio_group);
        RadioGroup radioGroup6 = includeView6.findViewById(R.id.radio_group);

        tvQuestion1.setText("هل تدخن؟");
        tvQuestion2.setText("هل تمارس الانشطة البدنيه بمعدل 30 دقيقه يوميا؟");
        tvQuestion3.setText(" كم ساعة تقضيها أمام الشاشة يوميا؟ (التلفاز,الحاسب الالي ,الهاتف,..الخ)");
        tvQuestion4.setText("كم فاكهه استهلكتها بالأمس؟");
        tvQuestion5.setText("كم عدد الوجبات التى أكلتها بالأمس وتحتوي على الخضروات؟");
        tvQuestion6.setText("كم عددالمرات التى تأكل فيها الوجبات السريعه؟");

    }


}

