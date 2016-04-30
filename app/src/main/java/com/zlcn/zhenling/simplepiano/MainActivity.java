package com.zlcn.zhenling.simplepiano;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{


    public final static String TAG="TAG";

    public int little_star=0;
    public int mo_li_hua=0;

    private Button buttonC;
    private Button buttonD;
    private Button buttonE;
    private Button buttonF;
    private Button buttonG;
    private Button buttonA;
    private Button buttonB;

    private Button buttonC_L;
    private Button buttonD_L;
    private Button buttonE_L;
    private Button buttonF_L;
    private Button buttonG_L;
    private Button buttonA_L;
    private Button buttonB_L;

    private Button buttonC_H;
    private Button buttonD_H;
    private Button buttonE_H;
    private Button buttonF_H;
    private Button buttonG_H;
    private Button buttonA_H;
    private Button buttonB_H;

    private Button bugButton;
    private MediaPlayer mediaPlayer;

    String APP_FIRST_USE="app_first_use";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mediaPlayer=new MediaPlayer();
        //小字一组按键绑定
        buttonC= (Button) findViewById(R.id.button_c);
        buttonD= (Button) findViewById(R.id.button_d);
        buttonE= (Button) findViewById(R.id.button_e);
        buttonF= (Button) findViewById(R.id.button_f);
        buttonG= (Button) findViewById(R.id.button_g);
        buttonA= (Button) findViewById(R.id.button_a);
        buttonB= (Button) findViewById(R.id.button_b);
        bugButton= (Button) findViewById(R.id.bug_button);
        //小字组按键绑定
        buttonC_L= (Button) findViewById(R.id.button_c_l);
        buttonD_L= (Button) findViewById(R.id.button_d_l);
        buttonE_L= (Button) findViewById(R.id.button_e_l);
        buttonF_L= (Button) findViewById(R.id.button_f_l);
        buttonG_L= (Button) findViewById(R.id.button_g_l);
        buttonA_L= (Button) findViewById(R.id.button_a_l);
        buttonB_L= (Button) findViewById(R.id.button_b_l);
        //小字二组按键绑定
        buttonC_H= (Button) findViewById(R.id.button_c_h);
        buttonD_H= (Button) findViewById(R.id.button_d_h);
        buttonE_H= (Button) findViewById(R.id.button_e_h);
        buttonF_H= (Button) findViewById(R.id.button_f_h);
        buttonG_H= (Button) findViewById(R.id.button_g_h);
        buttonA_H= (Button) findViewById(R.id.button_a_h);
        buttonB_H= (Button) findViewById(R.id.button_b_h);


        //小字一组按键监听事件
        buttonC.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    play(R.raw.c);
                    buttonC.setBackgroundResource(R.drawable.button_pressed_style);
                    if(little_star==2){
                        little_star++;
                        buttonC.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(little_star==14){
                        little_star++;
                        buttonC.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(little_star==30){
                        little_star++;
                        buttonC.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(little_star==42){
                        little_star++;
                        buttonC.setTextColor(Color.BLACK);
                        Toast.makeText(MainActivity.this,"恭喜您已成功演奏完小星星",Toast.LENGTH_SHORT).show();
                    }
                    if(mo_li_hua==38){
                        mo_li_hua++;
                        buttonC.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==40){
                        mo_li_hua++;
                        buttonC.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==43){
                        mo_li_hua++;
                        buttonC.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==56){
                        mo_li_hua++;
                        buttonC.setTextColor(Color.BLACK);
                        buttonA_L.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==60){
                        mo_li_hua++;
                        buttonC.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==63){
                        mo_li_hua++;
                        buttonC.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==65){
                        mo_li_hua++;
                        buttonC.setTextColor(Color.BLACK);
                        buttonA_L.setTextColor(Color.RED);
                    }
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonC.setBackgroundResource(R.drawable.button_style);
                    if(little_star==1){
                        little_star++;
                    }
                    if(little_star==29){
                        little_star++;
                    }
                    if(little_star==42){
                        little_star++;
                    }
                    if(mo_li_hua==37){
                        mo_li_hua++;
                    }
                }
                return false;
            }
        });
        buttonD.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    play(R.raw.d);
                    buttonD.setBackgroundResource(R.drawable.button_pressed_style);
                    if(little_star==13){
                        little_star++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonC.setTextColor(Color.RED);
                    }
                    if(little_star==21){
                        little_star++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(little_star==28){
                        little_star++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonC.setTextColor(Color.RED);
                    }
                    if(little_star==41){
                        little_star++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonC.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==32){
                        mo_li_hua++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==36){
                        mo_li_hua++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonC.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==39){
                        mo_li_hua++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonC.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==42){
                        mo_li_hua++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonC.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==45){
                        mo_li_hua++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==51){
                        mo_li_hua++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==54){
                        mo_li_hua++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==61){
                        mo_li_hua++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==64){
                        mo_li_hua++;
                        buttonD.setTextColor(Color.BLACK);
                        buttonC.setTextColor(Color.RED);
                    }
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonD.setBackgroundResource(R.drawable.button_style);
                    if(little_star==12){
                        little_star++;
                    }
                    if(little_star==40){
                        little_star++;
                    }
                }
                return false;
            }
        });
        buttonE.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    play(R.raw.e);
                    buttonE.setBackgroundResource(R.drawable.button_pressed_style);
                    if(little_star==11){
                        little_star++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(little_star==20){
                        little_star++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(little_star==27){
                        little_star++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(little_star==39){
                        little_star++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==2){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==13){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==26){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==31){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==33){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==35){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==41){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==44){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==46){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==52){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==55){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonC.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==62){
                        mo_li_hua++;
                        buttonE.setTextColor(Color.BLACK);
                        buttonC.setTextColor(Color.RED);
                    }
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonE.setBackgroundResource(R.drawable.button_style);
                    if(little_star==10){
                        little_star++;
                    }
                    if(little_star==19){
                        little_star++;
                    }
                    if(little_star==26){
                        little_star++;
                    }
                    if(little_star==38){
                        little_star++;
                    }
                    if(mo_li_hua==1){
                        mo_li_hua++;
                    }
                    if(mo_li_hua==12){
                        mo_li_hua++;
                    }
                }
                return false;
            }
        });
        buttonF.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    play(R.raw.f);
                    buttonF.setBackgroundResource(R.drawable.button_pressed_style);
                    if(little_star==9){
                        little_star++;
                        buttonF.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(little_star==18){
                        little_star++;
                        buttonF.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(little_star==25){
                        little_star++;
                        buttonF.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(little_star==37){
                        little_star++;
                        buttonF.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonF.setBackgroundResource(R.drawable.button_style);
                    if(little_star==8){
                        little_star++;
                    }
                    if(little_star==17){
                        little_star++;
                    }
                    if(little_star==24){
                        little_star++;
                    }
                    if(little_star==36){
                        little_star++;
                    }
                }
                return false;
            }
        });
        buttonG.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    play(R.raw.g);
                    buttonG.setBackgroundResource(R.drawable.button_pressed_style);
                    if(little_star==4){
                        little_star++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonA.setTextColor(Color.RED);
                    }
                    if(little_star==7){
                        little_star++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonF.setTextColor(Color.RED);
                    }
                    if(little_star==16){
                        little_star++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonF.setTextColor(Color.RED);
                    }
                    if(little_star==23){
                        little_star++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonF.setTextColor(Color.RED);
                    }
                    if(little_star==32){
                        little_star++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonA.setTextColor(Color.RED);
                    }
                    if(little_star==35){
                        little_star++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonF.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==3){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonA.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==9){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonA.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==11){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==14){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonA.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==20){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonA.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==25){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==27){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonA.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==30){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==34){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonE.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==47){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonA.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==50){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==53){
                        mo_li_hua++;
                        buttonG.setTextColor(Color.BLACK);
                        buttonD.setTextColor(Color.RED);
                    }
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonG.setBackgroundResource(R.drawable.button_style);
                    if(little_star==3){
                        little_star++;
                    }
                    if(little_star==15){
                        little_star++;
                    }
                    if(little_star==22){
                        little_star++;
                    }
                    if(little_star==31){
                        little_star++;
                    }
                    if(mo_li_hua==8){
                        mo_li_hua++;
                    }
                    if (mo_li_hua==19){
                        mo_li_hua++;
                    }
                    if(mo_li_hua==24){
                        mo_li_hua++;
                    }
                    if(mo_li_hua==23){
                        mo_li_hua++;
                    }
                    if(mo_li_hua==22){
                        mo_li_hua++;
                    }
                }
                return false;
            }
        });
        buttonA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    play(R.raw.a);
                    buttonA.setBackgroundResource(R.drawable.button_pressed_style);
                    if(little_star==6){
                        little_star++;
                        buttonA.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(little_star==34){
                        little_star++;
                        buttonA.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==4){
                        mo_li_hua++;
                        buttonA.setTextColor(Color.BLACK);
                        buttonC_H.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==7){
                        mo_li_hua++;
                        buttonA.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==10){
                        mo_li_hua++;
                        buttonA.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==15){
                        mo_li_hua++;
                        buttonA.setTextColor(Color.BLACK);
                        buttonC_H.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==18){
                        mo_li_hua++;
                        buttonA.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==21){
                        mo_li_hua++;
                        buttonA.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==29){
                        mo_li_hua++;
                        buttonA.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==48){
                        mo_li_hua++;
                        buttonA.setTextColor(Color.BLACK);
                        buttonC_H.setTextColor(Color.RED);
                    }
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonA.setBackgroundResource(R.drawable.button_style);
                    if(little_star==5){
                        little_star++;
                    }
                    if(little_star==33){
                        little_star++;
                    }
                    if(mo_li_hua==28){
                        mo_li_hua++;
                    }
                }
                return false;
            }
        });
        buttonB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    play(R.raw.b);
                    buttonB.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonB.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        //小字组按键监听事件
        buttonC_L.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.c_l);
                    buttonC_L.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonC_L.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        buttonD_L.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.d_l);
                    buttonD_L.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonD_L.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        buttonE_L.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.e_l);
                    buttonE_L.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonE_L.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        buttonF_L.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.f_l);
                    buttonF_L.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonF_L.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        buttonG_L.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.g_l);
                    buttonG_L.setBackgroundResource(R.drawable.button_pressed_style);
                    if(mo_li_hua==58){
                        mo_li_hua++;
                        buttonG_L.setTextColor(Color.BLACK);
                        buttonA_L.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==67){
                        mo_li_hua++;
                        buttonG_L.setTextColor(Color.BLACK);
                        Toast.makeText(MainActivity.this,"恭喜您已成功演奏完茉莉花！",Toast.LENGTH_SHORT).show();
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonG_L.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        buttonA_L.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.a_l);
                    buttonA_L.setBackgroundResource(R.drawable.button_pressed_style);
                    if(mo_li_hua==57){
                        mo_li_hua++;
                        buttonA_L.setTextColor(Color.BLACK);
                        buttonG_L.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==59){
                        mo_li_hua++;
                        buttonA_L.setTextColor(Color.BLACK);
                        buttonC.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==66){
                        mo_li_hua++;
                        buttonA_L.setTextColor(Color.BLACK);
                        buttonG_L.setTextColor(Color.RED);
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonA_L.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        buttonB_L.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.b_l);
                    buttonB_L.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonB_L.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        //小字二组按键监听事件
        buttonC_H.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.c_h);
                    buttonC_H.setBackgroundResource(R.drawable.button_pressed_style);
                    if(mo_li_hua==6){
                        mo_li_hua++;
                        buttonC_H.setTextColor(Color.BLACK);
                        buttonA.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==17){
                        mo_li_hua++;
                        buttonC_H.setTextColor(Color.BLACK);
                        buttonA.setTextColor(Color.RED);
                    }
                    if(mo_li_hua==49){
                        mo_li_hua++;
                        buttonC_H.setTextColor(Color.BLACK);
                        buttonG.setTextColor(Color.RED);
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonC_H.setBackgroundResource(R.drawable.button_style);
                    if(mo_li_hua==5){
                        mo_li_hua++;
                    }
                    if(mo_li_hua==16){
                        mo_li_hua++;
                    }
                }
                return false;
            }
        });
        buttonD_H.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.d_h);
                    buttonD_H.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonD_H.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        buttonE_H.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.e_h);
                    buttonE_H.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonE_H.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        buttonF_H.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.f_h);
                    buttonF_H.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonF_H.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        buttonG_H.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.g_h);
                    buttonG_H.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonG_H.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        buttonA_H.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.a_h);
                    buttonA_H.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonA_H.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });
        buttonB_H.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    play(R.raw.b_h);
                    buttonB_H.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonB_H.setBackgroundResource(R.drawable.button_style);
                }
                return false;
            }
        });




        bugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将button颜色初始化
                buttonC.setTextColor(Color.BLACK);
                buttonD.setTextColor(Color.BLACK);
                buttonE.setTextColor(Color.BLACK);
                buttonF.setTextColor(Color.BLACK);
                buttonG.setTextColor(Color.BLACK);
                buttonA.setTextColor(Color.BLACK);
                buttonB.setTextColor(Color.BLACK);
                //歌曲初始化
                little_star=0;
                //进入歌曲选择界面
                Intent intent=new Intent(MainActivity.this,SoundSelect.class);
                startActivityForResult(intent,1);
            }
        });
    }

    //音乐播放
    private void play(int position) {
        try{
                mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(MainActivity.this,position);
                mediaPlayer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                int soundNum=data.getIntExtra("soundNum",-1);
                if(soundNum==0){
                    buttonC.setTextColor(Color.RED);
                    little_star=1;
                }
                if(soundNum==1){
                    buttonE.setTextColor(Color.RED);
                    mo_li_hua=1;
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}
