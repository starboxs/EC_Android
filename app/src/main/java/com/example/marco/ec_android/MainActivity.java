package com.example.marco.ec_android;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MenuItem;

import com.example.marco.ec_android.member.memberMainFragment;
import com.example.marco.ec_android.news.newsMainFragment;
import com.example.marco.ec_android.reserve.reserveMainFragment;
import com.example.marco.ec_android.utils.CustomTabBaseActivity;
import com.trello.rxlifecycle.components.RxFragment;

public class MainActivity extends CustomTabBaseActivity {

    private FragmentManager mFragmentManager;
    private ActionBar mActionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void handleBottomNavigationItemSelected(MenuItem item) {
        RxFragment fragment = null;
        RxFragment fragmentHide1 = null;
        RxFragment fragmentHide2 = null;
        switch (item.getItemId()) {
            case R.id.indexnews:
                if (mFragmentManager != null) {
                    fragment = (RxFragment) mFragmentManager.findFragmentByTag(newsMainFragment.class.getSimpleName());
                    fragmentHide1 = (RxFragment) mFragmentManager.findFragmentByTag(reserveMainFragment.class.getSimpleName());
                    fragmentHide2 = (RxFragment) mFragmentManager.findFragmentByTag(memberMainFragment.class.getSimpleName());
                }
//                if (fragment == null)
//                    fragment = SearchMainFragment.newInstance();

//                if (mActionBar != null) {
//                    mActionBar.setTitle(R.string.title_project_list);
//                }
                break;
            case R.id.service:
                if (mFragmentManager != null) {
                    fragment = (RxFragment) mFragmentManager.findFragmentByTag(newsMainFragment.class.getSimpleName());
                    fragmentHide1 = (RxFragment) mFragmentManager.findFragmentByTag(reserveMainFragment.class.getSimpleName());
                    fragmentHide2 = (RxFragment) mFragmentManager.findFragmentByTag(memberMainFragment.class.getSimpleName());
                }

//                if (fragment == null)
//                    fragment = ProListMainFragment.newInstance();
                break;
            case R.id.member:
                if (mFragmentManager != null) {
                    fragment = (RxFragment) mFragmentManager.findFragmentByTag(newsMainFragment.class.getSimpleName());
                    fragmentHide1 = (RxFragment) mFragmentManager.findFragmentByTag(reserveMainFragment.class.getSimpleName());
                    fragmentHide2 = (RxFragment) mFragmentManager.findFragmentByTag(memberMainFragment.class.getSimpleName());
                }
//                if (fragment == null)
//                    fragment = CreateMainFragment.newInstance();
                break;
//                if (fragment == null)
//                    fragment = MyMainFragment.newInstance();
        }

        if (fragment != null && mFragmentManager != null) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            //fragmentTransaction.replace(R.id.frame_layout, fragment);
            if (!fragment.isAdded()) {
                fragmentTransaction.add(R.id.frame_layout, fragment, fragment.getClass().getSimpleName());
            }

            if (fragmentHide1 != null)
                fragmentTransaction.hide(fragmentHide1);
            if (fragmentHide2 != null)
                fragmentTransaction.hide(fragmentHide2);
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();
//            switch (item.getItemId()) {
//                case R.id.myItem:
//                    if (!TextUtils.isEmpty(mProjectId)) {
//                        Intent i = new Intent();
//                        i.setClass(MainActivity.this, ListActivity.class);
//                        i.putExtra(ConfirmActivity.CREATE_COMPLETE_PROJECT, mProjectId);
//                        mProjectId = "";
//                        startActivity(i);
//                    }
//                    break;
//            }
        } else {
            mFragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            if (!fragment.isAdded()) {
                fragmentTransaction.add(R.id.frame_layout, fragment, fragment.getClass().getSimpleName());
            }

            Fragment hideFragment = getFragmentManager().findFragmentById(R.id.frame_layout);
            if (hideFragment != null)
                fragmentTransaction.show(fragment).hide(hideFragment);

            fragmentTransaction.commit();
//            switch (item.getItemId()) {
//                case R.id.myItem:
//                    if (!TextUtils.isEmpty(mProjectId)) {
//                        Intent i = new Intent();
//                        i.setClass(MainActivity.this, ListActivity.class);
//                        i.putExtra(ConfirmActivity.CREATE_COMPLETE_PROJECT, mProjectId);
//                        mProjectId = "";
//                        startActivity(i);
//                    }
//                    break;
//            }
        }
    }

}
