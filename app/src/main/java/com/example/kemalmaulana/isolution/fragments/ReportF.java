package com.example.kemalmaulana.isolution.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kemalmaulana.isolution.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReportF.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReportF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReportF extends Fragment {
    public ReportF() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ReportF newInstance(String param1, String param2) {
        ReportF fragment = new ReportF();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false);
    }


}
