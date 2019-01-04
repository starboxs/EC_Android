package com.example.marco.ec_android.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.marco.ec_android.Conf;
import com.example.marco.ec_android.R;
import com.example.marco.ec_android.api.models.Project;
import com.example.marco.ec_android.api.models.User;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

public class serviceStep2Activity extends RxAppCompatActivity {
    public Button mBtnNext;
    public EditText mEditName;
    public EditText mEditPhone;
    public EditText mEditEmail;
    public EditText mEditAddress;
    public RadioGroup mRgTimeType;
    public String mServiceTimeType = "1000";
    public Toolbar mToolbar;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_information);
        ButterKnife.bind(this);
        mToolbar = this.findViewById(R.id.toolbar);
        initActionBar();
        mBtnNext = this.findViewById(R.id.btnNext);
        mEditName = this.findViewById(R.id.editName);
        mEditPhone = this.findViewById(R.id.editPhone);
        mEditEmail = this.findViewById(R.id.editEmail);
        mEditAddress = this.findViewById(R.id.editAddress);
        mRgTimeType = this.findViewById(R.id.rgServiceTimeType);
        mRgTimeType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        mServiceTimeType = "1000";
                        break;
                    case R.id.radioButton2:
                        mServiceTimeType = "1001";
                        break;
                    case R.id.radioButton3:
                        mServiceTimeType = "1002";
                        break;
                    case R.id.radioButton4:
                        mServiceTimeType = "1003";
                        break;
                    case R.id.radioButton5:
                        mServiceTimeType = "1004";
                        break;
                }
            }
        });

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(serviceStep2Activity.this, serviceStep3Activity.class);
                Project p = Conf.GetProject();
                p.userAddress = mEditAddress.getText().toString();
                p.userEmail = mEditEmail.getText().toString();
                p.userName = mEditName.getText().toString();
                p.userPhone = mEditPhone.getText().toString();
                p.serviceTimeType = mServiceTimeType;
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
        User user = Conf.GetUser();
        mEditName.setText(user.name);
        mEditEmail.setText(user.email);
        mEditAddress.setText(user.address);
        mEditPhone.setText(user.phone);
    }
}
