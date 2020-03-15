package com.christ.android_mvvm.network;

import com.christ.android_mvvm.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUser {
    @POST("hello")
    Call<User> getCall();
}
