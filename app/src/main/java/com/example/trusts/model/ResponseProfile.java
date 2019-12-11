package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

public class ResponseProfile {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Profile data;

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

    public Profile getGasType() {
        return data;
    }

    public void setGasType(Profile data) {
        this.data = data;
    }

}
