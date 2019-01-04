package com.example.marco.ec_android.api.models;

import com.google.gson.annotations.SerializedName;

public class Project {
    public String pId;
    public String name;
    public String unit;

    @SerializedName("type")
    public String serviceType;

    @SerializedName("typeName")
    public String serviceTypeName;

    public String serviceTimeType;

    @SerializedName("timetypeName")
    public String timeTypeName;

    @SerializedName("status")
    public String status;

    @SerializedName("statusName")
    public String statusName;

    public String invoiceType;
    public String amount;

    @SerializedName("address")
    public String userAddress;
    public String userId;
    public String userEmail;
    public String userName;
    public String userPhone;

    @SerializedName("pdesc")
    public String pDesc;
}
