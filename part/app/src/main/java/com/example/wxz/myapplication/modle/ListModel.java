package com.example.wxz.myapplication.modle;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by wxz on 2018/6/3.
 *
 */

public class ListModel {

    private String chapterName;
    private int chapterNum;
    private boolean isRead;
    private long chapterIndex;
    private long chapterSize;

    public ListModel(String chapterName, int chapterNum, boolean isRead, long chapterIndex,long chapterSize ) {
        this.chapterName = chapterName;
        this.chapterNum = chapterNum;
        this.isRead = isRead;
        this.chapterIndex = chapterIndex;
        this.chapterSize = chapterSize;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public long getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(long chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    public long getChapterSize() {
        return chapterSize;
    }

    public void setChapterSize(long chapterSize) {
        this.chapterSize = chapterSize;
    }

    public void write(RandomAccessFile raf) throws IOException {
        raf.writeUTF(chapterName);
        raf.writeInt(chapterNum);
        raf.writeBoolean(isRead);
        raf.writeLong(chapterIndex);
        raf.writeLong(chapterSize);
    }

    public void read(RandomAccessFile raf) throws IOException
    {
        this.chapterName = raf.readUTF();
        this.chapterNum = raf.readInt();
        this.isRead = raf.readBoolean();
        this.chapterIndex = raf.readLong();
        this.chapterSize =raf.readLong();
    }
}
