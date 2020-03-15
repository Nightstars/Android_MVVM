package com.christ.android_mvvm.network;

import com.christ.android_mvvm.model.Famous;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IFamous {
    @GET("MingRenMingYan/LookUp?key=7b190361b6814f27a930ac5c27cdcad4&keyword=天才&page=1&rows=1")
    Call<Famous> getCall();
}
