package com.example.wxz.myapplication.modle;

import java.util.List;

public class ChapterModel {
    private String name ;
    private int no;
    private List<PageModel> pageModels;
    private int index;

    public ChapterModel() {
    }

    public ChapterModel(String name, int no, List<PageModel> pageModels, int index) {
        this.name = name;
        this.no = no;
        this.pageModels = pageModels;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<PageModel> getPageModels() {
        return pageModels;
    }

    public void setPageModels(List<PageModel> pageModels) {
        this.pageModels = pageModels;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
