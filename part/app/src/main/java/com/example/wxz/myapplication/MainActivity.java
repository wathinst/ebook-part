package com.example.wxz.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.wxz.myapplication.modle.ListModel;
import com.example.wxz.myapplication.modle.StrModel;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    TextView readView;
    String chapter1 =  "    随机流（RandomAccessFile）不属于IO流，支持对文件的读取和写入随机访问。\n" ;
    String chapter2 =  "    首先把随机访问的文件对象看作存储在文件系统中的一个大型 byte 数组，然后通过指向该 byte 数组的光标或索引" +
            "（即：文件指针 FilePointer）在该数组任意位置读取或写入任意数据。\n" ;
    String chapter3 =  "    1、对象声明：RandomAccessFile raf = newRandomAccessFile(File file, String mode);\n" +
            "       其中参数 mode 的值可选 \"r\"：可读，\"w\" ：可写，\"rw\"：可读性；\n" +
            "    2、获取当前文件指针位置：int RandowAccessFile.getFilePointer();\n" +
            "    3、改变文件指针位置（相对位置、绝对位置）：\n" +
            "        1> 绝对位置：RandowAccessFile.seek(int index);\n" +
            "        2> 相对位置：RandowAccessFile.skipByte(int step); 相对当前位置\n" +
            "    4、给写入文件预留空间：RandowAccessFile.setLength(long len);";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        readView = (TextView) findViewById(R.id.read_view);
        setSupportActionBar(toolbar);

        try {
            readStr();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readStr() throws IOException {
        RandomAccessFile file = new RandomAccessFile(this.getFilesDir()+ "test.xkr","rw");
        StrModel strModel = new StrModel();
        strModel = eBookInit(strModel);
        strModel.write(file);

        file.seek(0);
        StrModel strModel1 = new StrModel();
        strModel1.read(file);
        String ebook = "";
        for (int i=0;i<strModel1.getListContent().size();i++){
            ebook = ebook + "第" + strModel1.getListContent().get(i).getChapterNum() + "节"
                    + "： " + strModel1.getListContent().get(i).getChapterName() + "\n"
                    + getChapterStr(file,strModel1,i) +"\n";
        }
        readView.setText(ebook);
    }

    public StrModel eBookInit(StrModel strModel){
        long strIndex = 0;
        strModel.setReadIndex(0);
        ListModel listModel1 = new ListModel("作用",1,false,strIndex,chapter1.getBytes().length);
        strIndex += chapter1.getBytes().length;
        ListModel listModel2 = new ListModel("随机访问文件原理",2,false,strIndex,chapter2.getBytes().length);
        strIndex += chapter2.getBytes().length;
        ListModel listModel3 = new ListModel("相关方法说明",3,false,strIndex,chapter3.getBytes().length);
        List<ListModel> listModels = new ArrayList<>();
        listModels.add(listModel1);
        listModels.add(listModel2);
        listModels.add(listModel3);
        strModel.setListNum(listModels.size());
        strModel.setListContent(listModels);
        strModel.setListSize(listModels.size());
        strModel.setStrContent(chapter1+chapter2+chapter3);
        return strModel;
    }

    public String getChapterStr (RandomAccessFile file,StrModel strModel,int i) throws IOException {
        file.seek(strModel.getStartIndex()+strModel.getListContent().get(i).getChapterIndex());
        byte[] buff = new byte[1024];
        file.read(buff,0,(int)strModel.getListContent().get(i).getChapterSize());
        return new  String(buff);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
