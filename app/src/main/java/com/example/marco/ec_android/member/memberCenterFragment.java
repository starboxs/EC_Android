package com.example.marco.ec_android.member;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marco.ec_android.R;
import com.example.marco.ec_android.adapter.memberAdapter;
import com.trello.rxlifecycle.components.RxFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class memberCenterFragment extends RxFragment implements memberAdapter.OnItemClickListener {
    public memberAdapter mMemberAdapter;
    RecyclerView mMemberCenterRecycleView;
    ArrayList mNewsList;
    private memberCenterFragment.OnFragmentInteractionListener listener;
    private FragmentManager mFragmentManager;

    public static memberCenterFragment newInstance() {
        return new memberCenterFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_member_center, container, false);
        ButterKnife.bind(this, v);
        mMemberCenterRecycleView = v.findViewById(R.id.memberRecyclerView);
        mMemberCenterRecycleView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mMemberAdapter = new memberAdapter(this.getActivity());
        mMemberAdapter.setOnItemClickListener(this);
        mNewsList = new ArrayList<>();
        mMemberCenterRecycleView.setAdapter(mMemberAdapter);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof memberCenterFragment.OnFragmentInteractionListener) {
            listener = (memberCenterFragment.OnFragmentInteractionListener) context;
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
