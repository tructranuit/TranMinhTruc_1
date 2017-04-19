package com.example.tmt.tranminhtruc.adapters;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.tmt.tranminhtruc.models.Courses;

import java.util.ArrayList;

/**
 * Created by tmtruc on 19/04/2017.
 */

public class CoursesAdapter extends ArrayAdapter<Courses> {

    ArrayList<Courses> courseList;

    public CoursesAdapter(Context context, int layoutId, ArrayList<Courses> arrayList) {
        super(context, layoutId, arrayList);
        courseList = new ArrayList<>();
        courseList.addAll(arrayList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
