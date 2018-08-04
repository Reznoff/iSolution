package com.example.kemalmaulana.isolution.fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kemalmaulana.isolution.R;
import com.example.kemalmaulana.isolution.activities.MainA;
import com.example.kemalmaulana.isolution.adapters.KehadiranA;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class KehadiranF extends Fragment {

    RecyclerView listKehadiran;
    LinearLayoutManager linearLayoutManager;
    RelativeLayout layout;
    ArrayList<HashMap<String, String>> arr = new ArrayList<>();
    RequestQueue jsonQueue;


    public KehadiranF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_kehadiran, container, false);
        setDialog(true);
        listKehadiran = (RecyclerView) rootView.findViewById(R.id.listKehadiran);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        listKehadiran.setLayoutManager(linearLayoutManager);
        jsonQueue = Volley.newRequestQueue(getContext());
        doDummyData();
        return rootView;
    }

    private void setDialog(boolean show) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(R.layout.dialog_progress);
        Dialog dialog = builder.create();
        if(show) {
            dialog.show();
        } else {
            dialog.dismiss();
        }
    }


    private void doDummyData() {
        ArrayList<HashMap<String, String>> arr = new ArrayList<>();
        HashMap<String, String> map;
        for (int i=1; i<=10; i++) {
            map = new HashMap<String, String>();
            map.put("nis", "A");
            map.put("status", "0");
            arr.add(map);
        }
        listKehadiran.setAdapter(new KehadiranA(arr, (MainA) getActivity()));
        setDialog(false);
    }

    private void JSONParser() {
        String urlJson = "<<ADD-URL-HERE>>";
        StringRequest request = new StringRequest(urlJson, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()) {
                    try {
                        ArrayList<HashMap<String, String>> arr = new ArrayList<>();
                        JSONArray jsonArr = new JSONArray(response);
                        HashMap<String, String> map;
                        for (int i=0;i<jsonArr.length(); i++) {
                            JSONObject jsonObj = jsonArr.getJSONObject(i);
                            map = new HashMap<String, String>();
                            map.put("id_kehadiran", jsonObj.getString("id_kehadiran"));
                            map.put("nis", jsonObj.getString("nis"));
                            map.put("id_kelas", jsonObj.getString("id_kelas"));
                            map.put("tanggal", jsonObj.getString("tanggal"));
                            map.put("waktu", jsonObj.getString("waktu"));
                            map.put("status", jsonObj.getString("status"));
                            map.put("keterangan", jsonObj.getString("keterangan"));
                            arr.add(map);
                        }
                        listKehadiran.setAdapter(new KehadiranA(arr, (MainA) getActivity()));
                    } catch (final Exception e) {
                        Log.e("JSON Parsing Error : ", "-> " + e.getMessage());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //show something if error occurs
//                                Snackbar.make(getContext(), "Json parsing error: "+e.getMessage(), Snackbar.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        jsonQueue.add(request);
    }

}
