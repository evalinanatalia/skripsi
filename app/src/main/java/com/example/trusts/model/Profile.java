package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

public class Profile {
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("nama_lengkap")
    private String nama_lengkap;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("jenis_kelamin")
    private String jenis_kelamin;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("profil_pic")
    private String profil_pic;
    @SerializedName("ktp")
    private String ktp;
    @SerializedName("no_tlp_1")
    private String no_tlp_1;
    @SerializedName("no_tlp_2")
    private String no_tlp_2;
    @SerializedName("status")
    private String status;
    @SerializedName("role")
    private String role;
    @SerializedName("cre_dt")
    private String cre_dt;


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProfil_pic() {
        return profil_pic;
    }

    public void setProfil_pic(String profil_pic) {
        this.profil_pic = profil_pic;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getNo_tlp_1() {
        return no_tlp_1;
    }

    public void setNo_tlp_1(String no_tlp_1) {
        this.no_tlp_1 = no_tlp_1;
    }

    public String getNo_tlp_2() {
        return no_tlp_2;
    }

    public void setNo_tlp_2(String no_tlp_2) {
        this.no_tlp_2 = no_tlp_2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCre_dt() {
        return cre_dt;
    }

    public void setCre_dt(String cre_dt) {
        this.cre_dt = cre_dt;
    }
}

