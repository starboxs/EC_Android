package com.example.marco.ec_android;

import okhttp3.logging.HttpLoggingInterceptor;

public class Conf {
    // Logger
    public static final HttpLoggingInterceptor.Level HTTP_LOGGING_LEVEL = BuildConfig.LOG_ENABLE ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE;

    // Api
    public static final String API_TEST_BASE_URL = "韓國瑜甲賽";
    public static final String API_REAL_BASE_URL = "甲賽韓國瑜";

}
