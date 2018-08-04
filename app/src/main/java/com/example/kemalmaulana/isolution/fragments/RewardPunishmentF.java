package com.example.kemalmaulana.isolution.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kemalmaulana.isolution.R;


public class RewardPunishmentF extends Fragment {


    public RewardPunishmentF() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static RewardPunishmentF newInstance(String param1, String param2) {
        RewardPunishmentF fragment = new RewardPunishmentF();
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
        return inflater.inflate(R.layout.fragment_reward_punishment, container, false);
    }


}
