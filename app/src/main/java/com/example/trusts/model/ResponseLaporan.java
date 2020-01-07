package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseLaporan {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<Laporan> data;

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

    public List<Laporan> getData() {
        return data;
    }

    public void setData(List<Laporan> data) {
        this.data = data;
    }
}
