package com.example.marco.ec_android.api.models;

import com.google.gson.annotations.SerializedName;


public class ApiResponse {
    @SerializedName("result")
    public String resultCode;

    @SerializedName("message")
    public String resultMessage;
}

