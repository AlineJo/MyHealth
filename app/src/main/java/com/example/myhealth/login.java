package com.example.myhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername, editTextPassword;
   // private Button btnl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editTextUsername = findViewById(R.id.user);
        editTextPassword = findViewById(R.id.password);

        findViewById(R.id.btnl).setOnClickListener(this);
        findViewById(R.id.viewRegister).setOnClickListener(this);
        findViewById(R.id.viewReset).setOnClickListener(this);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
//            Intent intent = new Intent(this, Resetpassword.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//        }
//    }
    public void validate (String username, String password){
        if((username=="admin") && (password=="admin123")){
            openAdmin();

        }

    }

    private void openAdmin() {
        Intent intent = new Intent(login.this, Admin.class);
        startActivity(intent);
    }


    private void userLogin() {

        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();




        if (username.isEmpty()) {
            editTextUsername.setError("الاسم المستخدم مطلوب!");
            editTextUsername.requestFocus();
            return;
        }

        if (Patterns.DOMAIN_NAME.matcher(username).matches()) {
            editTextUsername.setError("ادخل اسم مستخدم صالح");
            editTextUsername.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("الرقم السري مطلوب!");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("يجب ان يكون الرقم السري مكون من 6 احرف على الاقل");
            editTextPassword.requestFocus();
            return;
        }

        Call<LoginResponse> call = RetrofitClient
                .getInstance().getApi().userLogin(username, password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (!loginResponse.isError()) {

                    SharedPrefManager.getInstance(login.this)
                            .saveUser(loginResponse.getUser());


                    Toast.makeText(login.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(login.this, LifestyleActivity.class);
                    startActivity(intent);



                } else {
                    Toast.makeText(login.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnl:
                userLogin();
                break;

            case R.id.viewRegister:
                startActivity(new Intent(this, regestration.class));
                break;

            case R.id.viewReset:
                startActivity(new Intent(this, SecurityOfPasswordActivity.class));
                break;

            default : Toast.makeText(login.this,"error", Toast.LENGTH_LONG).show();
                return;



        }
    }
}



