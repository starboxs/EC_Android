package com.example.marco.ec_android.member;

import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marco.ec_android.Conf;
import com.example.marco.ec_android.R;
import com.example.marco.ec_android.adapter.memberAdapter;
import com.example.marco.ec_android.api.Api;
import com.example.marco.ec_android.api.models.Project;
import com.example.marco.ec_android.api.models.User;
import com.example.marco.ec_android.api.responses.GetMyProjectsApiResponse;
import com.example.marco.ec_android.utils.CustomProgressDialog;
import com.trello.rxlifecycle.components.RxFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class memberCenterFragment extends RxFragment implements memberAdapter.OnItemClickListener {
    public memberAdapter mMemberAdapter;
    public TextView mTvname;
    public TextView mTvEmail;
    RecyclerView mMemberCenterRecycleView;
    ArrayList mNewsList;
    private memberCenterFragment.OnFragmentInteractionListener listener;
    private FragmentManager mFragmentManager;
    private CustomProgressDialog mProgressDialog;
    private ArrayList<Project> mDatas = new ArrayList<Project>();

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
        mProgressDialog = new CustomProgressDialog(getActivity());
        mTvname = v.findViewById(R.id.tvName);
        mTvEmail = v.findViewById(R.id.tvEmail);
        init();
        setData();
        return v;
    }


    private void setData() {
        User user = Conf.GetUser();
        mProgressDialog.show();
        Api.getInstance().getApiInterface().ProjectMyProjects(user.id)
                .compose(this.<GetMyProjectsApiResponse>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetMyProjectsApiResponse>() {
                    @Override
                    public void onCompleted() {
                        if (mProgressDialog != null && mProgressDialog.isShowing()) {
                            mProgressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mProgressDialog != null && mProgressDialog.isShowing()) {
                            mProgressDialog.dismiss();
                        }
                        DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        };
                        final AlertDialog.Builder builder = new AlertDialog.Builder(memberCenterFragment.this.getActivity(), R.style.dialog_theme);
                        builder.setTitle("系統訊息")
                                .setMessage("你沒連網路吧～")
                                .setNegativeButton("我去連", okListener)
                                .setCancelable(false)
                                .show();
                    }

                    @Override
                    public void onNext(GetMyProjectsApiResponse getMyProjectsApiResponse) {
                        handleGetData(getMyProjectsApiResponse);
                    }
                });
    }

    private void handleGetData(GetMyProjectsApiResponse getMyProjectsApiResponse) {
        mDatas = getMyProjectsApiResponse.datas;
        mMemberAdapter.setDatas(mDatas);
    }

    private void init() {
        User u = Conf.GetUser();
        mTvname.setText(u.name);
        mTvEmail.setText(u.email);
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
        Intent i = new Intent();
        i.setClass(memberCenterFragment.this.getActivity(), projectDetailActivity.class);
        i.putExtra("ProjectId", mDatas.get(position).pId);
        startActivity(i);
    }

    public interface OnFragmentInteractionListener {
    }
}
