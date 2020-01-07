package com.example.trusts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.trusts.model.Kartu;
import com.example.trusts.model.Mobil;
import com.example.trusts.model.MobilKeluar;
import com.example.trusts.model.MobilKembali;
import com.example.trusts.model.Profile;
import com.example.trusts.model.ResponseData;
import com.example.trusts.model.ResponseKartu;
import com.example.trusts.model.ResponseMobil;
import com.example.trusts.network.NetworkService;
import com.example.trusts.retrofit.RetrofitClient;
import com.example.trusts.support.Preferences;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostMobilKembali extends AppCompatActivity {
    EditText tanggal, km_akhir, sisa_etol;
    Spinner spinner;
    Spinner spinner1;
    Button submit;
    Preferences mPreferences;
    Profile profile;
    ResponseMobil responseMobil;
    ResponseKartu responseKartu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_mobil_kembali);
        initToolbar(R.id.toolbar);
        mPreferences = new Preferences(this);

        NetworkService service = RetrofitClient.getClient().create(NetworkService.class);
        Call<ResponseMobil> call = service.getMobilPlat();
        Call<ResponseKartu> call1 = service.getKartu();

        call.enqueue(new Callback<ResponseMobil>() {
            @Override
            public void onResponse(Call<ResponseMobil> call, Response<ResponseMobil> response) {
                //Save User Data
                responseMobil = response.body();
                List<String> list = new ArrayList<String>();
                for(Mobil mobil : responseMobil.getData()){
                    list.add(mobil.getNo_plat());
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(PostMobilKembali.this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
            }

            @Override
            public void onFailure(Call<ResponseMobil> call, Throwable t) {
                Toast.makeText(PostMobilKembali.this, "gagal",Toast.LENGTH_LONG).show();
            }
        });

        call1.enqueue(new Callback<ResponseKartu>() {
            @Override
            public void onResponse(Call<ResponseKartu> call1, Response<ResponseKartu> response) {
                //Save User Data
                responseKartu = response.body();
                List<String> list = new ArrayList<String>();
                for(Kartu kartu : responseKartu.getData()){
                    list.add(kartu.getE_card_jenis());
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(PostMobilKembali.this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(dataAdapter);
            }

            @Override
            public void onFailure(Call<ResponseKartu> call1, Throwable t) {
                Toast.makeText(PostMobilKembali.this, "gagal",Toast.LENGTH_LONG).show();
            }
        });

        tanggal = (EditText) findViewById(R.id.tgl_out);
        km_akhir = (EditText)findViewById(R.id.km_akhir);
        sisa_etol = (EditText)findViewById(R.id.sisa_etol);
        submit = (Button) findViewById(R.id.btn_submit);
        spinner = (Spinner) findViewById(R.id.spin_plat);
        spinner1 = (Spinner) findViewById(R.id.spin_plat1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nomor=1;
                for(Mobil mobil : responseMobil.getData()){
                    if(mobil.getNo_plat().equals(spinner.getSelectedItem().toString())){
                        nomor=Integer.valueOf(mobil.getCar_no());
                    }
                }

                int kartu=1;
                for(Kartu kartus : responseKartu.getData()){
                    if(kartus.getE_card_jenis().equals(spinner1.getSelectedItem().toString())){
                        kartu=Integer.valueOf(kartus.getE_card_no());
                    }
                }

                MobilKembali mobilKembali = new MobilKembali();
                mobilKembali.setIn_dt(tanggal.getText().toString());
                mobilKembali.setKm_akhir(Integer.valueOf(km_akhir.getText().toString()));
                mobilKembali.setCar_no(nomor);
                mobilKembali.setUser_id(Integer.valueOf(mPreferences.getProfile().getUser_id()));
                mobilKembali.setStatus("Done");
                mobilKembali.setE_card_no(kartu);
                mobilKembali.setSisa_etol((Integer.valueOf(sisa_etol.getText().toString())));


                NetworkService service = RetrofitClient.getClient().create(NetworkService.class);
                Call<ResponseData> call = service.postMobilKembali(mobilKembali);

                call.enqueue(new Callback<ResponseData>() {
                    @Override
                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                        //Save User Data
                        Intent intent = new Intent(PostMobilKembali.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseData> call, Throwable t) {
                        Toast.makeText(PostMobilKembali.this, "gagal",Toast.LENGTH_LONG).show();
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
