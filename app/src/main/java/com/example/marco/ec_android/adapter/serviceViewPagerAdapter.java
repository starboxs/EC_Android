package com.example.marco.ec_android.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.marco.ec_android.service.serviceInformationFragment;

public class serviceViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 5;
    private Context mContext;
    private String data = "";

    public serviceViewPagerAdapter(Context context, FragmentManager supportFragmentManager , String data) {
        super(supportFragmentManager);
        mContext = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public Fragment getItem(int i) {
        serviceInformationFragment fragment = serviceInformationFragment.newInstance();
        Bundle bundle = new Bundle();
        switch (i) {
            case 0: {
                bundle.putInt("data" , 1000);
                fragment.setArguments(bundle);
                return fragment;
            }
            case 1: {
                bundle.putInt("data" , 1001);
                fragment.setArguments(bundle);
                return fragment;
            }
            case 2: {
                bundle.putInt("data" , 1002);
                fragment.setArguments(bundle);
                return fragment;
            }
            case 3: {
                bundle.putInt("data" , 1003);
                fragment.setArguments(bundle);
                return fragment;
            }
            case 4: {
                bundle.putInt("data" , 1004);
                fragment.setArguments(bundle);
                return fragment;
            }
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: {
                return "";
            }
            case 1: {
                return "";
            }
            case 2: {
                return "";
            }
            case 3: {
                return "";
            }
            case 4: {
                return "";
            }
            default:
                return null;
        }
    }


}