package com.christ.android_mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.christ.android_mvvm.model.Fruit;
import com.christ.android_mvvm.view.FamousActivity;
import com.christ.android_mvvm.view.FamousSayActivity;
import com.christ.android_mvvm.view.FruitActivity;
import com.christ.android_mvvm.view.GetRequestActivity;
import com.christ.android_mvvm.view.HomeActivity;
import com.christ.android_mvvm.view.PostRequestActivity;
import com.christ.android_mvvm.view.SpringBootActivity;
import com.christ.android_mvvm.view.TestDataBindingActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.start_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this, FamousSayActivity.class);
                startActivity(intent);
            }
        });
    }
}
