package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

public class Mobil {
    @SerializedName("no_plat")
    private String no_plat;
    @SerializedName("nama_pemilik")
    private String nama_pemilik;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("merk")
    private String merk;
    @SerializedName("type")
    private String type;
    @SerializedName("jenis")
    private String jenis;
    @SerializedName("model")
    private String model;
    @SerializedName("tahun")
    private String tahun;
    @SerializedName("warna")
    private String warna;
    @SerializedName("no_rangka")
    private String no_rangka;
    @SerializedName("no_mesin")
    private String no_mesin;
    @SerializedName("no_bpkb")
    private String no_bpkp;
    @SerializedName("status_mobil")
    private String status_mobil;
    @SerializedName("status")
    private String status;

    public String getNo_plat() {
        return no_plat;
    }

    public void setNo_plat(String no_plat) {
        this.no_plat = no_plat;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getNo_rangka() {
        return no_rangka;
    }

    public void setNo_rangka(String no_rangka) {
        this.no_rangka = no_rangka;
    }

    public String getNo_mesin() {
        return no_mesin;
    }

    public void setNo_mesin(String no_mesin) {
        this.no_mesin = no_mesin;
    }

    public String getNo_bpkp() {
        return no_bpkp;
    }

    public void setNo_bpkp(String no_bpkp) {
        this.no_bpkp = no_bpkp;
    }

    public String getStatus_mobil() {
        return status_mobil;
    }

    public void setStatus_mobil(String status_mobil) {
        this.status_mobil = status_mobil;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
