package com.example.marco.ec_android.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.marco.ec_android.R;
import com.trello.rxlifecycle.components.RxFragment;

import butterknife.ButterKnife;

public class serviceInformationFragment extends RxFragment {

    public Button mNewsReserviceBtn;
    private serviceInformationFragment.OnFragmentInteractionListener listener;

    public static serviceInformationFragment newInstance() {
        return new serviceInformationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_service_information, container, false);
        ButterKnife.bind(this, v);
        mNewsReserviceBtn = v.findViewById(R.id.news_reservice);
        mNewsReserviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(serviceInformationFragment.this.getActivity(), serviceStep1Activity.class);
                startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof serviceInformationFragment.OnFragmentInteractionListener) {
            listener = (serviceInformationFragment.OnFragmentInteractionListener) context;
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

    public interface OnFragmentInteractionListener {
    }
}
