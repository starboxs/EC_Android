package com.example.marco.ec_android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        mNewsList.add("大掃除預約最後倒數~讓您乾淨歡喜迎接新年");
        mNewsList.add("專業除塵螨送除窗簾一組");
        mNewsList.add("直立式洗衣機清洗特價中");
        mNewsDecList.add("清潔時間：2018/12/26~2019/02/01\n" +
                "大掃除預約最後倒數！加價專業除塵螨，最高89折!錯過等明年!\n");
        mNewsDecList.add("活動時間：2019/01/10~2019/01/20\n" +
                "除塵螨動作不可少，專業清潔人員施作，除螨效果親眼可見。\n");
        mNewsDecList.add("特價期間：2019/01/21~2019/01/31\n" +
                "洗衣機內槽比馬桶還要髒530倍！為了家人的健康，預約洗衣機清洗現折300元！(限直立式洗衣機無烘衣功能)\n");
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
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        ((ViewHolder) viewHolder).newsTitle.setText(mNewsList.get(i).toString());
        ((ViewHolder) viewHolder).newsDesc.setText(mNewsDecList.get(i).toString());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
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
}

