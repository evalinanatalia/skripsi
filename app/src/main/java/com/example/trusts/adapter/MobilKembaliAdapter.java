package com.example.trusts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trusts.R;
import com.example.trusts.model.Laporan;
import com.example.trusts.model.MobilKembali;

import java.util.List;

public class MobilKembaliAdapter extends BaseAdapter {
    private List<MobilKembali> listData;
    private LayoutInflater layoutInflater;

    public MobilKembaliAdapter(Context aContext, List<MobilKembali> listData) {
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
            holder = new MobilKembaliAdapter.ViewHolder();
            holder.uName = (TextView) v.findViewById(R.id.txt_judul);
            holder.uDesignation = (TextView) v.findViewById(R.id.txt_keterangan);
            holder.uKm = (TextView) v.findViewById(R.id.txt_km);
            holder.noPlat = (TextView) v.findViewById(R.id.txt_mobil);
            v.setTag(holder);
        } else {
            holder = (MobilKembaliAdapter.ViewHolder) v.getTag();
        }
        holder.uName.setText(listData.get(position).getIn_dt());
        holder.uDesignation.setText("KM Akhir : " +listData.get(position).getKm_akhir());
        holder.uKm.setText("Tanggal Keluar : "+listData.get(position).getTanggal_keluar());
        holder.noPlat.setText(listData.get(position).getNo_plat());

        return v;
    }
    static class ViewHolder {
        TextView uName;
        TextView uDesignation;
        TextView uKm;
        TextView noPlat;
    }
}
