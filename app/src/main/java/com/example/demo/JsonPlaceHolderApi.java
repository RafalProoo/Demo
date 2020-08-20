package com.example.demo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @FormUrlEncoded
    @POST("/users/registration")
    Call<User> registerUser(@Field("name") String name,
                                    @Field("surname") String surname,
                                    @Field("email") String email,
                                    @Field("password") String password);
}
