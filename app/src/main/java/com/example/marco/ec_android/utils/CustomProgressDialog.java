package com.example.marco.ec_android.utils;

import android.content.Context;


public class CustomProgressDialog extends android.app.ProgressDialog {
    public CustomProgressDialog(Context context) {
        super(context);
        setMessage("系統訊息");
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
