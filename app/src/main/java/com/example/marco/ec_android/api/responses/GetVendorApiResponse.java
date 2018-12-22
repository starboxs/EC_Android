package com.example.marco.ec_android.api.responses;

import com.google.gson.annotations.SerializedName;

public class GetVendorApiResponse {
    @SerializedName("result")
    public String result;

    @SerializedName("versionCode")
    public String versionCode;

    @SerializedName("force")
    public Boolean force;
}
