package com.example.marco.ec_android.api;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.example.marco.ec_android.MainActivity;
import com.example.marco.ec_android.R;

public class ApiResponseHandler {

    public static int API_RESULT_SUCCESS_CODE = 10;//正確
    public static int API_RESULT_ERROR_11 = 11;//查無案件
    public static int API_RESULT_ERROR_12 = 12;//查無使用者
    public static int API_RESULT_ERROR_13 = 13;//此案件無法聯繫

    public static int API_RESULT_DATA_ERROR_CODE = 18;//傳送資料錯誤
    public static int API_RESULT_TOKEN_ERROR_CODE = 19;//token錯誤


    public static void handle(final Context context, String apiResultCode, String errorMessage, boolean showError, ApiResponseHandlerCallBack apiResponseHandlerCallBack) {
        int resultCode = Integer.valueOf(apiResultCode);
        //10
        if (resultCode == API_RESULT_SUCCESS_CODE) {
            if (apiResponseHandlerCallBack != null) {
                apiResponseHandlerCallBack.onHandled();
            }
        }
        //19
        else if (resultCode == API_RESULT_TOKEN_ERROR_CODE) {
            DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(intent);
                    dialog.dismiss();
                }
            };
//            DialogUtils.processSuccessDialog(context, R.string.alert_title, R.string.alert_token_error, okListener);
//            UserStore.getInstance(context).clear();
            if (apiResponseHandlerCallBack != null) {
                apiResponseHandlerCallBack.onTokenErrorHandled();
            }
        }
        //18
        else if (resultCode == API_RESULT_DATA_ERROR_CODE) {
            DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            };
//            DialogUtils.processSuccessDialog(context, R.string.alert_title, R.string.alert_data_error, okListener);
            if (apiResponseHandlerCallBack != null) {
                apiResponseHandlerCallBack.onTokenErrorHandled();
            }
        }
        //11
        //12
        //14
        else {
            if (showError) {
                Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show();
            }
            if (apiResponseHandlerCallBack != null) {
                apiResponseHandlerCallBack.onError(resultCode);
            }
        }
    }

    ;

    public interface ApiResponseHandlerCallBack {
        void onHandled();

        void onError(int errorCode);

        void onTokenErrorHandled();
    }
}

