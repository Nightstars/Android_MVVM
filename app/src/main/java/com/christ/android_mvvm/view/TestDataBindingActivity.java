package com.christ.android_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.christ.android_mvvm.R;
import com.christ.android_mvvm.databinding.ActivityTestDataBindingBinding;
import com.christ.android_mvvm.model.UserBean;

public class TestDataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestDataBindingBinding activityTestDataBindingBinding= DataBindingUtil.setContentView(this,R.layout.activity_test_data_binding);
        UserBean userBean=new UserBean();
        activityTestDataBindingBinding.setUser(userBean);
    }
}
