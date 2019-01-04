package com.example.marco.ec_android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marco.ec_android.R;
import com.example.marco.ec_android.api.models.Project;

import java.util.ArrayList;

public class memberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private memberAdapter.OnItemClickListener mOnItemClickListener;
    private memberAdapter.OnButtonClickListener mOnButtonClickListener;
    private ArrayList<Project> mdata = new ArrayList<Project>();

    public memberAdapter(Context context) {
        this.mContext = context;

    }

    public synchronized void setDatas(ArrayList<Project> datas) {
        mdata.clear();
        mdata.addAll(datas);
        notifyDataSetChanged();
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
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        Project p = mdata.get(i);
        ((ViewHolder) viewHolder).tvDesc.setText(p.pDesc);
        ((ViewHolder) viewHolder).tvServiceTypeName.setText(p.serviceTypeName);
        ((ViewHolder) viewHolder).tvStatusName.setText(p.statusName);
        ((ViewHolder) viewHolder).tvUserAddress.setText(p.userAddress);
        if (p.serviceType.equals("1000")) {
            ((ViewHolder) viewHolder).ivServiceTypePhoto.setImageResource(R.mipmap.a001);
        } else if (p.serviceType.equals("1001")) {
            ((ViewHolder) viewHolder).ivServiceTypePhoto.setImageResource(R.mipmap.a002);
        } else if (p.serviceType.equals("1002")) {
            ((ViewHolder) viewHolder).ivServiceTypePhoto.setImageResource(R.mipmap.a003);
        } else if (p.serviceType.equals("1002")) {
            ((ViewHolder) viewHolder).ivServiceTypePhoto.setImageResource(R.mipmap.a004);
        } else {
            ((ViewHolder) viewHolder).ivServiceTypePhoto.setImageResource(R.mipmap.a005);
        }

        ((ViewHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
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
        return mdata.size();
    }

    public interface OnItemClickListener {
        void onItemClick(final int position);
    }

    public interface OnButtonClickListener {
        void onButtonClick(final int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvUserAddress;
        public TextView tvDesc;
        public TextView tvStatusName;
        public TextView tvServiceTypeName;
        public ImageView ivServiceTypePhoto;

        public ViewHolder(View v) {
            super(v);
            tvUserAddress = v.findViewById(R.id.tvUserAddress);
            tvDesc = v.findViewById(R.id.tvDesc);
            tvStatusName = v.findViewById(R.id.tvStatusName);
            tvServiceTypeName = v.findViewById(R.id.tvServiceTypeName);
            ivServiceTypePhoto = v.findViewById(R.id.serverImageView);
        }
    }
}

