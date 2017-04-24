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
public class CoursesFragment extends Fragment {

    private ListView lvCourses;

    ArrayList<Course> coursesList;


    public CoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_courses, container, false);

        lvCourses = (ListView) v.findViewById(R.id.lv_courses);

        coursesList = new ArrayList<Course>();
        coursesList.add(new Course("Giải tích", R.drawable.img_default));
        coursesList.add(new Course("Anh văn", R.drawable.img_default));
        coursesList.add(new Course("Nhập môn lập trình", R.drawable.img_default));
        coursesList.add(new Course("Cơ sở dữ liệu", R.drawable.img_default));
        coursesList.add(new Course("Kiến trúc máy tính", R.drawable.img_default));
        coursesList.add(new Course("Lý thuyết thông tin", R.drawable.img_default));
        coursesList.add(new Course("Mạng máy tính", R.drawable.img_default));
        coursesList.add(new Course("Lập trình ứng dụng trên thiết bị di động", R.drawable.img_default));
        coursesList.add(new Course("Lập trình hệ thống", R.drawable.img_default));
        coursesList.add(new Course("Lập trình hướng đối tượng", R.drawable.img_default));
        coursesList.add(new Course("Cấu trúc dữ liệu và giải thuật", R.drawable.img_default));
        coursesList.add(new Course("An toàn mạng máy tính", R.drawable.img_default));
        coursesList.add(new Course("Công nghệ thoại IP", R.drawable.img_default));

        CourseAdapter adapter = new CourseAdapter(getContext(), R.layout.course_item_layout, coursesList);
        lvCourses.setAdapter(adapter);
        return v;
    }

}
