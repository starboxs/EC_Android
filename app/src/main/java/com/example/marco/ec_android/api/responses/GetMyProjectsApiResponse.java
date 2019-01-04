package com.example.marco.ec_android.api.responses;

import com.example.marco.ec_android.api.models.ApiResponse;
import com.example.marco.ec_android.api.models.Project;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetMyProjectsApiResponse extends ApiResponse {
    @SerializedName("data")
    public ArrayList<Project> datas;
}
