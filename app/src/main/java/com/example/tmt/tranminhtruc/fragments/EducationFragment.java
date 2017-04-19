package com.example.tmt.tranminhtruc.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.activities.MainActivity;
import com.example.tmt.tranminhtruc.adapters.CoursesAdapter;
import com.example.tmt.tranminhtruc.models.Course;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {

    private ListView lvCourses;

    ArrayList<Course> coursesList;

    public EducationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_education, container, false);

        lvCourses = (ListView) v.findViewById(R.id.lv_courses);

        coursesList = new ArrayList<Course>();
        coursesList.add(new Course("Nhập môn lập trình", R.drawable.ic_android_black));
        coursesList.add(new Course("Cấu trúc dữ liệu và giải thuật", R.drawable.ic_android_green));
        coursesList.add(new Course("Lập trình hướng đối tượng", R.drawable.ic_android_black));
        coursesList.add(new Course("Cơ sở dữ liệu", R.drawable.ic_android_green));
        coursesList.add(new Course("Kiến trúc máy tính", R.drawable.ic_android_black));
        coursesList.add(new Course("Lý thuyết thông tin", R.drawable.ic_android_green));
        coursesList.add(new Course("Mạng máy tính", R.drawable.ic_android_black));
        coursesList.add(new Course("Lập trình ứng dụng trên thiết bị di động", R.drawable.ic_android_green));
        coursesList.add(new Course("Lập trình hệ thống", R.drawable.ic_android_black));

        CoursesAdapter adapter = new CoursesAdapter(getContext(), R.layout.course_item_layout, coursesList);
        lvCourses.setAdapter(adapter);
        return v;
    }

}
