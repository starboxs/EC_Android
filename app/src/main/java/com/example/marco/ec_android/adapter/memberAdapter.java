package com.example.marco.ec_android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marco.ec_android.R;

import java.util.ArrayList;

public class memberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private memberAdapter.OnItemClickListener mOnItemClickListener;
    private memberAdapter.OnButtonClickListener mOnButtonClickListener;
    private ArrayList mNewsList = new ArrayList<>();
    private ArrayList mNewsDecList = new ArrayList<>();

    public memberAdapter(Context context) {
        this.mContext = context;
        mNewsList.add("重大消息1");
        mNewsList.add("重大消息2");
        mNewsList.add("重大消息3");
        mNewsDecList.add("內容1");
        mNewsDecList.add("內容2");
        mNewsDecList.add("內容3");
    }

    public void setOnItemClickListener(memberAdapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater v = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(v.inflate(R.layout.item_member_reserve, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
//        ((ViewHolder) viewHolder).newsTitle.setText(mNewsList.get(i).toString());
//        System.out.println("數字:" + i);
//        ((ViewHolder) viewHolder).newsDesc.setText(mNewsDecList.get(i).toString());
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
        public TextView memberTitle;
        public TextView memberItem;
        public TextView memberAddress;
        public TextView memberState;

        public ViewHolder(View v) {
            super(v);
//            memberTitle = v.findViewById(R.id.member_titile);
//            memberItem = v.findViewById(R.id.newsDesc);
//            memberAddress = v.findViewById(R.id.newsDesc);
//            memberState = v.findViewById(R.id.newsDesc);
        }
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
}

