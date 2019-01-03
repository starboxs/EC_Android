package com.example.marco.ec_android.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.marco.ec_android.Conf;
import com.example.marco.ec_android.R;
import com.example.marco.ec_android.api.models.Project;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

public class serviceStep3Activity extends RxAppCompatActivity {
    public Button mBtnNext;
    public RadioGroup mRgInvoiceType;
    public String mInvoiceType;
    public Toolbar mToolbar;
    public TextView mTvDesc;
    public TextView mTvAmount;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_quote);
        ButterKnife.bind(this);
        mToolbar = this.findViewById(R.id.toolbar);
        initActionBar();
        mTvDesc = this.findViewById(R.id.tvDesc);
        mTvAmount = this.findViewById(R.id.tvAmount);
        mRgInvoiceType = this.findViewById(R.id.rgInvoiceType);
        mRgInvoiceType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        mInvoiceType = "1000";
                        break;
                    case R.id.radioButton6:
                        mInvoiceType = "1001";
                        break;
                    case R.id.radioButton7:
                        mInvoiceType = "1002";
                        break;
                }

            }
        });
        mBtnNext = this.findViewById(R.id.btnNext);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(serviceStep3Activity.this, serviceConfirmActivity.class);
                Project p = Conf.GetProject();
                p.invoiceType = mInvoiceType;
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
            String desc = "居家清潔" + p.unit + "位";
            Integer amount = 1800 * Integer.parseInt(p.unit);
            mTvDesc.setText(desc);
            mTvAmount.setText(String.valueOf(amount));
        } else {
            String desc = "専業除蟎" + p.unit + "間";
            Integer amount = 988 * Integer.parseInt(p.unit);
            mTvDesc.setText(desc);
            mTvAmount.setText(String.valueOf(amount));
        }
    }
}
