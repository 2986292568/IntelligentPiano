package com.zlcn.zhenling.simplepiano;

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by zhenling on 2016/5/1.
 */
public class FirstActivity extends Activity{
    public final static String TAG="TAG";
    public final static String FIRST_USE="first_use";

    public static int little_star=0;
    public static int mo_li_hua=0;
    public static int low=0;
    public static int high=0;
    public  int progress=0;
    public  int pressTime=0;
    public  int score=0;
    public  int allScore =0;   //定义临时总积分
    public static String soundName;
    public static int musicMax;
    public static int musicNum;
    public int[] musicSimple;

    //按键声明
    public static Button buttonC;
    public static Button buttonD;
    public static Button buttonE;
    public static Button buttonF;
    public static Button buttonG;
    public static Button buttonA;
    public static Button buttonB;
    public static Button bugButton;       //智能提示按键
    public static Button button_HIGH;
    public static Button button_LOW;

    //音乐模块声明
    public  MediaPlayer mediaPlayer;
    public  MediaPlayer mediaPlayer_C;
    public  MediaPlayer mediaPlayer_D;
    public  MediaPlayer mediaPlayer_E;
    public  MediaPlayer mediaPlayer_F;
    public  MediaPlayer mediaPlayer_G;
    public  MediaPlayer mediaPlayer_A;
    public  MediaPlayer mediaPlayer_B;

    //界面组件声明
    public  Chronometer chronometer;
    public  ProgressBar progressBar;
    public  TextView true_text;
    public  TextView false_text;
    public  TextView true_percent_text;
    public  TextView level_text;

}
