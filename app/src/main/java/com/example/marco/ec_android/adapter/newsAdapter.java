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
        mNewsList.add("購買二手屋，請問這裂縫有危險嗎？");
        mNewsList.add("小家庭客廳坪數不大的沙發選擇?");
        mNewsList.add("寢之堡防螨床包材質的差別？");
        mNewsDecList.add("早年有很多房子都是建物完成後 ，地方政府驗過後 ，再做整體的二次施工把陽台外推或頂樓加蓋");
        mNewsDecList.add("主要是變化性很多，除了一般的雙、三人座沙發還可以組成小L型的，外面比較少見到所以看到時挺驚豔的");
        mNewsDecList.add("店員推薦竹纖維材質比較天然，睡起來也很舒服");
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

