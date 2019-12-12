package com.example.trusts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.trusts.model.MobilKeluar;
import com.example.trusts.model.Profile;
import com.example.trusts.model.ResponseData;
import com.example.trusts.model.ResponseProfile;
import com.example.trusts.network.NetworkService;
import com.example.trusts.retrofit.RetrofitClient;
import com.example.trusts.support.Preferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostMobil extends AppCompatActivity {
    EditText tanggal, km_awal, tujuan, no_mobil;
    Button submit;
    Preferences mPreferences;
    Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_mobil);
        initToolbar(R.id.toolbar);
        mPreferences = new Preferences(this);

        tanggal = (EditText) findViewById(R.id.tgl_out);
        km_awal = (EditText)findViewById(R.id.km_awal);
        tujuan = (EditText)findViewById(R.id.tujuan);
        no_mobil = (EditText)findViewById(R.id.car_no);
        submit = (Button) findViewById(R.id.btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MobilKeluar mobilKeluar = new MobilKeluar();
                mobilKeluar.setOut_dt(tanggal.getText().toString());
                mobilKeluar.setKm_awal(Integer.valueOf(km_awal.getText().toString()));
                mobilKeluar.setTujuan(tujuan.getText().toString());
                mobilKeluar.setCar_no(Integer.valueOf(no_mobil.getText().toString()));
                mobilKeluar.setUser_id(Integer.valueOf(mPreferences.getProfile().getUser_id()));
                mobilKeluar.setStatus("Request");
                mobilKeluar.setProgress("In Progress");

                NetworkService service = RetrofitClient.getClient().create(NetworkService.class);
                Call<ResponseData> call = service.postMobil(mobilKeluar);

                call.enqueue(new Callback<ResponseData>() {
                    @Override
                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                        //Save User Data
                        Intent intent = new Intent(PostMobil.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseData> call, Throwable t) {
                        Toast.makeText(PostMobil.this, "gagal",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    public void initToolbar(int toolbarId) {
        Toolbar toolbar = (Toolbar) findViewById(toolbarId);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            assert getSupportActionBar() != null;
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }
}
