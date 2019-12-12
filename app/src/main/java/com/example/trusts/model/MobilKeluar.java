package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

public class MobilKeluar {
    @SerializedName("out_no")
    private String out_no;
    @SerializedName("out_dt")
    private String out_dt;
    @SerializedName("km_awal")
    private String km_awal;
    @SerializedName("tujuan")
    private String tujuan;
    @SerializedName("car_no")
    private String car_no;
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("status")
    private String status;
    @SerializedName("progress")
    private String progress;

    public String getOut_no() {
        return out_no;
    }

    public void setOut_no(String out_no) {
        this.out_no = out_no;
    }

    public String getOut_dt() {
        return out_dt;
    }

    public void setOut_dt(String out_dt) {
        this.out_dt = out_dt;
    }

    public String getKm_awal() {
        return km_awal;
    }

    public void setKm_awal(String km_awal) {
        this.km_awal = km_awal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getCar_no() {
        return car_no;
    }

    public void setCar_no(String car_no) {
        this.car_no = car_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
