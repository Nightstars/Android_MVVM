package com.christ.android_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.christ.android_mvvm.R;
import com.christ.android_mvvm.model.User;
import com.christ.android_mvvm.network.IUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpringBootActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_boot);
        textView=(TextView)findViewById(R.id.spring_boot_show);
        request();
    }
    public void request() {
        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://unknowsite.site:8080/api/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();
        // 步骤5:创建 网络请求接口 的实例
        IUser request = retrofit.create(IUser.class);
        //对 发送请求 进行封装
        Call<User> call = request.getCall();
        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<User>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // 步骤7：处理返回的数据结果
                textView.setText(response.body().show());
            }
            //请求失败时回调
            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                textView.setText("连接失败");
            }
        });
    }
}
