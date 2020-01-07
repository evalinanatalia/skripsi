package com.example.trusts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.trusts.R;
import com.example.trusts.model.MobilKeluar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MobilAdapter extends BaseAdapter {

    private List<MobilKeluar> listData;
    private LayoutInflater layoutInflater;

    public MobilAdapter(Context aContext, List<MobilKeluar> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listData.size();
        }
    @Override
    public Object getItem(int position) {
            return listData.get(position);
            }
    @Override
    public long getItemId(int position) {
            return position;
            }
    public View getView(int position, View v, ViewGroup vg) {
        ViewHolder holder;
        Button gps;


        if (v == null) {
            v = layoutInflater.inflate(R.layout.item_list, null);
            holder = new ViewHolder();
            holder.uName = (TextView) v.findViewById(R.id.txt_judul);
            holder.uDesignation = (TextView) v.findViewById(R.id.txt_keterangan);
            holder.uKm = (TextView) v.findViewById(R.id.txt_km);
            holder.noPlat = (TextView) v.findViewById(R.id.txt_mobil);
            v.setTag(holder);
        }else {
            holder = (ViewHolder) v.getTag();
        }

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = format.parse(listData.get(position).getOut_dt());

            SimpleDateFormat your_format = new SimpleDateFormat("dd-MM-yyyy");
            String date_out = your_format.format(dt);

            holder.uName.setText("Tanggal Mobil Keluar : " + date_out);
            holder.uDesignation.setText("Tujuan : " + listData.get(position).getTujuan());
            holder.uKm.setText("Km Awal : " + listData.get(position).getKm_awal() + " km ");
            holder.noPlat.setText("Nomor Plat : " + listData.get(position).getNo_plat());
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        holder.uName.setText("Tanggal Mobil Keluar : " + listData.get(position).getOut_dt());
//        holder.uDesignation.setText("Tujuan : " + listData.get(position).getTujuan());
//        holder.uKm.setText("Km Awal : " + listData.get(position).getKm_awal() + " km ");
//        holder.noPlat.setText("Nomor Plat : " + listData.get(position).getNo_plat());
        return v;
    }
    static class ViewHolder {
        TextView uName;
        TextView uDesignation;
        TextView uKm;
        TextView noPlat;
    }
}
