package com.example.wxz.myapplication.modle;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxz on 2018/6/2.
 *
 */

public class StrModel {
    private long listSize;
    private int listNum;
    private long readIndex;
    private List<ListModel> listContent;
    private long startIndex;
    private String strContent;

    public long getListSize() {
        return listSize;
    }

    public void setListSize(long listSize) {
        this.listSize = listSize;
    }

    public int getListNum() {
        return listNum;
    }

    public void setListNum(int listNum) {
        this.listNum = listNum;
    }

    public long getReadIndex() {
        return readIndex;
    }

    public void setReadIndex(long readIndex) {
        this.readIndex = readIndex;
    }

    public List<ListModel> getListContent() {
        return listContent;
    }

    public void setListContent(List<ListModel> listContent) {
        this.listContent = listContent;
    }

    public long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(long startIndex) {
        this.startIndex = startIndex;
    }

    public String getStrContent() {
        return strContent;
    }

    public void setStrContent(String strContent) {
        this.strContent = strContent;
    }

    public void write(RandomAccessFile raf) throws IOException {
        raf.writeLong(listSize);
        raf.writeInt(listNum);
        raf.writeLong(readIndex);
        for(int i=0;i<listContent.size();i++) {
            ListModel listModel =listContent.get(i);
            listModel.write(raf);
        }
        this.startIndex = raf.getFilePointer()+10;
        raf.writeLong(startIndex);
        raf.writeUTF(strContent);
    }
    public void read(RandomAccessFile raf) throws IOException
    {
        this.listSize = raf.readLong();
        this.listNum = raf.readInt();
        this.readIndex = raf.readLong();
        List<ListModel> listModels =new ArrayList<>();
        for(int i=0;i<listNum;i++) {
            ListModel listModel =new ListModel("",0,false,0,0);
            listModel.read(raf);
            listModels.add(listModel);
        }
        this.listContent = listModels;
        this.startIndex = raf.readLong();
        this.strContent = raf.readUTF();
    }
}
