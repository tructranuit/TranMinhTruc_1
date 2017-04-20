package com.example.tmt.tranminhtruc.models;

import java.util.ArrayList;

/**
 * Created by tmtruc on 20/04/2017.
 */

public class Question {

    String id;
    String question;
    ArrayList<Answer> answers;

    public Question(String id, String question, ArrayList<Answer> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
