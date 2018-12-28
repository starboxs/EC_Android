package com.example.marco.ec_android.utils;

import android.content.Context;

import com.example.marco.ec_android.R;


public class CustomProgressDialog extends android.app.ProgressDialog {
    public CustomProgressDialog(Context context) {
        super(context);
        setMessage(context.getResources().getString(R.string.navigation_indexnews));
        setCancelable(false);
    }

    public CustomProgressDialog(Context context, String message) {
        super(context);
        setMessage(message);
        setCancelable(false);
    }

    @Override
    public void show() {
        super.show();
    }

    public void show(String message) {
        setMessage(message);
        show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
