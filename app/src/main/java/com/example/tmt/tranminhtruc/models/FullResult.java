package com.example.tmt.tranminhtruc.models;

import java.util.List;

/**
 * Created by tmtruc on 19/04/2017.
 */

public class FullResult {
    private String name;
    private List<Result> resultList;

    public FullResult(String name, List<Result> resultList) {
        this.name = name;
        this.resultList = resultList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }
}
