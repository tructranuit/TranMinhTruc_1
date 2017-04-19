package com.example.tmt.tranminhtruc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.activities.MainActivity;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {

    private ListView lvCourses;

    ArrayList<String> coursesList;

    public EducationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_education, container, false);

        lvCourses = (ListView) v.findViewById(R.id.lv_courses);

        coursesList = new ArrayList<String>();
        coursesList.add("Nhập môn lập trình");
        coursesList.add("Cấu trúc dữ liệu và giải thuật");
        coursesList.add("Lập trình hướng đối tượng");
        coursesList.add("Cơ sở dữ liệu");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, coursesList);
        lvCourses.setAdapter(adapter);
        return v;
    }

}
