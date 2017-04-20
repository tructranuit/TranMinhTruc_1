package com.example.tmt.tranminhtruc.models;

/**
 * Created by tmtruc on 20/04/2017.
 */

public class Answer {
    String id;
    String text;

    public Answer(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

