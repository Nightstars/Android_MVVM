package com.christ.android_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.christ.android_mvvm.R;
import com.christ.android_mvvm.databinding.ActivityShowBinding;
import com.christ.android_mvvm.model.Famoussay;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityShowBinding activityShowBinding= DataBindingUtil.setContentView(this,R.layout.activity_show);
        Famoussay famoussay=new Famoussay();
        Intent intent=getIntent();
        famoussay.setFamous_name(intent.getStringExtra("name"));
        famoussay.setFamous_saying(intent.getStringExtra("saying"));
        activityShowBinding.setFamous(famoussay);
    }
}
