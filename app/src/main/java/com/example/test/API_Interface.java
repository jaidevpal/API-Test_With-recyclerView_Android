package com.example.test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Interface {

    @GET("/photos")
    Call<List<photos>> getPhotos();

}
