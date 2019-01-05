package com.example.marco.ec_android.service;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.marco.ec_android.Conf;
import com.example.marco.ec_android.R;
import com.example.marco.ec_android.api.models.Project;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

public class serviceStep1Activity extends RxAppCompatActivity {
    public Button mBtnNext;
    public Toolbar mToolbar;
    public TextView mTxtTitle;
    public EditText mEdTextUnit;
    private ActionBar mActionBar;
    private TextView mTxtDesc;
    private TextView mTxtUnitTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_service_price);
        ButterKnife.bind(this);
        mToolbar = this.findViewById(R.id.toolbar);
        initActionBar();
        mEdTextUnit = this.findViewById(R.id.editText);
        mTxtTitle = this.findViewById(R.id.textView5);
        mBtnNext = this.findViewById(R.id.btnNext);
        mTxtDesc = this.findViewById(R.id.textView6);
        mTxtUnitTitle = this.findViewById(R.id.textView7);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(serviceStep1Activity.this, serviceStep2Activity.class);
                Project p = Conf.GetProject();
                p.unit = mEdTextUnit.getText().toString();
                Conf.setProject(p);
                startActivity(intent);
            }
        });

        initUI();

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
        Project p = Conf.GetProject();
        if (p.serviceType.contentEquals("1000")) {
            mTxtTitle.setText("居家清潔收費：$1,800元 / 4小時");
            mTxtDesc.setVisibility(View.VISIBLE);
            mTxtUnitTitle.setText("服務管家人數");
            mEdTextUnit.setHint("請輸入人數");
        } else {
            mTxtTitle.setText("專業除蟎收費：$988元 / 間");
            mTxtDesc.setVisibility(View.GONE);
            mTxtUnitTitle.setText("除蟎房間數量");
            mEdTextUnit.setHint("請輸入房間數");
        }

    }
}

