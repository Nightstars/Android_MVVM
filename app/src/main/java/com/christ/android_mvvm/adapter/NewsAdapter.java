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
import com.christ.android_mvvm.databinding.ItemNewsBinding;
import com.christ.android_mvvm.model.News;
import com.christ.android_mvvm.view.WebViewActivity;

import java.util.List;

public class NewsAdapter extends  RecyclerView.Adapter{
    private Context mContext;
    private List<News> newsList;
//    private OnItemClickListener mOnItemClickListener = null;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemNewsBinding mItemNewsBinding;

        public ViewHolder(ItemNewsBinding itemNewsBinding) {
            super(itemNewsBinding.getRoot());
            this.mItemNewsBinding = itemNewsBinding;
        }
    }

    public NewsAdapter(Context mContext, List<News> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemNewsBinding itemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_news, viewGroup, false);
        // View view = LayoutInflater.from(mContext).inflate(R.layout.item_news, viewGroup, false);
        return new ViewHolder(itemNewsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        ViewHolder mViewHolder = (ViewHolder) viewHolder;
        // dataBinding绑定
        News news = newsList.get(position);
        mViewHolder.mItemNewsBinding.setNews(news);
        // 设置点击事件，将接口方法回调给MainActivity
//        if (mOnItemClickListener != null) {
//            mViewHolder.mItemNewsBinding.getRoot().setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mOnItemClickListener.onShortClick(position);
//                }
//            });
//            mViewHolder.mItemNewsBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    mOnItemClickListener.onLongClick(position);
//                    return false;
//                }
//            });
//        }
        // 直接在adapter里设置点击事件
        mViewHolder.mItemNewsBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newsUrlPrefix = mContext.getResources().getString(R.string.news_url_prefix);
                String httpUrl = newsUrlPrefix + newsList.get(position).getItem_id();
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.putExtra("httpUrl", httpUrl);
                mContext.startActivity(intent);
            }
        });
        mViewHolder.mItemNewsBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    // 定义点击事件的接口
//    public interface OnItemClickListener {
//        void onShortClick(int position); // 单击
//        void onLongClick(int position); // 长按
//    }

//    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//        this.mOnItemClickListener = onItemClickListener;
//    }
}
