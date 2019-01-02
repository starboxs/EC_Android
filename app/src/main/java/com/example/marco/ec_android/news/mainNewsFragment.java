package com.example.marco.ec_android.news;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.marco.ec_android.adapter.newsAdapter;
import com.example.marco.ec_android.adapter.serviceAdapter;
import com.example.marco.ec_android.service.serviceInformationFragment;
import com.example.marco.ec_android.R;
import com.trello.rxlifecycle.components.RxFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class mainNewsFragment extends RxFragment implements newsAdapter.OnItemClickListener {

    TextView service01;
    TextView service02;
    TextView service03;
    TextView service04;
    TextView service05;
    ScrollView mScrollView;
    RecyclerView mNewsRecycleView;
    private FragmentManager mFragmentManager;
    public newsAdapter mNewsAdapter;
    ArrayList mNewsList;

    private OnFragmentInteractionListener listener;

    public static mainNewsFragment newInstance() {
        return new mainNewsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_index, container, false);
        ButterKnife.bind(this, v);
        mScrollView = (ScrollView) v.findViewById(R.id.indexScrollview);
        service01 = (TextView) v.findViewById(R.id.service01);
        service02 = (TextView) v.findViewById(R.id.service02);
        service03 = (TextView) v.findViewById(R.id.service03);
        service04 = (TextView) v.findViewById(R.id.service04);
        service05 = (TextView) v.findViewById(R.id.service05);
        mNewsRecycleView = (RecyclerView) v.findViewById(R.id.newRecycleView);
        mNewsRecycleView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mNewsAdapter = new newsAdapter(this.getActivity());
        mNewsAdapter.setOnItemClickListener(this);
        mNewsList = new ArrayList<>();
        mNewsRecycleView.setAdapter(mNewsAdapter);
        service01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxFragment fragment = null;
                fragment = serviceInformationFragment.newInstance();
                fragmentChack(fragment);
            }
        });
        service02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxFragment fragment = null;
                fragment = serviceInformationFragment.newInstance();
                fragmentChack(fragment);
            }
        });
        service03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxFragment fragment = null;
                fragment = serviceInformationFragment.newInstance();
                fragmentChack(fragment);
            }
        });
        service04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxFragment fragment = null;
                fragment = serviceInformationFragment.newInstance();
                fragmentChack(fragment);
            }
        });
        service05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxFragment fragment = null;
                fragment = serviceInformationFragment.newInstance();
                fragmentChack(fragment);
            }
        });
        mScrollView.smoothScrollBy(0,20);
        return v;
    }

    private void fragmentChack(RxFragment fragment) {
        if (fragment != null && mFragmentManager != null) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
        } else {
            mFragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, serviceInformationFragment.newInstance());
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onItemClick(int position) {

    }

    public interface OnFragmentInteractionListener {
    }
}

