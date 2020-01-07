package com.example.trusts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.trusts.adapter.MobilKembaliAdapter;
import com.example.trusts.model.Mobil;
import com.example.trusts.model.MobilKembali;
import com.example.trusts.model.ResponseMobilKembali;
import com.example.trusts.network.NetworkService;
import com.example.trusts.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MobilKembaliActivity extends AppCompatActivity {
    ListView listView;
    Button btn_add;
    MobilKembaliAdapter adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    List<MobilKembali> kembaliList;
    Mobil mobil;
    String[] jdl; //deklarasi judul iem
    String[] ktr; //deklarasi keterangan item
    String[] img; //deklarasi image item
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobils_kembali);
        initToolbar(R.id.toolbar);
        listView = (ListView)findViewById(R.id.list_view);
        btn_add = (Button) findViewById(R.id.btn_tambah);
        mylist = new ArrayList<HashMap<String, String>>();

        NetworkService service = RetrofitClient.getClient().create(NetworkService.class);
        Call<ResponseMobilKembali> call = service.getMobilKembali();

        call.enqueue(new Callback<ResponseMobilKembali>() {
            @Override
            public void onResponse(Call<ResponseMobilKembali> call, Response<ResponseMobilKembali> response) {
                kembaliList = response.body().getData();
                //Save User Data

                adapter = new MobilKembaliAdapter(MobilKembaliActivity.this, kembaliList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponseMobilKembali> call, Throwable t) {
                Toast.makeText(MobilKembaliActivity.this, "gagal",Toast.LENGTH_LONG).show();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MobilKembaliActivity.this, PostMobilKembali.class));
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
