package com.example.trusts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trusts.model.MobilKeluar;
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
    SimpleAdapter adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    List<MobilKeluar> keluarList;
    String[] jdl; //deklarasi judul iem
    String[] ktr; //deklarasi keterangan item
    String[] img; //deklarasi image item
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobil_keluar);

        NetworkService service = RetrofitClient.getClient().create(NetworkService.class);
        Call<List<MobilKeluar>> call = service.getMobil();

        call.enqueue(new Callback<List<MobilKeluar>>() {
            @Override
            public void onResponse(Call<List<MobilKeluar>> call, Response<List<MobilKeluar>> response) {
                keluarList = response.body();
//                Intent intent = new Intent(MobilKeluarActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
            }

            @Override
            public void onFailure(Call<List<MobilKeluar>> call, Throwable t) {
                Toast.makeText(MobilKeluarActivity.this, "gagal",Toast.LENGTH_LONG).show();
            }
        });

        listView = (ListView)findViewById(R.id.list_view);
//        jdl = new String[] {
//                "Sampokong","Waterpark","Mangkang","Wonderia","Gereja Blenduk"
//        };
//        ktr = new String[]{
//                "Tempat Wisata","Tempat Wisata","Tempat Wisata","Tempat Wisata","Tempat Wisata","Tempat Wisata" //jumlahnya harus sama dengan jumlah judul
//        };
        img = new String[]{
                Integer.toString(R.drawable.sampokong),Integer.toString(R.drawable.waterpark),Integer.toString(R.drawable.mangkang),
                Integer.toString(R.drawable.wonderia),Integer.toString(R.drawable.gerejablenduk)
        };
        mylist = new ArrayList<HashMap<String, String>>();

        for (int i=0; i<keluarList.size(); i++){
            map = new HashMap<String, String>();
            map.put("judul", keluarList.get(i).getCar_no());
            map.put("Keterangan", keluarList.get(i).getTujuan());
            mylist.add(map);
        }
        adapter = new SimpleAdapter(this, mylist, R.layout.item_list,
                new String[]{"judul", "Keterangan", "Gambar"}, new int[]{R.id.txt_judul,(R.id.txt_keterangan)});
        listView.setAdapter(adapter);
    }
}
