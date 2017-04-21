package com.example.tmt.tranminhtruc.models;

/**
 * Created by tmtruc on 19/04/2017.
 */

public class Result {
    private int questionID;
    private String answer;


    public Result() {
    }

    public Result(int questionID, String answer) {
        this.questionID = questionID;
        this.answer = answer;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
