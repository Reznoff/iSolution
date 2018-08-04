package com.example.kemalmaulana.isolution.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kemalmaulana.isolution.R;
import com.example.kemalmaulana.isolution.activities.MainA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KehadiranA extends RecyclerView.Adapter<KehadiranA.ViewHolder> {
    private ArrayList<HashMap<String, String>> listKehadiran;
    private MainA activity;
    public String nis, keterangan, status;

    public KehadiranA(ArrayList<HashMap<String, String>> list, MainA activity) {
        this.listKehadiran = list;
        this.activity = activity;
    }

    public KehadiranA() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_kehadiran, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        super.onBindViewHolder(holder, position, payloads);
        final HashMap<String, String> list = listKehadiran.get(position);
        holder.txtNIS.setText(list.get("nis"));
        //conditional student is attend or not
        if(list.get("status").equals("1")) {
//            holder.txtKeterangan.setText(R.string.list_keterangan_attending_pt1 + list.get(R.string.entity_nis) + R.string.list_keterangan_attending_pt2 + list.get(R.string.entity_tanggal) + list.get(R.string.entity_waktu));
            holder.txtKeterangan.setText(list.get("nis"));
            holder.txtStatus.setText(R.string.list_status_attending);
        } else {
//            holder.txtKeterangan.setText(R.string.list_keterangan_not_attending_pt1 + list.get(R.string.entity_nis) + R.string.list_keterangan_not_attending_pt2);
            holder.txtKeterangan.setText(list.get("nis"));
            holder.txtStatus.setText(R.string.list_status_not_attending);
        }
    }

    @Override
    public int getItemCount() {
        return listKehadiran.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNIS, txtKeterangan, txtStatus;

        public ViewHolder(View rootView) {
            super(rootView);
            txtNIS = rootView.findViewById(R.id.tvNIS);
            txtKeterangan = rootView.findViewById(R.id.tvKeterangan);
            txtStatus = rootView.findViewById(R.id.tvStatus);

        }
    }

}
