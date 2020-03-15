package com.christ.android_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.christ.android_mvvm.R;
import com.christ.android_mvvm.databinding.ActivityHomeBinding;
import com.christ.android_mvvm.model.News;
import com.christ.android_mvvm.adapter.NewsAdapter;
import com.christ.android_mvvm.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public ActivityHomeBinding mActivityMainBinding;
    private HomeViewModel mViewModel;

    public NewsAdapter mNewsAdapter;
    public List<News> mNewsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置dataBinding、viewModel
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new HomeViewModel(this);
        mActivityMainBinding.setViewModel(mViewModel);
        // 初始化RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mActivityMainBinding.recyclerView.setLayoutManager(layoutManager);
        mNewsAdapter = new NewsAdapter(this, mNewsList);
        mActivityMainBinding.recyclerView.setAdapter(mNewsAdapter);
        // 加载数据
        mViewModel.loadNews();
    }
}
