package com.example.marco.ec_android;

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
    private String mOpenRegisterFlow;

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
            mOpenRegisterFlow = intent.getStringExtra(MainActivity.EXTRA_OPEN_REGISTER_FLOW);
            Menu menu = mBottomNavigationView.getMenu();
            MenuItem item = menu.getItem(mSelectPage);
            updateNavigationBarState(item.getItemId());
            handleBottomNavigationItemSelected(item);
        }
//        if (!TextUtils.isEmpty(mOpenRegisterFlow)) {
//            Intent i = new Intent(MainActivity.this, main.class);
//            startActivity(i);
//        }
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
        switch (item.getItemId()) {
            case R.id.indexnews:
                if (mFragmentManager != null) {
                    fragment = (RxFragment) mFragmentManager.findFragmentByTag(mainNewsFragment.class.getSimpleName());
                }
                if (fragment == null)
                    fragment = mainNewsFragment.newInstance();
                break;
            case R.id.service:
                if (mFragmentManager != null) {
                    fragment = (RxFragment) mFragmentManager.findFragmentByTag(mainNewsFragment.class.getSimpleName());
                }
                if (fragment == null)
                    fragment = mainServiceFragment.newInstance();
                break;
            case R.id.member:
                if (mFragmentManager != null) {
                    fragment = (RxFragment) mFragmentManager.findFragmentByTag(mainNewsFragment.class.getSimpleName());
                }
                if (fragment == null)
                    fragment = mainMemberFragment.newInstance();
                break;
        }

        if (fragment != null && mFragmentManager != null) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
        } else {
            mFragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, mainNewsFragment.newInstance());
            fragmentTransaction.commit();
        }
    }
}
