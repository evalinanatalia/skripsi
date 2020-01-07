package com.example.trusts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trusts.R;
import com.example.trusts.model.Laporan;

import java.util.List;

public class LaporanAdapter extends BaseAdapter {
    private List<Laporan> listData;
    private LayoutInflater layoutInflater;

    public LaporanAdapter(Context aContext, List<Laporan> listData) {
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
        if (v == null) {
            v = layoutInflater.inflate(R.layout.item_list, null);
            holder = new LaporanAdapter.ViewHolder();
            holder.uName = (TextView) v.findViewById(R.id.txt_judul);
            holder.uDesignation = (TextView) v.findViewById(R.id.txt_keterangan);
            holder.uKm = (TextView) v.findViewById(R.id.txt_km);
            holder.noPlat = (TextView) v.findViewById(R.id.txt_mobil);
            v.setTag(holder);
        } else {
            holder = (LaporanAdapter.ViewHolder) v.getTag();
        }
        holder.uName.setText(listData.get(position).getTanggal());
        holder.uDesignation.setText("Jumlah Mobil Keluar : " + listData.get(position).getJmlh_mobil_keluar());
        holder.uKm.setText("Jumlah Mobil Kembali : " + listData.get(position).getJmlh_mobil_kembali());
        holder.noPlat.setText("Total Mobil : " + listData.get(position).getTotal_mobil());

        return v;
    }
    static class ViewHolder {
        TextView uName;
        TextView uDesignation;
        TextView uKm;
        TextView noPlat;
    }
}
