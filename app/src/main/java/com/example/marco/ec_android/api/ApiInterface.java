package com.example.marco.ec_android.api;

import com.example.marco.ec_android.api.models.ApiResponse;
import com.example.marco.ec_android.api.responses.GetVendorApiResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiInterface {

    @POST("Admin/GetVendor")
    Observable<GetVendorApiResponse> getVendor();

    @FormUrlEncoded
    @POST("Project/Create")
    Observable<ApiResponse> ProjectCreate(@Field("name") String name, @Field("type") String type, @Field("address") String address, @Field("time_type") String time_type, @Field("m_id") String m_id, @Field("pdesc") String pdesc, @Field("amount") String amount);


}
