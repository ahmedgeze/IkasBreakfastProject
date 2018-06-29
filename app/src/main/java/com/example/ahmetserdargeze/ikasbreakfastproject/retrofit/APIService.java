package com.example.ahmetserdargeze.ikasbreakfastproject.retrofit;

import com.example.ahmetserdargeze.ikasbreakfastproject.model.login.Token;
import com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Menu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by ahmetserdargeze on 28.06.2018.
 */

public interface APIService {

    @POST("auth/login/")
    @FormUrlEncoded
    Call<Token> login(
            @Field("email") String email,
//            @Field("First name") String first_name,
//            @Field("Last name") String  last_name,
            @Field("password") String password
//            @Field("User type") String user_type
    );

    @GET("app/branch/19/products/")
    Call<List<Menu>> getMenu();










}
