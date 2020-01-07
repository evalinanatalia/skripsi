package com.example.trusts;

import android.app.DatePickerDialog;

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

import com.example.trusts.model.Mobil;
import com.example.trusts.model.MobilKeluar;
import com.example.trusts.model.Profile;
import com.example.trusts.model.ResponseData;
import com.example.trusts.model.ResponseMobil;
import com.example.trusts.network.NetworkService;
import com.example.trusts.retrofit.RetrofitClient;
import com.example.trusts.support.Preferences;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PostMobil extends AppCompatActivity {
    EditText tanggal, km_awal, tujuan;
    Spinner spinner;
    Button submit;
    Preferences mPreferences;
    Profile profile;
    ResponseMobil responseMobil;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private EditText btDatePicker;

    private void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tvDateResult.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_mobil);
        initToolbar(R.id.toolbar);
        mPreferences = new Preferences(this);

        NetworkService service = RetrofitClient.getClient().create(NetworkService.class);
        Call<ResponseMobil> call = service.getMobilPlat();

        call.enqueue(new Callback<ResponseMobil>() {
            @Override
            public void onResponse(Call<ResponseMobil> call, Response<ResponseMobil> response) {
                //Save User Data
                responseMobil = response.body();
                List<String> list = new ArrayList<String>();
                for(Mobil mobil : responseMobil.getData()){
                    if(!mobil.getStatus_mobil().equals("Request") && !mobil.getStatus_mobil().equals("In Use")) {
                        list.add(mobil.getNo_plat());
                    }
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(PostMobil.this,
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
            }

            @Override
            public void onFailure(Call<ResponseMobil> call, Throwable t) {
                Toast.makeText(PostMobil.this, "gagal",Toast.LENGTH_LONG).show();
            }
        });

//        tanggal = (EditText) findViewById(R.id.tv_dateresult);
        km_awal = (EditText)findViewById(R.id.km_awal);
        tujuan = (EditText)findViewById(R.id.tujuan);
        submit = (Button) findViewById(R.id.btn_submit);
        spinner = (Spinner) findViewById(R.id.spin_plat);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tgl = String.valueOf(tvDateResult.getText().toString());
                SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

                try {
                    Date newDate = format1.parse(tgl);

                    SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                    String date_out = format2.format(newDate);

                    int nomor=1;
                    for(Mobil mobil : responseMobil.getData()){
                        if(mobil.getNo_plat().equals(spinner.getSelectedItem().toString())){
                            nomor=Integer.valueOf(mobil.getCar_no());
                        }
                    }

                    MobilKeluar mobilKeluar = new MobilKeluar();
                    mobilKeluar.setOut_dt(date_out);
                    mobilKeluar.setKm_awal(Integer.valueOf(km_awal.getText().toString()));
                    mobilKeluar.setTujuan(tujuan.getText().toString());
                    mobilKeluar.setCar_no(nomor);
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
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = (TextView) findViewById(R.id.tv_dateresult);
        btDatePicker = (EditText) findViewById(R.id.tv_dateresult);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                showDateDialog();
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
