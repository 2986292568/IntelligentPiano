package com.zlcn.zhenling.simplepiano;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by zhenling on 2016/4/29.
 */
public class SoundSelect extends Activity {

    private String[] data={"化蝶","茉莉花","菊花台","春江花月夜","青花瓷(高难度)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_select);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        ListView listView= (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent0=new Intent(SoundSelect.this,MainActivity.class);
                        intent0.putExtra("soundNum",0);
                        setResult(RESULT_OK,intent0);
                        finish();
                    case 1:
                        Intent intent1=new Intent(SoundSelect.this,MainActivity.class);
                        intent1.putExtra("soundNum",1);
                        setResult(RESULT_OK,intent1);
                        finish();
                    case 2:
                        Intent intent2=new Intent(SoundSelect.this,MainActivity.class);
                        intent2.putExtra("soundNum",2);
                        setResult(RESULT_OK,intent2);
                        finish();
                    case 3:
                        Intent intent3=new Intent(SoundSelect.this,MainActivity.class);
                        intent3.putExtra("soundNum",3);
                        setResult(RESULT_OK,intent3);
                        finish();
                    case 4:
                        Intent intent4=new Intent(SoundSelect.this,MainActivity.class);
                        intent4.putExtra("soundNum",4);
                        setResult(RESULT_OK,intent4);
                        finish();
                }
            }
        });


    }
}
