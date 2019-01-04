package com.example.marco.ec_android.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,final int i) {
        final Object item = mServiceList.get(i);
        ((serviceAdapter.ViewHolder) viewHolder).titleTextView.setText(item.toString());
        switch (i) {
            case 0:
                ((ViewHolder) viewHolder).mServiceLinear.setBackgroundColor(Color.parseColor("#009100"));
                break;
            case 1:
                ((ViewHolder) viewHolder).mServiceLinear.setBackgroundColor(Color.parseColor("#ff8000"));
                break;
            case 2:
                ((ViewHolder) viewHolder).mServiceLinear.setBackgroundColor(Color.parseColor("#4f9d9d"));
                break;
            case 3:
                ((ViewHolder) viewHolder).mServiceLinear.setBackgroundColor(Color.parseColor("#b766ad"));
                break;
            case 4:
                ((ViewHolder) viewHolder).mServiceLinear.setBackgroundColor(Color.parseColor("#ff359a"));
                break;
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(i);
                }
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(final int position);
    }



    public interface OnButtonClickListener {
        void onButtonClick(final int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public LinearLayout mServiceLinear;

        public ViewHolder(View v) {
            super(v);
            titleTextView =  v.findViewById(R.id.titleTextView);
            mServiceLinear = v.findViewById(R.id.serviceLinearLayout);
        }
    }

    @Override
    public int getItemCount() {
        return mServiceList.size();
    }
}
