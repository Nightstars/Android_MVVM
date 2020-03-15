package com.christ.android_mvvm.network;

import com.christ.android_mvvm.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface INews {
    @GET(".")
    Call<Feed> getFeed();
}
