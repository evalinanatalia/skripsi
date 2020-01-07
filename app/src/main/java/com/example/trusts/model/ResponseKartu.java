package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseKartu {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<Kartu> data;

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

    public List<Kartu> getData() {
        return data;
    }

    public void setData(List<Kartu> data) {
        this.data = data;
    }
}
