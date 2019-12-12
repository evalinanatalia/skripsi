package com.example.trusts;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MobilKeluarActivity extends AppCompatActivity {
    ListView listView;
    SimpleAdapter adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] jdl; //deklarasi judul iem
    String[] ktr; //deklarasi keterangan item
    String[] img; //deklarasi image item
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobil_keluar);

        listView = (ListView)findViewById(R.id.list_view);
        jdl = new String[] {
                "Sampokong","Waterpark","Mangkang","Wonderia","Gereja Blenduk"
        };
        ktr = new String[]{
                "Tempat Wisata","Tempat Wisata","Tempat Wisata","Tempat Wisata","Tempat Wisata","Tempat Wisata" //jumlahnya harus sama dengan jumlah judul
        };
        img = new String[]{
                Integer.toString(R.drawable.sampokong),Integer.toString(R.drawable.waterpark),Integer.toString(R.drawable.mangkang),
                Integer.toString(R.drawable.wonderia),Integer.toString(R.drawable.gerejablenduk)
        };
        mylist = new ArrayList<HashMap<String, String>>();

        for (int i=0; i<jdl.length; i++){
            map = new HashMap<String, String>();
            map.put("judul", jdl[i]);
            map.put("Keterangan", ktr[i]);
            map.put("Gambar", img[i]);
            mylist.add(map);
        }
        adapter = new SimpleAdapter(this, mylist, R.layout.item_list,
                new String[]{"judul", "Keterangan", "Gambar"}, new int[]{R.id.txt_judul,(R.id.txt_keterangan),(R.id.img)});
        listView.setAdapter(adapter);
    }
}
