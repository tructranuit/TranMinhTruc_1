package com.example.tmt.tranminhtruc.models;

/**
 * Created by tmtruc on 19/04/2017.
 */

public class Result {
    private int question;
    private String select;

    public Result(int question, String select) {
        this.question = question;
        this.select = select;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }
}
