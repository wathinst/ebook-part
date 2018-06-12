package com.example.wxz.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.wxz.myapplication.R;
import com.example.wxz.myapplication.customizeView.ReadView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadActivity extends AppCompatActivity {

    ReadView readView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        readView = (ReadView) findViewById(R.id.read_view);

        try {
            InputStream is = getResources().openRawResource(R.raw.mbook);
            String text = readTextFromSDcard(is);
            readView.setText(text);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        readView.setOnItemSelectListener(new ReadView.OnItemSelectListener() {
            @Override
            public void onItemSelect(int index) {
                if (index==0){
                    readView.PageDn();
                }else {
                    readView.PageUp();
                }
            }
        });
    }

    private String readTextFromSDcard(InputStream is) throws Exception {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
            buffer.append("\n");
        }
        return buffer.toString();
    }

}
