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

public class serviceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private serviceAdapter.OnItemClickListener mOnItemClickListener;
    private serviceAdapter.OnButtonClickListener mOnButtonClickListener;
    private ArrayList mServiceList = new ArrayList<>();

    public serviceAdapter(Context context) {
        this.mContext = context;
        mServiceList.add("居家清潔");
        mServiceList.add("專業除蟎");
        mServiceList.add("水管淨化");
        mServiceList.add("冷氣機清洗");
        mServiceList.add("關於我們");
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater v = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(v.inflate(R.layout.item_service_clean, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        final Object item = mServiceList.get(i);
        ((serviceAdapter.ViewHolder) viewHolder).titleTextView.setText(item.toString());
        System.out.println("數字:" + i);
        switch (i) {
            case 0:
                ((ViewHolder) viewHolder).mImageView.setImageResource(R.drawable.img01);
                System.out.println("數字1:" + i);
                break;
            case 1:
                ((ViewHolder) viewHolder).mImageView.setImageResource(R.drawable.img02);
                System.out.println("數字2:" + i);
                break;
            case 2:
                ((ViewHolder) viewHolder).mImageView.setImageResource(R.drawable.img03);
                System.out.println("數字3:" + i);
                break;
            case 3:
                ((ViewHolder) viewHolder).mImageView.setImageResource(R.drawable.img04);
                System.out.println("數字4:" + i);
                break;
            case 4:
                ((ViewHolder) viewHolder).mImageView.setImageResource(R.drawable.img05);
                System.out.println("數字5:" + i);
                break;
        }


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
        public TextView titleTextView;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            mImageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return mServiceList.size();
    }
}
