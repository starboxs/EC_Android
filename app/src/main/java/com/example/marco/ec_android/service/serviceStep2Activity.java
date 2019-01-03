package com.example.marco.ec_android.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.marco.ec_android.R;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

public class serviceStep2Activity extends RxAppCompatActivity {
    public Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_information);
        ButterKnife.bind(this);
        initActionBar();
        mBtnNext = this.findViewById(R.id.btnNext);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(serviceStep2Activity.this, serviceStep3Activity.class);
                intent.putExtra("ServiceType", "1000");
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                //追蹤
//                ActionUtils.ActionAnalyticsBack(this, 0, getResources().getString(R.string.analytics_register_verify));
//
//                finish();
//                return true;
//        default:
        return super.onOptionsItemSelected(item);
//        }
    }

    private void initActionBar() {
//        setSupportActionBar(mToolbar);
//        mActionBar = getSupportActionBar();
//        if (mActionBar != null) {
//            mActionBar.setDisplayHomeAsUpEnabled(true);
//            mActionBar.setHomeButtonEnabled(true);
//        }
    }

    private void initUI() {

    }
}
