package com.example.trusts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.trusts.adapter.MobilAdapter;
import com.example.trusts.model.Mobil;
import com.example.trusts.model.MobilKeluar;
import com.example.trusts.model.ResponseMobil;
import com.example.trusts.model.ResponseMobilKeluar;
import com.example.trusts.model.ResponseProfile;
import com.example.trusts.network.NetworkService;
import com.example.trusts.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MobilKeluarActivity extends AppCompatActivity {
    ListView listView;
    Button btn_add;
    MobilAdapter adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    List<MobilKeluar> keluarList;
    Mobil mobil;
    String[] jdl; //deklarasi judul iem
    String[] ktr; //deklarasi keterangan item
    String[] img; //deklarasi image item
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobil_keluar);
        initToolbar(R.id.toolbar);
        listView = (ListView)findViewById(R.id.list_view);
        btn_add = (Button) findViewById(R.id.btn_tambah);
        mylist = new ArrayList<HashMap<String, String>>();

        NetworkService service = RetrofitClient.getClient().create(NetworkService.class);
        Call<ResponseMobilKeluar> call = service.getMobil();

        call.enqueue(new Callback<ResponseMobilKeluar>() {
            @Override
            public void onResponse(Call<ResponseMobilKeluar> call, Response<ResponseMobilKeluar> response) {
                keluarList = response.body().getData();
                //Save User Data

                adapter = new MobilAdapter(MobilKeluarActivity.this, keluarList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponseMobilKeluar> call, Throwable t) {
                Toast.makeText(MobilKeluarActivity.this, "gagal",Toast.LENGTH_LONG).show();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MobilKeluarActivity.this, PostMobil.class));
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
