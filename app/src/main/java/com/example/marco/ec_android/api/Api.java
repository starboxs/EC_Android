package com.example.marco.ec_android.api;


import com.example.marco.ec_android.Conf;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static final String TAG = Api.class.getSimpleName();

    private static Api sApi = null;

    private OkHttpClient mOkHttpClient;
    private HttpLoggingInterceptor mHttpLoggingInterceptor;
    private Retrofit mRetrofit;
    private Gson mGson;
    private ApiInterface mApiInterface;

    private Api() {
        mHttpLoggingInterceptor = new HttpLoggingInterceptor();
        mHttpLoggingInterceptor.setLevel(Conf.HTTP_LOGGING_LEVEL);

        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(mHttpLoggingInterceptor)
                .build();

        mGson = new GsonBuilder().create();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Conf.API_BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mApiInterface = mRetrofit.create(ApiInterface.class);
    }

    public static Api getInstance() {
        if (sApi == null) {
            synchronized (Api.class) {
                if (sApi == null) {
                    sApi = new Api();
                }
            }
        }
        return sApi;
    }

    public ApiInterface getApiInterface() {
        return mApiInterface;
    }
}
