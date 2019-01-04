package com.example.marco.ec_android.member;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.marco.ec_android.Conf;
import com.example.marco.ec_android.MainActivity;
import com.example.marco.ec_android.R;
import com.example.marco.ec_android.api.Api;
import com.example.marco.ec_android.api.models.ApiResponse;
import com.example.marco.ec_android.api.models.Project;
import com.example.marco.ec_android.api.models.User;
import com.example.marco.ec_android.api.responses.GetMyProjectsApiResponse;
import com.example.marco.ec_android.utils.CustomProgressDialog;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class projectDetailActivity extends RxAppCompatActivity {
    public Button mBtnNext;
    public Toolbar mToolbar;
    public TextView mTvServiceType;
    public TextView mTvAmount;
    public TextView mTvServiceTimeType;
    public TextView mTvInvoiceType;
    public TextView mTvUser;
    public TextView mTvconfirm_name;
    public TextView mTvConfirm_tel;
    public TextView mTvConfirm_mail;
    public TextView mTvConfirm_address;
    private ActionBar mActionBar;
    private CustomProgressDialog mProgressDialog;
    private Project mData;
    private String mProjectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        ButterKnife.bind(this);
        mToolbar = this.findViewById(R.id.toolbar);
        initActionBar();
        mProjectId = getIntent().getStringExtra("ProjectId");

        mTvServiceTimeType = this.findViewById(R.id.tvServiceTimeType);
        mTvServiceType = this.findViewById(R.id.tvServiceType);
        mTvAmount = this.findViewById(R.id.tvAmount);
        mTvInvoiceType = this.findViewById(R.id.tvInvoice);
        mTvUser = this.findViewById(R.id.tvUser);
        mBtnNext = this.findViewById(R.id.btnNext);
        mTvconfirm_name = this.findViewById(R.id.confirm_name);
        mTvConfirm_tel = this.findViewById(R.id.confirm_tel);
        mTvConfirm_mail = this.findViewById(R.id.confirm_mail);
        mTvConfirm_address = this.findViewById(R.id.confirm_address);
        mProgressDialog = new CustomProgressDialog(this);
        init();
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFinish();
            }
        });

    }

    private void handleProjectDetail(GetMyProjectsApiResponse apiResponse) {
        ApiResponse response = apiResponse;
        mData = apiResponse.datas.get(0);
        String invoiceTypeName = "";
        String userInfo = "";

        switch (mData.invoiceType) {
            case "1000":
                invoiceTypeName = "二聯發票";
                break;
            case "1001":
                invoiceTypeName = "三聯發票";
                break;
            case "1002":
                invoiceTypeName = "載具發票";
                break;
        }

        User user = Conf.GetUser();

        mTvServiceType.setText(mData.serviceTypeName);
        mTvAmount.setText(String.valueOf(mData.amount));
        mTvServiceTimeType.setText(mData.timeTypeName);
        mTvInvoiceType.setText(invoiceTypeName);
        mTvconfirm_name.setText("姓名:" + user.name);
        mTvConfirm_tel.setText("電話:" + user.phone);
        mTvConfirm_mail.setText("Email:" + user.email);
        mTvConfirm_address.setText("服務地址:" + user.address);
        mTvUser.setText(userInfo);
        if (mData.status.equals("1001")) {
            mBtnNext.setVisibility(View.VISIBLE);
        } else {
            mBtnNext.setVisibility(View.GONE);
        }

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

    private void init() {
        Api.getInstance().getApiInterface().ProjectDetail(mProjectId)
//                        .compose(this.<GetMyProjectsApiResponse>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetMyProjectsApiResponse>() {
                    @Override
                    public void onCompleted() {
                        if (mProgressDialog != null && mProgressDialog.isShowing()) {
                            mProgressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mProgressDialog != null && mProgressDialog.isShowing()) {
                            mProgressDialog.dismiss();
                        }

                        DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        };
                        final AlertDialog.Builder builder = new AlertDialog.Builder(projectDetailActivity.this, R.style.dialog_theme);
                        builder.setTitle("系統訊息")
                                .setMessage("你沒連網路吧～")
                                .setNegativeButton("我去連", okListener)
                                .setCancelable(false)
                                .show();
                    }

                    @Override
                    public void onNext(GetMyProjectsApiResponse apiResponse) {
                        handleProjectDetail(apiResponse);
                    }
                });
    }

    private void setFinish() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.dialog_theme);
        builder.setTitle("系統訊息")
                .setMessage("施工完成了嗎？")
                .setPositiveButton("還沒！", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }
                )
                .setNegativeButton("完成了~", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Api.getInstance().getApiInterface().ProjectFinish(mProjectId)
//                        .compose(this.<GetMyProjectsApiResponse>bindToLifecycle())
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<ApiResponse>() {
                                    @Override
                                    public void onCompleted() {
                                        if (mProgressDialog != null && mProgressDialog.isShowing()) {
                                            mProgressDialog.dismiss();
                                        }
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        if (mProgressDialog != null && mProgressDialog.isShowing()) {
                                            mProgressDialog.dismiss();
                                        }

                                        DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        };
                                        final AlertDialog.Builder builder = new AlertDialog.Builder(projectDetailActivity.this, R.style.dialog_theme);
                                        builder.setTitle("系統訊息")
                                                .setMessage("你沒連網路吧～")
                                                .setNegativeButton("我去連", okListener)
                                                .setCancelable(false)
                                                .show();
                                    }

                                    @Override
                                    public void onNext(ApiResponse apiResponse) {
                                        handleSetFinish(apiResponse);
                                    }
                                });
                    }

                })
                .show();


    }

    private void handleSetFinish(ApiResponse apiResponse) {
        ApiResponse response = apiResponse;
        Intent i = new Intent();
        i.setClass(projectDetailActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.putExtra(MainActivity.EXTRA_SELECT_PAGE, 2);
        startActivity(i);
        finish();
    }
}
