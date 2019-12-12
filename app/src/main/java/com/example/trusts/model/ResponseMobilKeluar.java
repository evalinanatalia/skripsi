package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMobilKeluar {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<MobilKeluar> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MobilKeluar> getData() {
        return data;
    }

    public void setData(List<MobilKeluar> data) {
        this.data = data;
    }
}
