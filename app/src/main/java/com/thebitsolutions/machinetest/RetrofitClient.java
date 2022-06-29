package com.thebitsolutions.machinetest;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static String base_url="https://newsapi.org/";
    //2dc45faf2ea6412da19e5bbb9720e9a3
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;

    public RetrofitClient(){
        retrofit=new Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
    public static synchronized RetrofitClient getInstance(){
        if (retrofitClient==null){
            retrofitClient=new RetrofitClient();

        }
        return retrofitClient;
    }
    public ApiServices getApi(){
        return retrofit.create(ApiServices.class);
    }
  /*  Retrofit retrofit =new Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
*/

}


