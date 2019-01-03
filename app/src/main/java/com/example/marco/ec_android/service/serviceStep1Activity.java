package com.example.marco.ec_android.service;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.marco.ec_android.R;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

public class serviceStep1Activity extends RxAppCompatActivity {
    public Button mBtnNext;
    public Toolbar mToolbar;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_service_price);
        ButterKnife.bind(this);
        mToolbar = this.findViewById(R.id.toolbar);

        initActionBar();
        mBtnNext = this.findViewById(R.id.btnNext);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(serviceStep1Activity.this, serviceStep2Activity.class);
                intent.putExtra("ServiceType", "1000");
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initActionBar() {
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
        }
    }

    private void initUI() {

    }
}

