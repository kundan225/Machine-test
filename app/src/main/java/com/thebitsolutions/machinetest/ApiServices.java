package com.thebitsolutions.machinetest;

import com.thebitsolutions.machinetest.models.Root;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("v2/top-headlines?country=us&category=business&apiKey=2dc45faf2ea6412da19e5bbb9720e9a3")
    Call<Root>getModel();
}
