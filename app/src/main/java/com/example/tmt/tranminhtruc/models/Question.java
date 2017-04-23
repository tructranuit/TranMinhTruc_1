package com.example.tmt.tranminhtruc.models;

import java.util.ArrayList;

/**
 * Created by tmtruc on 20/04/2017.
 */

public class Question {

    int id;
    String question;
    ArrayList<Answer> answers;
    String currentAnswer;
    int currentAnswerPositon;
    public static final String NONE = null;

    public Question(int id, String question, ArrayList<Answer> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(String currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    public int getCurrentAnswerPositon() {
        return currentAnswerPositon;
    }

    public void setCurrentAnswerPositon(int currentAnswerPositon) {
        this.currentAnswerPositon = currentAnswerPositon;
    }
}
