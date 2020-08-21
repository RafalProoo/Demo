package com.example.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;
        button = findViewById(R.id.button);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.26.100.36:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Działa POST
//                Call<UserDto> call = jsonPlaceHolderApi.createUser(new UserDto("Ala", "Kot", "alakot", "qweewq"));
//                call.enqueue(new Callback<UserDto>() {
//                    @Override
//                    public void onResponse(Call<UserDto> call, Response<UserDto> response) {
//                        if(!response.isSuccessful()){
//                            System.out.println(response.code());
//                            return;
//                        }
//                        UserDto userDto = response.body();
//                        System.out.println(response.code());
//                        System.out.println(userDto);
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<UserDto> call, Throwable t) {
//                        System.out.println(t);
//                    }
//                });

                //Działa GET
                Call<List<User>> call = jsonPlaceHolderApi.getUsers();
                call.enqueue(new Callback<List<User>>() {

                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if (!response.isSuccessful()) {
                            System.out.println(response.code());
                            return;
                        }
                        List<User> post = response.body();
                        ArrayList<User> tmp = new ArrayList<User>(post);
                        System.out.println(tmp);
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        System.out.println(t);
                    }
                });

            }
        });

    }
}