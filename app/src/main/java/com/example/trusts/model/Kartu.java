package com.example.trusts.model;

import com.google.gson.annotations.SerializedName;

public class Kartu {
        @SerializedName("e_card_jenis")
        private String e_card_jenis;
        @SerializedName("e_card_code")
        private String e_card_code;
        @SerializedName("status")
        private String status;
        @SerializedName("e_card_no")
        private Integer e_card_no;

        public String getE_card_jenis() {
            return e_card_jenis;
        }

        public void setE_card_jenis(String e_card_jenis) {
            this.e_card_jenis = e_card_jenis;
        }

        public String getE_card_code() {
            return e_card_code;
        }

        public void setE_card_code(String e_card_code) {
            this.e_card_code = e_card_code;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getE_card_no() {
            return e_card_no;
        }

        public void setE_card_no(Integer e_card_no) {
            this.e_card_no = e_card_no;
        }
}
