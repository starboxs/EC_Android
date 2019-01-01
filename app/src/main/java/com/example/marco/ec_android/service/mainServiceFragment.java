package com.example.marco.ec_android.service;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marco.ec_android.R;
import com.example.marco.ec_android.adapter.serviceAdapter;
import com.trello.rxlifecycle.components.RxFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class mainServiceFragment extends RxFragment implements serviceAdapter.OnItemClickListener {

    private mainServiceFragment.OnFragmentInteractionListener listener;
    public serviceAdapter mServiceAdapter;
    RecyclerView mServiceRecyclerView;
    ArrayList mServiceList;
    public static mainServiceFragment newInstance() {
        return new mainServiceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_service_clean_list, container, false);
        ButterKnife.bind(this, v);
        mServiceRecyclerView = (RecyclerView) v.findViewById(R.id.serviceRecyclerView);
        mServiceRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mServiceAdapter = new serviceAdapter(this.getActivity());
        mServiceAdapter.setOnItemClickListener(this);
        mServiceList = new ArrayList<>();
        mServiceRecyclerView.setAdapter(mServiceAdapter);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof mainServiceFragment.OnFragmentInteractionListener) {
            listener = (mainServiceFragment.OnFragmentInteractionListener) context;
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
