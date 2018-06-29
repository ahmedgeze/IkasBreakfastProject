package com.example.ahmetserdargeze.ikasbreakfastproject.retrofit;

/**
 * Created by ahmetserdargeze on 28.06.2018.
 */

public class ApiUtils {
    private ApiUtils(){}
    public static final String BASE_URL="http://api-dev.ikas.com/api/v1/";
    public static APIService getAPIService(){
        return RetrofitClient.getClientforLogin(BASE_URL).create(APIService.class);
    }

    public static APIService getAPIServicewithAuth(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }




}
