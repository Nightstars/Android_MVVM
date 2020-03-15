package com.christ.android_mvvm.model;

import com.christ.android_mvvm.network.IFamousSay;
import com.christ.android_mvvm.network.ILoadListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FamousSays {
    private String total;
    private List<Famoussay> result;
    private String error_code;
    private String reason;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Famoussay> getResult() {
        return result;
    }

    public void setResult(List<Famoussay> result) {
        this.result = result;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    // 通过传进来的url，利用retrofit获取网络数据，回调给viewModel
    public void loadData(String baseUrl, final ILoadListener<Famoussay> loadListener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IFamousSay iFamousSay = retrofit.create(IFamousSay.class);
        Call<FamousSays> famousSay = iFamousSay.getFamousSay();
        famousSay.enqueue(new Callback<FamousSays>() {
            @Override
            public void onResponse(Call<FamousSays> call, Response<FamousSays> response) {
                // 获取成功
                List<Famoussay> famoussayList = new ArrayList<>();
                for (int i = 0; i < response.body().getResult().size(); i++) {
                    famoussayList.add(response.body().getResult().get(i));
                }
                loadListener.loadSuccess(famoussayList);
            }

            @Override
            public void onFailure(Call<FamousSays> call, Throwable t) {
                // 获取失败
                loadListener.loadFailure(t.getMessage());
            }
        });
    }
}
