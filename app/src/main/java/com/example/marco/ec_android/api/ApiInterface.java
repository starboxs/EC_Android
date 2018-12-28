package com.example.marco.ec_android.api;

import com.example.marco.ec_android.api.responses.GetVendorApiResponse;

import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiInterface {

    @POST("Admin/GetVendor")
    Observable<GetVendorApiResponse> getVendor();

}
