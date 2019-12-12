package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

public class MobilKeluar {
    @SerializedName("out_no")
    private String out_no;
    @SerializedName("out_dt")
    private String out_dt;
    @SerializedName("km_awal")
    private Integer km_awal;
    @SerializedName("tujuan")
    private String tujuan;
    @SerializedName("car_no")
    private Integer car_no;
    @SerializedName("user_id")
    private Integer user_id;
    @SerializedName("status")
    private String status;
    @SerializedName("progress")
    private String progress;
    @SerializedName("no_plat")
    private String no_plat;

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

    public Integer getKm_awal() {
        return km_awal;
    }

    public void setKm_awal(Integer km_awal) {
        this.km_awal = km_awal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public Integer getCar_no() {
        return car_no;
    }

    public void setCar_no(Integer car_no) {
        this.car_no = car_no;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
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

    public String getNo_plat() {
        return no_plat;
    }

    public void setNo_plat(String no_plat) {
        this.no_plat = no_plat;
    }
}
