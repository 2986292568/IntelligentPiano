package com.zlcn.zhenling.simplepiano;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends FirstActivity{

    
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //初始化音乐播放系统
        mediaPlayer=new MediaPlayer();
        mediaPlayer_C=new MediaPlayer();
        mediaPlayer_D=new MediaPlayer();
        mediaPlayer_E=new MediaPlayer();
        mediaPlayer_F=new MediaPlayer();
        mediaPlayer_G=new MediaPlayer();
        mediaPlayer_A=new MediaPlayer();
        mediaPlayer_B=new MediaPlayer();

        //初始化界面系统
        chronometer= (Chronometer) findViewById(R.id.chronometer_m);
        progressBar= (ProgressBar) findViewById(R.id.progress_bar);
        true_text= (TextView) findViewById(R.id.true_number);
        false_text= (TextView) findViewById(R.id.false_number);
        true_percent_text= (TextView) findViewById(R.id.true_percent);
        level_text= (TextView) findViewById(R.id.level);

        //小字一组按键绑定
        buttonC= (Button) findViewById(R.id.button_c);
        buttonD= (Button) findViewById(R.id.button_d);
        buttonE= (Button) findViewById(R.id.button_e);
        buttonF= (Button) findViewById(R.id.button_f);
        buttonG= (Button) findViewById(R.id.button_g);
        buttonA= (Button) findViewById(R.id.button_a);
        buttonB= (Button) findViewById(R.id.button_b);
        bugButton= (Button) findViewById(R.id.bug_button);
        button_LOW= (Button) findViewById(R.id.button_low);
        button_HIGH= (Button) findViewById(R.id.button_high);

        //初始化积分系统
        SharedPreferences firstSp=getSharedPreferences(FIRST_USE,0);
        Boolean firstUseBboolean=firstSp.getBoolean("firstUse",true);
        if(firstUseBboolean){
            SharedPreferences.Editor scoreEditor=getSharedPreferences("allScore",MODE_PRIVATE).edit();
            scoreEditor.putInt("allScore",0);
            scoreEditor.commit();
            firstSp.edit().putBoolean("firstUse",false).commit();
        }

        sound();

        button_LOW.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    low=1;
                    button_LOW.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    button_LOW.setBackgroundResource(R.drawable.button_style);
                    low=0;
                }
                return false;
            }
        });
        button_HIGH.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    high=1;
                    button_HIGH.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    button_HIGH.setBackgroundResource(R.drawable.button_style);
                    high=0;
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
                button_HIGH.setTextColor(Color.BLACK);
                button_LOW.setTextColor(Color.BLACK);
                //界面初始化
                viewInit();
                //进入歌曲选择界面
                Intent intent=new Intent(MainActivity.this,SoundSelect.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                //判断选择的歌曲
                int soundNum=data.getIntExtra("soundNum",-1);
                if(soundNum==0){
                    int[] huaDie={-3,-5,-6,1,2,-6,1,-5,5,8,6,5,3,5,2,2,2,3,-7,-6,-5,-6,1,2,-3,1,-6,-5,-6,1,-5,3,5,-7,2,-6,1,-5,-3,-5,-3,-5,-6,-7,2,-6,-5,-6,1,2,5,3,2,3,2,1,-6,-5,-3,1,-6,1,-6,-5,-3,-5,-6,1,-5};
                    musicSimple=huaDie;
                    musicMax=huaDie.length;
                    musicNum=0;
                    soundName="化蝶";
                    sound();
                    buttonE.setTextColor(Color.RED);
                    button_LOW.setTextColor(Color.RED);
                    chronometer.start();
                }
                if(soundNum==1){
                    int[] moLiHua={3,3,5,6,8,8,6,5,5,6,5,3,3,5,6,8,8,6,5,5,6,5,5,5,5,3,5,6,6,5,3,2,3,5,3,2,1,1,2,1,3,2,1,3,2,3,5,6,8,5,2,3,5,2,3,1,-6,-5,-6,1,2,3,1,2,1,-6,-5};
                    musicSimple=moLiHua;
                    musicMax=moLiHua.length;
                    musicNum=0;
                    soundName="茉莉花";
                    sound();
                    buttonE.setTextColor(Color.RED);
                    chronometer.start();
                }
                if(soundNum==2){
                    int[] juHuaTai={3,3,2,3,3,5,3,2,3,1,1,2,3,5,3,2,2,1,2,3,5,3,6,5,6,5,5,3,5,-5,3,2,2,5,3,2,2,2,1,2,3,3,2,3,3,5,3,2,3,1,1,2,3,5,3,2,2,1,2,3,5,3,6,5,6,5,5,3,5,3,2,3,5,3,2,2,1,1,2,3,3,5,6,6,10,10,9,8,6,5,6,5,3,2,1,-6,1,2,2,1,2,1,2,3,3,5,6,6,10,9,8,8,9,8,5,5,3,7,8,1,2,3,2,1};
                    musicSimple=juHuaTai;
                    musicMax=juHuaTai.length;
                    musicNum=0;
                    soundName="菊花台";
                    sound();
                    buttonE.setTextColor(Color.RED);
                    chronometer.start();
                }
                if(soundNum==3){
                    int[] chunJiangHuaYueYe={6,6,6,8,9,6,5,5,6,5,5,6,8,9,3,3,2,3,5,3,5,6,8,9,10,8,9,10,8,9,6,5,5,8,9,6,8,5,2,3,3,6,8,5,6,3,2,2,3,5,-6,-5,-6,1,2,3,2,1,2,3,1,2,2,9,9,9,10,12,10,9,8,8,9,6,5,8,10,9,10,9,10,9,9,9,10,12,10,12,10,9,8,10,9,10,8,10,9,10,8,10,9,10,8,9,10,9,8,6,5,5,6,3,5,6,8,5,5,8,9,6,8,5,4,3,2,1,3,2,3,6,8,5,6,5,3,2,3,2,1,2,3,1,2,10,10,10,12,10,10,9,2,3,6,8,5,5,8,6,8,9,6,8,5,2,3,3,6,8,5,6,5,3,2,2,3,5,3,5,3,2,8,10,9,10,8,10,9,10,8,5,6,8,9,9,10,12,10,12,10,9,8,8,8,8,9,10,6,6,6,8,5,3,3,3,5,3,3,3,5,6,8,9,10,8,9,10,9,8,6,5,5,6,5,5,6,8,9,3,3,6,8,5,6,5,3,2,3,2,1,2,3,1,2,2};
                    musicSimple=chunJiangHuaYueYe;
                    musicMax=chunJiangHuaYueYe.length;
                    musicNum=0;
                    soundName="春江花月夜";
                    sound();
                    buttonA.setTextColor(Color.RED);
                    chronometer.start();
                }
                if(soundNum==4){
                    int[] qingHuaCi={2,1,-6,1,1,-6,1,1,-6,1,-6,-5,2,1,-6,1,1,-6,1,1,3,2,1,1,-5,-6,3,3,3,2,3,3,2,3,5,3,3,3,3,3,2,2,2,2,2,1,3,3,2,2,1,-6,1,1,-6,1,1,-6,1,-6,-5,-5,-6,3,5,5,3,5,5,3,2,1,1,2,1,2,3,2,2,1,2,1,-6,2,1,1,-6,1,1,1,1,5,5,3,2,3,-6,2,3,5,3,2,5,5,3,2,3,-5,2,3,5,2,1,1,2,3,5,6,3,4,5,3,3,2,2,1,2,1,1,2,1,2,2,3,5,3,3,5,5,3,2,3,-6,2,3,5,3,2,5,5,3,2,3,-5,2,3,5,2,1,1,2,3,5,6,3,4,5,3,3,2,2,-5,3,2,2,2,1,1,3,5,6,5,3,2,1,2,5,5,2,1,1,2,3,2,1,-6,1,2,3,6,5,2,1,-6,2,1,5,5,3,2,3,-6,2,3,5,3,2,5,5,3,2,3,-5,2,3,5,2,1,1,2,3,5,6,3,4,5,3,3,2,2,1,2,1,1,2,1,2,2,3,5,3,3,5,5,3,2,3,-6,2,3,5,3,2,5,5,3,2,3,-5,2,3,5,2,1,1,2,3,5,6,3,4,5,3,3,2,2,-5,3,2,2,2,1,1};
                    musicSimple=qingHuaCi;
                    musicMax=qingHuaCi.length;
                    musicNum=0;
                    soundName="青花瓷";
                    sound();
                    buttonD.setTextColor(Color.RED);
                    chronometer.start();
                }

            }
        }
    }

    //音乐播放
    private void play(int position) {
        try{
            mediaPlayer.release();
            mediaPlayer=MediaPlayer.create(this,position);
            mediaPlayer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //界面初始化
    private void viewInit(){
        //歌曲初始化
        little_star=0;
        mo_li_hua=0;
        pressTime=0;
        progress=0;
        progressBar.setProgress(0);
        true_text.setText("正确个数:0");
        false_text.setText("错误个数:0");
        true_percent_text.setText("正确率:0");
        chronometer.setBase(SystemClock.elapsedRealtime());
    }

    //正确个数、错误个数、正确率判断
    private void turePercent(int musicNum){
            progress=(musicNum+1)*100/musicMax;
            progressBar.setProgress(progress);
            true_text.setText("正确个数:"+(musicNum+1));
            false_text.setText("错误个数:"+(pressTime-musicNum-1));
            true_percent_text.setText("正确率:"+((musicNum+1)*100/pressTime));
    }

    //计算总分数和显示提示信息
    private void scoreSum(int musicMax){
        score=musicMax*10-(pressTime-musicMax)*20-(int)((SystemClock.elapsedRealtime()-chronometer.getBase())/200);
        SharedPreferences scoreSp=getSharedPreferences("allScore",MODE_PRIVATE);
        allScore =scoreSp.getInt("allScore",0)+score;           //计算总分数
        scoreSp.edit().putInt("allScore", allScore).commit();
        //设置提示信息
        AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("恭喜您已成功完成"+soundName+"的演奏");
        dialog.setMessage("您获得了"+score+"积分");
        dialog.setCancelable(false);
        dialog.setNeutralButton("好的", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(allScore <500){
                    level_text.setText("当前段位:初学弟子");
                }else if(allScore >=500&& allScore <1500){
                    level_text.setText("当前段位:江湖新秀");
                }else if(allScore >=1500&& allScore <3000){
                    level_text.setText("当前段位:江湖大侠");
                }else if(allScore >=3000&& allScore <5000){
                    level_text.setText("当前段位:江湖大侠");
                }else if(allScore >=5000& allScore <=8000){
                    level_text.setText("当前段位:一派掌门");
                }else if (allScore >=8000&& allScore <15000){
                    level_text.setText("当前段位:一代宗师");
                }else if (allScore >=15000){
                    level_text.setText("当前段位:独孤求败");
                }
            }
        });
        dialog.show();
    }

    private void sound(){
        //小字一组按键监听事件
        buttonC.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    pressTime++;
                    if (high != 0 && low == 0) {
                        if (mediaPlayer_C.isPlaying()) {
                            play(R.raw.c_h);
                        } else {
                            mediaPlayer_C.release();
                            mediaPlayer_C = MediaPlayer.create(MainActivity.this, R.raw.c_h);
                            mediaPlayer_C.start();
                        }
                    } else if (high == 0 && low != 0) {
                        if (mediaPlayer_C.isPlaying()) {
                            play(R.raw.c_l);
                        } else {
                            mediaPlayer_C.release();
                            mediaPlayer_C = MediaPlayer.create(MainActivity.this, R.raw.c_l);
                            mediaPlayer_C.start();
                        }
                    } else {
                        if (mediaPlayer_C.isPlaying()) {
                            play(R.raw.c);
                        } else {
                            mediaPlayer_C.release();
                            mediaPlayer_C = MediaPlayer.create(MainActivity.this, R.raw.c);
                            mediaPlayer_C.start();
                        }
                    }
                    buttonC.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonC.setBackgroundResource(R.drawable.button_style);
                    if(high!=0&&low==0){                 //检查按键是否正确
                        checkMusic(8);
                    }else if(high==0&&low!=0){
                        checkMusic(-1);
                    }else{
                        checkMusic(1);
                    }
                }
                return false;
            }
        });
        buttonD.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    pressTime++;
                    if (high != 0 && low == 0) {
                        if (mediaPlayer_D.isPlaying()) {
                            play(R.raw.d_h);
                        } else {
                            mediaPlayer_D.release();
                            mediaPlayer_D = MediaPlayer.create(MainActivity.this, R.raw.d_h);
                            mediaPlayer_D.start();
                        }
                    } else if (high == 0 && low != 0) {
                        if (mediaPlayer_D.isPlaying()) {
                            play(R.raw.d_l);
                        } else {
                            mediaPlayer_D.release();
                            mediaPlayer_D = MediaPlayer.create(MainActivity.this, R.raw.d_l);
                            mediaPlayer_D.start();
                        }
                    } else {
                        if (mediaPlayer_D.isPlaying()) {
                            play(R.raw.d);
                        } else {
                            mediaPlayer_D.release();
                            mediaPlayer_D = MediaPlayer.create(MainActivity.this, R.raw.d);
                            mediaPlayer_D.start();
                        }
                    }
                    buttonD.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonD.setBackgroundResource(R.drawable.button_style);
                    if(high!=0&&low==0){                 //检查按键是否正确
                        checkMusic(9);
                    }else if(high==0&&low!=0){
                        checkMusic(-2);
                    }else{
                        checkMusic(2);
                    }
                }
                return false;
            }
        });
        buttonE.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    pressTime++;
                    if (high != 0 && low == 0) {
                        if (mediaPlayer_E.isPlaying()) {
                            play(R.raw.e_h);
                        } else {
                            mediaPlayer_E.release();
                            mediaPlayer_E = MediaPlayer.create(MainActivity.this, R.raw.e_h);
                            mediaPlayer_E.start();
                        }

                    } else if (high == 0 && low != 0) {
                        if (mediaPlayer_E.isPlaying()) {
                            play(R.raw.e_l);
                        } else {
                            mediaPlayer_E.release();
                            mediaPlayer_E = MediaPlayer.create(MainActivity.this, R.raw.e_l);
                            mediaPlayer_E.start();
                        }
                    } else {
                        if (mediaPlayer_E.isPlaying()) {
                            play(R.raw.e);
                        } else {
                            mediaPlayer_E.release();
                            mediaPlayer_E = MediaPlayer.create(MainActivity.this, R.raw.e);
                            mediaPlayer_E.start();
                        }
                    }
                    buttonE.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonE.setBackgroundResource(R.drawable.button_style);
                    if(high!=0&&low==0){                 //检查按键是否正确
                        checkMusic(10);
                    }else if(high==0&&low!=0){
                        checkMusic(-3);
                    }else{
                        checkMusic(3);
                    }
                }
                return false;
            }
        });
        buttonF.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    pressTime++;
                    if (high != 0 && low == 0) {
                        if (mediaPlayer_F.isPlaying()) {
                            play(R.raw.f_h);
                        } else {
                            mediaPlayer_F.release();
                            mediaPlayer_F = MediaPlayer.create(MainActivity.this, R.raw.f_h);
                            mediaPlayer_F.start();
                        }
                    } else if (high == 0 && low != 0) {
                        if (mediaPlayer_F.isPlaying()) {
                            play(R.raw.f_l);
                        } else {
                            mediaPlayer_F.release();
                            mediaPlayer_F = MediaPlayer.create(MainActivity.this, R.raw.f_l);
                            mediaPlayer_F.start();
                        }
                    } else {
                        if (mediaPlayer_F.isPlaying()) {
                            play(R.raw.f);
                        } else {
                            mediaPlayer_F.release();
                            mediaPlayer_F = MediaPlayer.create(MainActivity.this, R.raw.f);
                            mediaPlayer_F.start();
                        }
                    }
                    buttonF.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonF.setBackgroundResource(R.drawable.button_style);
                    if(high!=0&&low==0){                 //检查按键是否正确
                        checkMusic(11);
                    }else if(high==0&&low!=0){
                        checkMusic(-4);
                    }else{
                        checkMusic(1);
                    }
                }
                return false;
            }
        });
        buttonG.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    pressTime++;
                    if (high != 0 && low == 0) {
                        if (mediaPlayer_G.isPlaying()) {
                            play(R.raw.g_h);
                        } else {
                            mediaPlayer_G.release();
                            mediaPlayer_G = MediaPlayer.create(MainActivity.this, R.raw.g_h);
                            mediaPlayer_G.start();
                        }
                    } else if (high == 0 && low != 0) {
                        if (mediaPlayer_G.isPlaying()) {
                            play(R.raw.g_l);
                        } else {
                            mediaPlayer_G.release();
                            mediaPlayer_G = MediaPlayer.create(MainActivity.this, R.raw.g_l);
                            mediaPlayer_G.start();
                        }
                    } else {
                        if (mediaPlayer_G.isPlaying()) {
                            play(R.raw.g);
                        } else {
                            mediaPlayer_G.release();
                            mediaPlayer_G = MediaPlayer.create(MainActivity.this, R.raw.g);
                            mediaPlayer_G.start();
                        }
                    }
                    buttonG.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonG.setBackgroundResource(R.drawable.button_style);
                    if(high!=0&&low==0){                 //检查按键是否正确
                        checkMusic(12);
                    }else if(high==0&&low!=0){
                        checkMusic(-5);
                    }else{
                        checkMusic(5);
                    }
                }
                return false;
            }
        });
        buttonA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    pressTime++;
                    if (high != 0 && low == 0) {
                        if (mediaPlayer_A.isPlaying()) {
                            play(R.raw.a_h);
                        } else {
                            mediaPlayer_A.release();
                            mediaPlayer_A = MediaPlayer.create(MainActivity.this, R.raw.a_h);
                            mediaPlayer_A.start();
                        }
                    } else if (high == 0 && low != 0) {
                        if (mediaPlayer_A.isPlaying()) {
                            play(R.raw.a_l);
                        } else {
                            mediaPlayer_A.release();
                            mediaPlayer_A = MediaPlayer.create(MainActivity.this, R.raw.a_l);
                            mediaPlayer_A.start();
                        }
                    } else {
                        if (mediaPlayer_A.isPlaying()) {
                            play(R.raw.a);
                        } else {
                            mediaPlayer_A.release();
                            mediaPlayer_A = MediaPlayer.create(MainActivity.this, R.raw.a);
                            mediaPlayer_A.start();
                        }
                    }
                    buttonA.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonA.setBackgroundResource(R.drawable.button_style);
                    if(high!=0&&low==0){                 //检查按键是否正确
                        checkMusic(13);
                    }else if(high==0&&low!=0){
                        checkMusic(-6);
                    }else{
                        checkMusic(6);
                    }
                }
                return false;
            }
        });
        buttonB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    pressTime++;
                    if (high != 0 && low == 0) {
                        if (mediaPlayer_B.isPlaying()) {
                            play(R.raw.b_h);
                        } else {
                            mediaPlayer_B.release();
                            mediaPlayer_B = MediaPlayer.create(MainActivity.this, R.raw.b_h);
                            mediaPlayer_B.start();
                        }
                    } else if (high == 0 && low != 0) {
                        if (mediaPlayer_B.isPlaying()) {
                            play(R.raw.b_l);
                        } else {
                            mediaPlayer_B.release();
                            mediaPlayer_B = MediaPlayer.create(MainActivity.this, R.raw.b_l);
                            mediaPlayer_B.start();
                        }
                    } else {
                        if (mediaPlayer_B.isPlaying()) {
                            play(R.raw.b);
                        } else {
                            mediaPlayer_B.release();
                            mediaPlayer_B = MediaPlayer.create(MainActivity.this, R.raw.b);
                            mediaPlayer_B.start();
                        }
                    }
                    buttonB.setBackgroundResource(R.drawable.button_pressed_style);
                }
                if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonB.setBackgroundResource(R.drawable.button_style);
                    if(high!=0&&low==0){                 //检查按键是否正确
                        checkMusic(14);
                    }else if(high==0&&low!=0){
                        checkMusic(-7);
                    }else{
                        checkMusic(7);
                    }
                }
                return false;
            }
        });
    }

    //检查按键是否正确
    private void checkMusic(int buttonNum){
        if(musicNum==musicMax){
        }else if(musicNum==(musicMax-1)&&musicSimple[musicNum]==buttonNum){
            turePercent(musicNum);     //正确个数判断
            SoundTool soundTool=new SoundTool();
            soundTool.UnUseSoundTool(musicSimple[musicNum]);
            chronometer.stop();
            scoreSum(musicMax);
            viewInit();
            musicNum++;
        }else if(musicNum!=(musicMax-1)&&musicSimple[musicNum]==buttonNum){
            turePercent(musicNum);     //正确个数判断
            SoundTool soundTool=new SoundTool();
            soundTool.UnUseSoundTool(musicSimple[musicNum]);
            soundTool.UseSoundTool(musicSimple[musicNum+1]);
            musicNum++;
            sound();
        } else{
            turePercent(musicNum-1);     //正确个数判断
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