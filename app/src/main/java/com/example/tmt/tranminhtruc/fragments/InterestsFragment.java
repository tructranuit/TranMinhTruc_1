package com.example.tmt.tranminhtruc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tmt.tranminhtruc.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InterestsFragment extends Fragment {


    public InterestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_interests, container, false);

        String json = "";
        return v;
    }

}
