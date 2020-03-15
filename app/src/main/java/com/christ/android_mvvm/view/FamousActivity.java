package com.christ.android_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.christ.android_mvvm.R;
import com.christ.android_mvvm.model.Famous;
import com.christ.android_mvvm.network.IFamous;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FamousActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous);
        request();
    }
    public void request(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.avatardata.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IFamous famous=retrofit.create(IFamous.class);
        Call<Famous> call=famous.getCall();
        call.enqueue(new Callback<Famous>() {
            @Override
            public void onResponse(Call<Famous> call, Response<Famous> response) {
                TextView famous_name=(TextView)findViewById(R.id.famous_name);
                TextView famous_say=(TextView)findViewById(R.id.famous_say);
                famous_name.setText(response.body().getResult().get(0).getFamous_name());
                famous_say.setText(response.body().getResult().get(0).getFamous_saying());
            }

            @Override
            public void onFailure(Call<Famous> call, Throwable t) {
                TextView famous_name=(TextView)findViewById(R.id.famous_name);
                famous_name.setText("请求失败");

            }
        });
    }
}
