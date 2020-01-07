package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

public class MobilKembali {
    @SerializedName("in_no")
    private String in_no;
    @SerializedName("in_dt")
    private String in_dt;
    @SerializedName("out_no")
    private Integer out_no;
    @SerializedName("km_akhir")
    private Integer km_akhir;
    @SerializedName("car_no")
    private Integer car_no;
    @SerializedName("model")
    private String model;
    @SerializedName("user_id")
    private Integer user_id;
    @SerializedName("status")
    private String status;
    @SerializedName("keterangan")
    private String keterangan;
    @SerializedName("no_plat")
    private String no_plat;
    @SerializedName("km_awal")
    private Integer km_awal;
    @SerializedName("tanggal_keluar")
    private String tanggal_keluar;
    @SerializedName("sisa_etol")
    private Integer sisa_etol;
    @SerializedName("e_card_no")
    private Integer e_card_no;



    public String getIn_no() {
        return in_no;
    }

    public void setIn_no(String in_no) {
        this.in_no = in_no;
    }

    public Integer getOut_no() {
        return out_no;
    }

    public void setOut_no(Integer out_no) {
        this.out_no = out_no;
    }

    public Integer getKm_akhir() {
        return km_akhir;
    }

    public void setKm_akhir(Integer km_akhir) {
        this.km_akhir = km_akhir;
    }

    public Integer getCar_no() {
        return car_no;
    }

    public void setCar_no(Integer car_no) {
        this.car_no = car_no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getNo_plat() {
        return no_plat;
    }

    public void setNo_plat(String no_plat) {
        this.no_plat = no_plat;
    }

    public Integer getKm_awal() {
        return km_awal;
    }

    public void setKm_awal(Integer km_awal) {
        this.km_awal = km_awal;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getIn_dt() {
        return in_dt;
    }

    public void setIn_dt(String in_dt) {
        this.in_dt = in_dt;
    }

    public String getTanggal_keluar() {
        return tanggal_keluar;
    }

    public void setTanggal_keluar(String tanggal_keluar) {
        this.tanggal_keluar = tanggal_keluar;
    }

    public Integer getSisa_etol() {
        return sisa_etol;
    }

    public void setSisa_etol(Integer sisa_etol) {
        this.sisa_etol = sisa_etol;
    }

    public Integer getE_card_no() {
        return e_card_no;
    }

    public void setE_card_no(Integer e_card_no) {
        this.e_card_no = e_card_no;
    }
}
