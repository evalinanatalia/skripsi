package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

public class Laporan {
    @SerializedName("tanggal")
    private String tanggal;
    @SerializedName("jmlh_mobil_keluar")
    private String jmlh_mobil_keluar;
    @SerializedName("jmlh_mobil_kembali")
    private String jmlh_mobil_kembali;
    @SerializedName("total_mobil")
    private String total_mobil;

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJmlh_mobil_keluar() {
        return jmlh_mobil_keluar;
    }

    public void setJmlh_mobil_keluar(String jmlh_mobil_keluar) {
        this.jmlh_mobil_keluar = jmlh_mobil_keluar;
    }

    public String getJmlh_mobil_kembali() {
        return jmlh_mobil_kembali;
    }

    public void setJmlh_mobil_kembali(String jmlh_mobil_kembali) {
        this.jmlh_mobil_kembali = jmlh_mobil_kembali;
    }

    public String getTotal_mobil() {
        return total_mobil;
    }

    public void setTotal_mobil(String total_mobil) {
        this.total_mobil = total_mobil;
    }
}
