package com.example.marco.ec_android;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.marco.ec_android.member.mainMemberFragment;
import com.example.marco.ec_android.member.memberCenterFragment;
import com.example.marco.ec_android.news.mainNewsFragment;
import com.example.marco.ec_android.service.mainServiceFragment;
import com.example.marco.ec_android.service.serviceInformationFragment;
import com.example.marco.ec_android.utils.CustomTabBaseActivity;
import com.trello.rxlifecycle.components.RxFragment;

public class MainActivity extends CustomTabBaseActivity implements mainNewsFragment.OnFragmentInteractionListener, mainServiceFragment.OnFragmentInteractionListener, mainMemberFragment.OnFragmentInteractionListener, serviceInformationFragment.OnFragmentInteractionListener, memberCenterFragment.OnFragmentInteractionListener {
    public static final String EXTRA_SELECT_PAGE = "EXTRA_SELECT_PAGE";
    public static final String EXTRA_OPEN_REGISTER_FLOW = "EXTRA_OPEN_REGISTER_FLOW";
    private FragmentManager mFragmentManager;
    private BottomNavigationView mBottomNavigationView;
    private int mSelectPage;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setInitData();
    }

    private void setInitData() {

        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleBottomNavigationItemSelected(item);
                return true;
            }
        });
        Intent intent = getIntent();

        if (intent != null) {
            mSelectPage = intent.getIntExtra(MainActivity.EXTRA_SELECT_PAGE, 0);
            Menu menu = mBottomNavigationView.getMenu();
            MenuItem item = menu.getItem(mSelectPage);
            updateNavigationBarState(item.getItemId());
            handleBottomNavigationItemSelected(item);
        }

    }

    private void updateNavigationBarState(int actionId) {
        Menu menu = mBottomNavigationView.getMenu();
        for (int i = 0, size = menu.size(); i < size; i++) {
            MenuItem item = menu.getItem(i);
            if (item.getItemId() == actionId)
                item.setChecked(true);
        }
    }

    private void handleBottomNavigationItemSelected(MenuItem item) {
        RxFragment fragment = null;
        RxFragment fragmentHide1 = null;
        RxFragment fragmentHide2 = null;
        switch (item.getItemId()) {
            case R.id.indexnews:
                if (mFragmentManager != null) {
                    fragment = (RxFragment) mFragmentManager.findFragmentByTag(mainNewsFragment.class.getSimpleName());
                    fragmentHide1 = (RxFragment) mFragmentManager.findFragmentByTag(mainServiceFragment.class.getSimpleName());
                    fragmentHide2 = (RxFragment) mFragmentManager.findFragmentByTag(mainMemberFragment.class.getSimpleName());

                }
                if (fragment == null)
                    fragment = mainNewsFragment.newInstance();
                break;
            case R.id.service:
                if (mFragmentManager != null) {
                    fragment = (RxFragment) mFragmentManager.findFragmentByTag(mainServiceFragment.class.getSimpleName());
                    fragmentHide1 = (RxFragment) mFragmentManager.findFragmentByTag(mainNewsFragment.class.getSimpleName());
                    fragmentHide2 = (RxFragment) mFragmentManager.findFragmentByTag(mainMemberFragment.class.getSimpleName());
                }
                if (fragment == null)
                    fragment = mainServiceFragment.newInstance();
                break;
            case R.id.member:
                if (mFragmentManager != null) {
                    fragment = (RxFragment) mFragmentManager.findFragmentByTag(mainMemberFragment.class.getSimpleName());
                    fragmentHide1 = (RxFragment) mFragmentManager.findFragmentByTag(mainServiceFragment.class.getSimpleName());
                    fragmentHide2 = (RxFragment) mFragmentManager.findFragmentByTag(mainNewsFragment.class.getSimpleName());
                }
                if (fragment == null)
                    fragment = mainMemberFragment.newInstance();
                break;
        }

        if (fragment != null && mFragmentManager != null) {

            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            if (!fragment.isAdded()) {
                fragmentTransaction.add(R.id.frame_layout, fragment, fragment.getClass().getSimpleName());
            }

            if (fragmentHide1 != null)
                fragmentTransaction.hide(fragmentHide1);
            if (fragmentHide2 != null)
                fragmentTransaction.hide(fragmentHide2);
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();


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
        }
    }
}
