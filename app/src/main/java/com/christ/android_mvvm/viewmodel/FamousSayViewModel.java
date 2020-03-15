package com.christ.android_mvvm.viewmodel;

import com.christ.android_mvvm.R;
import com.christ.android_mvvm.model.Famous;
import com.christ.android_mvvm.model.FamousSays;
import com.christ.android_mvvm.model.Famoussay;
import com.christ.android_mvvm.network.ILoadListener;
import com.christ.android_mvvm.view.FamousSayActivity;

import java.util.List;

public class FamousSayViewModel {
    private FamousSayActivity famousSayActivity;
    private String baseUrl;

    public FamousSayViewModel(FamousSayActivity famousSayActivity) {
        this.famousSayActivity = famousSayActivity;
    }
    public void loadFamousSay() {
        // 获取url
        baseUrl = famousSayActivity.getResources().getString(R.string.famous_api_url);
        // 加载数据
        FamousSays famousSays = new FamousSays();
        famousSays.loadData(baseUrl, new ILoadListener<Famoussay>() {
            @Override
            public void loadSuccess(List<Famoussay> list) {
                // 加载数据成功
                famousSayActivity.famoussayList.addAll(list);
                famousSayActivity.famousSayAdapter.notifyDataSetChanged();
            }
            @Override
            public void loadFailure(String message) {
                // 加载数据失败
            }
        });
    }
}
