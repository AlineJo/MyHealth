package com.example.myhealth.activities;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myhealth.R;
import com.example.myhealth.model.RetrofitClient;
import com.example.myhealth.model.SharedPrefManager;
import com.example.myhealth.model.DefaultResponse;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Resetpassword extends AppCompatActivity {

  private EditText editTextCurrentPassword, editTextNewPassword;
  private  Button reset;
  private RetrofitClient SharedPrefManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.reset_password);

    editTextCurrentPassword = findViewById(R.id.new1);
    editTextNewPassword = findViewById(R.id.new2);
    reset = findViewById(R.id.btnreset);
    reset.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String currentpassword = editTextCurrentPassword.getText().toString().trim();
        String newpassword = editTextNewPassword.getText().toString().trim();

        if (currentpassword.isEmpty()) {
          editTextCurrentPassword.setError("Password required");
          editTextCurrentPassword.requestFocus();
          return;
        }

        if (newpassword.isEmpty()) {
          editTextNewPassword.setError("Enter new password");
          editTextNewPassword.requestFocus();
          return;
        }


     //User user = SharedPrefManager.getInstance().getUser();
        //User user = new User();
 SharedPreferences user = getSharedPreferences("MySharedPref", MODE_PRIVATE);

// String s1 = user.getString("username","username");
//        Log.d("error", s1);

        Call<DefaultResponse> call = RetrofitClient.getInstance().getApi()
                .updatePassword(currentpassword, newpassword,new SharedPrefManager(Resetpassword.this).getUser().getUsername());//user.getUsername()

        call.enqueue(new Callback<DefaultResponse>() {
          @Override
          public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
            String m = null;
            try {
              DefaultResponse dr = response.body();

              if (response.isSuccessful()) {

                m = dr.getMsg();
                Toast.makeText(Resetpassword.this, m, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Resetpassword.this, login.class);
                startActivity(intent);


              } else {


                m=response.errorBody().string();

                try {
                  JSONObject jsonObjson = new JSONObject(m);
                  Toast.makeText(Resetpassword.this, jsonObjson.getString("message"), Toast.LENGTH_SHORT).show(); //jsonObjson.getJSONObject("error").getString("message")

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

          }
        });
      }
    });

  }



//  public void updatePassword() {
//    String ooldPass = currentpassword.getText().toString().trim();
//    String nnewpass = newpassword.getText().toString().trim();
//    return;
//
//    if (ooldPass.isEmpty()) {
//      currentpassword.setError("الرقم السري القديم مطلوب!");
//      currentpassword.requestFocus();
//      return;
//    }
//
//
//    if (nnewpass.isEmpty()) {
//      newpassword.setError("الرقم السري الجديد مطلوب!");
//      newpassword.requestFocus();
//      return;
//    }
//
//    User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();
//    Call<DefaultResponse> call = RetrofitClient.getInstance().getApi()
//            .updatePassword(ooldPass,nnewpass, user.getUsername());
//
//    call.enqueue(new Callback<DefaultResponse>() {
//      @Override
//      public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
//        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_LONG).show();
//      }
//
//      @Override
//      public void onFailure(Call<DefaultResponse> call, Throwable t) {

//      }
//
//
//    });
//}



}









