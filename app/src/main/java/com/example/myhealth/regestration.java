package com.example.myhealth;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.YuvImage;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;


public class regestration extends AppCompatActivity {
    private EditText editTextName, editTextAge, editTextEmail, editTextUsername, editTextPassword,editTextCPassword, editTextsq, editTextAnswer;
    private RadioGroup radioGender;
    private RadioButton r1,r2;
    private Spinner sq;
    Calendar c;
    private Button btnr, btndob;
    int sel_year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);

        btndob =(Button)findViewById(R.id.button3);
        editTextName = (EditText) findViewById(R.id.name);

        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);
        editTextCPassword = (EditText) findViewById(R.id.c_password);
        editTextUsername = (EditText) findViewById(R.id.user);
        sq = (Spinner) findViewById(R.id.spinner_question);
        editTextAnswer = (EditText) findViewById(R.id.answer);
        r1 =(RadioButton)findViewById(R.id.Male);
        r2 =(RadioButton)findViewById(R.id.radioButtonFemale);
        radioGender = (RadioGroup) findViewById(R.id.radioGender);
        btnr = (Button) findViewById(R.id.btnr);
        c=Calendar.getInstance();
        btndob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dp=new DatePickerDialog(regestration.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        btndob.setText(year +"-"+(month+1)+"-"+dayOfMonth);
                        sel_year=year;
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                dp.show();
            }
        });


        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
//String age = editTextAge.getText().toString().trim();
                String gender ;
                String email = editTextEmail.getText().toString().trim();
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String Cpassword=editTextCPassword.getText().toString().trim();
                String sqq =getSelectedQuestion();
                String answer = editTextAnswer.getText().toString().trim();
                String valDob = btndob.getText().toString();
                int age = c.get(Calendar.YEAR)-sel_year;



                if (name.isEmpty()) {
                    editTextName.setError("الاسم مطلوب");
                    editTextName.requestFocus();
                    return;
                }

                if (valDob.equals("العمر")) {
                    Toast.makeText(regestration.this, "ارجاء اختيار العمر", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (radioGender.getCheckedRadioButtonId()==-1) {
                    Toast.makeText(regestration.this, "الرجاء اختيار الجنس", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    editTextEmail.setError("اكتب الايميل بشكل صحيح");
                    editTextEmail.requestFocus();
                    return;
                }


                if (!(age>=19 && age<=75)) {

                    Toast.makeText(regestration.this, "اكتب العمر من 19-75 سنه فقط", Toast.LENGTH_SHORT).show();
                    return;
                }



                if (username.isEmpty()) {
                    editTextUsername.setError("الاسم المستخدم مطلوب");
                    editTextUsername.requestFocus();
                    return;
                }




                if (password.isEmpty()) {
                    editTextPassword.setError("الرقم السري مطلوب");
                    editTextPassword.requestFocus();
                    return;
                }


                if (password.length() < 6) {
                    editTextPassword.setError("الرقم السري يحتوي على سته رموز");
                    editTextPassword.requestFocus();
                    return;
                }

                if(!password.equals(Cpassword)){

                    editTextCPassword.setError("الرقم السري غير متطابق!");
                    editTextCPassword.requestFocus();
                    return;

                }






                if (answer.isEmpty()) {
                    editTextAnswer.setError("الاجابه مطلوبة");
                    editTextAnswer.requestFocus();
                    return;
                }


                if(radioGender.getCheckedRadioButtonId()==R.id.radioButtonFemale)
                    gender="Female";
                else
                    gender="Male";
                Call<DefaultResponse> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .createUser(name, String.valueOf(age), gender, email, username, password, sqq, answer);
                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        String m = null;
                        try {
                            DefaultResponse dr = response.body();

                           // if (response.code() == 201) {
                            if(response.isSuccessful()){

                                m = dr.getMsg();
                                Toast.makeText(regestration.this, m, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(regestration.this, login.class);
                                startActivity(intent);


                            } else {


                                m=response.errorBody().string();

                                try {
                                    JSONObject jsonObjson = new JSONObject(m);
                                    Toast.makeText(regestration.this, jsonObjson.getString("message"), Toast.LENGTH_SHORT).show(); //jsonObjson.getJSONObject("error").getString("message")

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        } catch (Exception e) {

                            e.printStackTrace();
                        }
                    }


                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                        Toast.makeText(regestration.this, t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });






             }


        });

        sq = findViewById(R.id.spinner_question);
        String[] questionsArray = getResources().getStringArray(R.array.questions_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  questionsArray);
        sq.setAdapter(adapter);
    }

    /**
     * you can call this function in order to get the selected question!
     *
     */
    public String getSelectedQuestion(){
        return sq.getSelectedItem().toString();
    }

}















