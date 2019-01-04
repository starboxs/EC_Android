package com.example.marco.ec_android.service;

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
import com.example.marco.ec_android.utils.CustomProgressDialog;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class serviceConfirmActivity extends RxAppCompatActivity {
    public Button mBtnNext;
    public Toolbar mToolbar;
    public TextView mTvServiceType;
    public TextView mTvAmount;
    public TextView mTvServiceTimeType;
    public TextView mTvInvoiceType;
    public TextView mTvconfirm_name;
    public TextView mTvConfirm_tel;
    public TextView mTvConfirm_mail;
    public TextView mTvConfirm_address;
    private ActionBar mActionBar;
    private CustomProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_confirm);
        ButterKnife.bind(this);
        mToolbar = this.findViewById(R.id.toolbar);
        initActionBar();
        mTvServiceTimeType = this.findViewById(R.id.tvServiceTimeType);
        mTvServiceType = this.findViewById(R.id.tvServiceType);
        mTvAmount = this.findViewById(R.id.tvAmount);
        mTvInvoiceType = this.findViewById(R.id.tvInvoice);
        mBtnNext = this.findViewById(R.id.btnNext);
        mTvconfirm_name = this.findViewById(R.id.confirm_name);
        mTvConfirm_tel = this.findViewById(R.id.confirm_tel);
        mTvConfirm_mail = this.findViewById(R.id.confirm_mail);
        mTvConfirm_address = this.findViewById(R.id.confirm_address);
        mProgressDialog = new CustomProgressDialog(this);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressDialog.show();
                Project p = Conf.GetProject();
                User u = Conf.GetUser();
                String amount = "";
                if (p.serviceType.contentEquals("1000")) {
                    amount = String.valueOf(1800 * Integer.parseInt(p.unit));
                } else {
                    amount = String.valueOf(988 * Integer.parseInt(p.unit));
                }
                Api.getInstance().getApiInterface().ProjectCreate("", p.serviceType, p.userAddress, p.serviceTimeType, u.id, p.pDesc, amount, p.invoiceType)
//                        .compose(this.<ApiResponse>bindToLifecycle())
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
                                final AlertDialog.Builder builder = new AlertDialog.Builder(serviceConfirmActivity.this, R.style.dialog_theme);
                                builder.setTitle("系統訊息")
                                        .setMessage("你沒連網路吧～")
                                        .setNegativeButton("我去連", okListener)
                                        .setCancelable(false)
                                        .show();
                            }

                            @Override
                            public void onNext(ApiResponse apiResponse) {
                                handleCreateProject(apiResponse);
                            }
                        });
            }
        });
        initUI();
    }

    private void handleCreateProject(ApiResponse apiResponse) {
        ApiResponse response = apiResponse;
        DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent i = new Intent();
                i.setClass(serviceConfirmActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.putExtra(MainActivity.EXTRA_SELECT_PAGE, 2);
                startActivity(i);
                finish();
            }
        };
        final AlertDialog.Builder builder = new AlertDialog.Builder(serviceConfirmActivity.this, R.style.dialog_theme);
        builder.setTitle("系統訊息")
                .setMessage("預約成功囉！")
                .setNegativeButton("好", okListener)
                .setCancelable(false)
                .show();
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
        Integer amount;
        String serviceTypeName = "";
        String serviceTimeTypeName = "";
        String invoiceTypeName = "";
        String userInfo = "";
        if (p.serviceType.contentEquals("1000")) {
            serviceTypeName = "居家清潔" + p.unit + "位";
            amount = 1800 * Integer.parseInt(p.unit);
        } else {
            serviceTypeName = "専業除蟎" + p.unit + "間";
            amount = 988 * Integer.parseInt(p.unit);
        }
        p.pDesc = serviceTypeName;
        Conf.setProject(p);

        switch (p.serviceTimeType) {
            case "1000":
                serviceTimeTypeName = "平日上午";
                break;
            case "1001":
                serviceTimeTypeName = "平日下午";
                break;
            case "1002":
                serviceTimeTypeName = "週六上午";
                break;
            case "1003":
                serviceTimeTypeName = "週六下午";
                break;
            case "1004":
                serviceTimeTypeName = "以上時段皆可";
                break;
        }

        switch (p.invoiceType) {
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

        mTvServiceType.setText(serviceTypeName);
        mTvAmount.setText(String.valueOf(amount));
        mTvServiceTimeType.setText(serviceTimeTypeName);
        mTvInvoiceType.setText(invoiceTypeName);
        mTvconfirm_name.setText("姓名:" + p.userName);
        mTvConfirm_tel.setText("電話:" + p.userPhone);
        mTvConfirm_mail.setText("Email:" + p.userEmail);
        mTvConfirm_address.setText("服務地址:" + p.userAddress);
    }
}
