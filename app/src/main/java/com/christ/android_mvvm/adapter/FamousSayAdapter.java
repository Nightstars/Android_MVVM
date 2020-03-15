package com.christ.android_mvvm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.christ.android_mvvm.R;
import com.christ.android_mvvm.databinding.FamousSayItemBinding;
import com.christ.android_mvvm.model.Famoussay;
import com.christ.android_mvvm.view.ShowActivity;
import com.christ.android_mvvm.view.WebViewActivity;

import java.util.List;

public class FamousSayAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<Famoussay> famoussayList;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        FamousSayItemBinding famousSayItemBinding;

        public ViewHolder(FamousSayItemBinding famousSayItemBinding) {
            super(famousSayItemBinding.getRoot());
            this.famousSayItemBinding = famousSayItemBinding;
        }
    }

    public FamousSayAdapter(Context mContext, List<Famoussay> famoussayList) {
        this.mContext = mContext;
        this.famoussayList = famoussayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FamousSayItemBinding famousSayItemBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.famous_say_item,parent,false);
        return new ViewHolder(famousSayItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder=(ViewHolder)holder;
        // dataBinding绑定
        Famoussay famoussay=famoussayList.get(position);
        viewHolder.famousSayItemBinding.setFamoussay(famoussay);
        //设置点击事件
        viewHolder.famousSayItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String saying = famoussayList.get(position).getFamous_saying();
                String name = famoussayList.get(position).getFamous_name();
                Intent intent = new Intent(mContext, ShowActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("saying", saying);
                mContext.startActivity(intent);
            }
        });
        viewHolder.famousSayItemBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return famoussayList.size();
    }
}
