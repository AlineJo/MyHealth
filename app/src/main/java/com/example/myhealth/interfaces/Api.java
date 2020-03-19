package com.example.myhealth.interfaces;

import com.example.myhealth.model.DefaultResponse;
import com.example.myhealth.model.EmailResponse;
import com.example.myhealth.model.LoginResponse;
import com.example.myhealth.model.UsersResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {


    @FormUrlEncoded
    @POST("createuser")
    Call<DefaultResponse> createUser(
            @Field("name") String name,
            @Field("age") String age,
            @Field("gender") String gender,
            @Field("email") String email,
            @Field("username") String username,
            @Field("password") String password,
            @Field("sq") String sq,
            @Field("answer") String answer
    );

    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginResponse> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("allusers")
    Call<UsersResponse> getUsers();

    @FormUrlEncoded
    @PUT("updateuser/{id}")
    Call<LoginResponse> updateUser(
            @Path("id") int id,
            @Field("name") String name,
            @Field("age") String age,
            @Field("gender") String gender,
            @Field("email") String email,
            @Field("username") String username,
            @Field("password") String password,
            @Field("sq") String sq,
            @Field("answer") String answer
    );

    @FormUrlEncoded
    @PUT("updatepassword")
    Call<DefaultResponse> updatePassword(
            @Field("currentpassword") String currentpassword,
            @Field("newpassword") String newpassword,
            @Field("username") String username
    );


    @DELETE("deleteuser/{id}")
    Call<DefaultResponse> deleteUser(@Path("id") int id);





    @FormUrlEncoded
    @POST("userVerify")
    Call<EmailResponse> userVerify(
            @Field("email")String eemail
    );

}
