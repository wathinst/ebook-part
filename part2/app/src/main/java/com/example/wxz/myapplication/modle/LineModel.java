package com.example.wxz.myapplication.modle;

import java.util.List;

public class LineModel {
    private  List<String> stringList;
    private List<Integer> strWidth;
    private List<Integer> strX;
    private int strDiff;
    private List<Integer> strColors;

    public LineModel() {
    }

    public LineModel(List<String> stringList, List<Integer> strWidth, List<Integer> strX, int strDiff, List<Integer> strColors) {
        this.stringList = stringList;
        this.strWidth = strWidth;
        this.strX = strX;
        this.strDiff = strDiff;
        this.strColors = strColors;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<Integer> getStrWidth() {
        return strWidth;
    }

    public void setStrWidth(List<Integer> strWidth) {
        this.strWidth = strWidth;
    }

    public List<Integer> getStrX() {
        return strX;
    }

    public void setStrX(List<Integer> strX) {
        this.strX = strX;
    }

    public int getStrDiff() {
        return strDiff;
    }

    public void setStrDiff(int strDiff) {
        this.strDiff = strDiff;
    }

    public List<Integer> getStrColors() {
        return strColors;
    }

    public void setStrColors(List<Integer> strColors) {
        this.strColors = strColors;
    }
}
