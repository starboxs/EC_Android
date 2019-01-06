package com.example.marco.ec_android.service;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.marco.ec_android.Conf;
import com.example.marco.ec_android.R;
import com.example.marco.ec_android.adapter.serviceAdapter;
import com.example.marco.ec_android.adapter.serviceViewPagerAdapter;
import com.example.marco.ec_android.api.models.Project;
import com.trello.rxlifecycle.components.RxFragment;

import java.util.ArrayList;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class mainServiceFragment extends RxFragment {

    private serviceViewPagerAdapter mPagerAdapter;
    ViewPager mViewPager;
    TabLayout mTabLayout;
    private FragmentManager mFragmentManager;
    private mainServiceFragment.OnFragmentInteractionListener listener;

    public static mainServiceFragment newInstance() {
        return new mainServiceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initViewPager() {
        mPagerAdapter = new serviceViewPagerAdapter(this.getActivity(), getFragmentManager(), "d");
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initTabLayout() {
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupTabIcons() {
        mTabLayout.getTabAt(0).setIcon(R.drawable.aa001);
        mTabLayout.getTabAt(1).setIcon(R.drawable.aa002);
        mTabLayout.getTabAt(2).setIcon(R.drawable.aa003);
        mTabLayout.getTabAt(3).setIcon(R.drawable.aa004);
        mTabLayout.getTabAt(4).setIcon(R.drawable.aa005);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab != null) tab.setCustomView(R.layout.tab_server_icon);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_service_clean_list, container, false);
        ButterKnife.bind(this, v);
         mViewPager = v.findViewById(R.id.view_pager);
         mTabLayout = v.findViewById(R.id.tab_layout);

        initViewPager();
        initTabLayout();
        setupTabIcons();

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

    public interface OnFragmentInteractionListener {
    }
}
