package com.example.tmt.tranminhtruc.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.models.Course;

import java.util.ArrayList;

/**
 * Created by tmtruc on 19/04/2017.
 */

public class CoursesAdapter extends ArrayAdapter<Course> {

    ArrayList<Course> courseList;
    Context context;

    public CoursesAdapter(Context context, int layoutId, ArrayList<Course> arrayList) {
        super(context, layoutId, arrayList);
        courseList = new ArrayList<>();
        courseList.addAll(arrayList);
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.course_item_layout, null);
        }

        TextView textView = (TextView) view.findViewById(R.id.tv_course_name);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_course_image);

        Course course = courseList.get(position);

        textView.setText(course.getCourseName().toString());
        imageView.setImageResource(course.getCourseImage());

        return view;
    }
}
