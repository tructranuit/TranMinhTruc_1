package com.example.tmt.tranminhtruc.models;

/**
 * Created by tmtruc on 19/04/2017.
 */

public class Result {
    private int indexOfQuestion;
    private int indexOfOption;

    public Result(int indexOfQuestion, int indexOfOption) {
        this.indexOfQuestion = indexOfQuestion;
        this.indexOfOption = indexOfOption;
    }

    public int getIndexOfQuestion() {
        return indexOfQuestion;
    }

    public void setIndexOfQuestion(int indexOfQuestion) {
        this.indexOfQuestion = indexOfQuestion;
    }

    public int getIndexOfOption() {
        return indexOfOption;
    }

    public void setIndexOfOption(int indexOfOption) {
        this.indexOfOption = indexOfOption;
    }
}
