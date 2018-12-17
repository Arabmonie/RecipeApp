package com.droidplate.recipeapp.api;

import com.droidplate.recipeapp.Pojo.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static final String BASE_URL = "https://raw.githubusercontent.com";
    public static Retrofit retrofit = null;

    public static Retrofit getclient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();




        }
        return retrofit;

    }

}
