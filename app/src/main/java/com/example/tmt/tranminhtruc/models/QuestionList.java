package com.example.tmt.tranminhtruc.models;

import java.util.ArrayList;

/**
 * Created by tmtruc on 20/04/2017.
 */

public class QuestionList {
    private ArrayList<Question> List_Questions;

    public QuestionList(ArrayList<Question> questionArrayList) {
        //this.List_Questions = new ArrayList<>();
        this.List_Questions = questionArrayList;
    }

    public ArrayList<Question> getList_Questions() {
        return List_Questions;
    }

    public void setList_Questions(ArrayList<Question> list_Questions) {
        List_Questions = list_Questions;
    }
}
