package com.example.tmt.tranminhtruc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.adapters.CourseAdapter;
import com.example.tmt.tranminhtruc.models.Course;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {


    public EducationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_education, container, false);


        return v;
    }

}
