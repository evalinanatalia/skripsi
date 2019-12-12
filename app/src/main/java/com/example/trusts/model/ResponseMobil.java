package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

public class ResponseMobil {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Mobil data;

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

    public Mobil getData() {
        return data;
    }

    public void setData(Mobil data) {
        this.data = data;
    }
}
