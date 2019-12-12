package com.example.trusts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trusts.R;
import com.example.trusts.model.MobilKeluar;

import java.util.List;

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
        if (v == null) {
        v = layoutInflater.inflate(R.layout.item_list, null);
        holder = new ViewHolder();
        holder.uName = (TextView) v.findViewById(R.id.txt_judul);
        holder.uDesignation = (TextView) v.findViewById(R.id.txt_keterangan);
        holder.uKm = (TextView) v.findViewById(R.id.txt_km);
        holder.noPlat = (TextView) v.findViewById(R.id.txt_mobil);
        v.setTag(holder);
        } else {
        holder = (ViewHolder) v.getTag();
        }
        holder.uName.setText(""+listData.get(position).getOut_dt());
        holder.uDesignation.setText(listData.get(position).getTujuan());
        holder.uKm.setText(""+listData.get(position).getKm_awal());
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
