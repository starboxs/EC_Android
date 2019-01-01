package com.example.marco.ec_android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marco.ec_android.R;

import java.util.ArrayList;

public class newsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private newsAdapter.OnItemClickListener mOnItemClickListener;
    private newsAdapter.OnButtonClickListener mOnButtonClickListener;
    private ArrayList mNewsList = new ArrayList<>();
    private ArrayList mNewsDecList = new ArrayList<>();

    public newsAdapter(Context context) {
        this.mContext = context;
        mNewsList.add("重大消息1");
        mNewsList.add("重大消息2");
        mNewsList.add("重大消息3");
        mNewsDecList.add("內容1");
        mNewsDecList.add("內容2");
        mNewsDecList.add("內容3");
    }

    public void setOnItemClickListener(newsAdapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater v = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(v.inflate(R.layout.item_news, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder) viewHolder).newsTitle.setText(mNewsList.get(i).toString());
        System.out.println("數字:" + i);
        ((ViewHolder) viewHolder).newsDesc.setText(mNewsDecList.get(i).toString());
    }

    public interface OnItemClickListener {
        void onItemClick(final int position);
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public interface OnButtonClickListener {
        void onButtonClick(final int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView newsTitle;
        public TextView newsDesc;

        public ViewHolder(View v) {
            super(v);
            newsTitle = v.findViewById(R.id.newsTitle);
            newsDesc = v.findViewById(R.id.newsDesc);
        }
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
}

