package com.christ.android_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.christ.android_mvvm.R;
import com.christ.android_mvvm.adapter.FamousSayAdapter;
import com.christ.android_mvvm.databinding.ActivityFamousSayBinding;
import com.christ.android_mvvm.model.Famoussay;
import com.christ.android_mvvm.viewmodel.FamousSayViewModel;

import java.util.ArrayList;
import java.util.List;

public class FamousSayActivity extends AppCompatActivity {
    private ActivityFamousSayBinding activityFamousSayBinding;
    private FamousSayViewModel famousSayViewModel;
    public FamousSayAdapter famousSayAdapter;
    public List<Famoussay> famoussayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置dataBinding、viewModel
        activityFamousSayBinding= DataBindingUtil.setContentView(this,R.layout.activity_famous_say);
        famousSayViewModel=new FamousSayViewModel(this);
        activityFamousSayBinding.setFamousviewModel(famousSayViewModel);
        //初始化Recycle
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        activityFamousSayBinding.famousRecycleView.setLayoutManager(linearLayoutManager);
        famousSayAdapter=new FamousSayAdapter(this,famoussayList);
        activityFamousSayBinding.famousRecycleView.setAdapter(famousSayAdapter);
        famousSayViewModel.loadFamousSay();
    }
}
