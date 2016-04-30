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

    private String[] data={"小星星","茉莉花"};

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
                }
            }
        });


    }
}
