package com.example.marco.ec_android.utils;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import com.example.marco.ec_android.R;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

public class CustomTabBaseActivity extends RxAppCompatActivity {
    private static final String TAG = CustomTabBaseActivity.class.getSimpleName();

    protected CustomTabActivityHelper mCustomTabActivityHelper;
    private CustomTabActivityHelper.ConnectionCallback mConnectionCallback = new CustomTabActivityHelper.ConnectionCallback() {
        @Override
        public void onCustomTabsConnected() {
        }

        @Override
        public void onCustomTabsDisconnected() {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupCustomTabHelper();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mCustomTabActivityHelper.bindCustomTabsService(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mCustomTabActivityHelper.unbindCustomTabsService(this);
    }

    protected void openCustomTab(CustomTabsIntent customTabsIntent, String url) {
        CustomTabActivityHelper.openCustomTab(this, customTabsIntent, Uri.parse(url), new WebviewFallback());
    }

    protected void openDefaultCustomTab(String url) {
        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
        intentBuilder.setToolbarColor(getResources().getColor(R.color.colorPrimary));
        intentBuilder.setShowTitle(true);
        openCustomTab(intentBuilder.build(), url);
    }

    private void setupCustomTabHelper() {
        mCustomTabActivityHelper = new CustomTabActivityHelper();
        mCustomTabActivityHelper.setConnectionCallback(mConnectionCallback);
    }
}
