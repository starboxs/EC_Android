package com.example.marco.ec_android.api;

import com.example.marco.ec_android.api.responses.GetVendorApiResponse;

import io.reactivex.Observable;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("Admin/GetVendor")
    Observable<GetVendorApiResponse> getVendor(@Header("token") String token);

}
