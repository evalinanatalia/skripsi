package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMobilKembali {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<MobilKembali> data;

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

    public List<MobilKembali> getData() {
        return data;
    }

    public void setData(List<MobilKembali> data) {
        this.data = data;
    }
}
