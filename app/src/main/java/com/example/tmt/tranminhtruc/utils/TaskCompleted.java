package com.example.tmt.tranminhtruc.utils;

import com.example.tmt.tranminhtruc.models.Question;

import java.util.ArrayList;

/**
 * Created by tmtruc on 21/04/2017.
 */

public interface TaskCompleted {
    void onTaskComplete(ArrayList<Question> questionArrayList);
}
