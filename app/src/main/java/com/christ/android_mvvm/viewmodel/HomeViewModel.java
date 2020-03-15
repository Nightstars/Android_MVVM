package com.christ.android_mvvm.viewmodel;

import com.christ.android_mvvm.R;
import com.christ.android_mvvm.model.Feed;
import com.christ.android_mvvm.model.News;
import com.christ.android_mvvm.network.LoadListener;
import com.christ.android_mvvm.view.HomeActivity;

import java.util.List;

public class HomeViewModel {
    private static final String TAG = "HomeViewModel";
    private HomeActivity mActivity;
    private String feedUrl;

    public HomeViewModel(HomeActivity activity) {
        mActivity = activity;
    }

    public void loadNews() {
        // 获取url
        feedUrl = mActivity.getResources().getString(R.string.feed_api_url);
        // 加载数据
        Feed feed = new Feed();
        feed.loadData(feedUrl, new LoadListener<News>() {
            @Override
            public void loadSuccess(List<News> list) {
                // 加载数据成功
                mActivity.mNewsList.addAll(list);
                mActivity.mNewsAdapter.notifyDataSetChanged();
            }
            @Override
            public void loadFailure(String message) {
                // 加载数据失败
            }
        });
    }
}
