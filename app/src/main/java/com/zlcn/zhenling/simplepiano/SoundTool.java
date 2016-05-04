package com.zlcn.zhenling.simplepiano;

import android.app.Activity;
import android.graphics.Color;
import android.widget.Button;

/**
 * Created by zhenling on 2016/5/1.
 */
public class SoundTool extends Activity {
    private Button buttonC;
    private Button buttonD;
    private Button buttonE;
    private Button buttonF;
    private Button buttonG;
    private Button buttonA;
    private Button buttonB;
    private Button button_HIGH;
    private Button button_LOW;

    public void UseSoundTool(int sound){
        buttonC=MainActivity.buttonC;
        buttonD=MainActivity.buttonD;
        buttonE=MainActivity.buttonE;
        buttonF=MainActivity.buttonF;
        buttonG=MainActivity.buttonG;
        buttonA=MainActivity.buttonA;
        buttonB=MainActivity.buttonB;
        button_HIGH=MainActivity.button_HIGH;
        button_LOW=MainActivity.button_LOW;

        if(sound==1){
            buttonC.setTextColor(Color.RED);
        }
        if(sound==2){
            buttonD.setTextColor(Color.RED);
        }
        if(sound==3){
            buttonE.setTextColor(Color.RED);
        }
        if(sound==4){
            buttonF.setTextColor(Color.RED);
        }
        if(sound==5){
            buttonG.setTextColor(Color.RED);
        }
        if(sound==6){
            buttonA.setTextColor(Color.RED);
        }
        if(sound==7){
            buttonB.setTextColor(Color.RED);
        }
        if(sound==8){
            buttonC.setTextColor(Color.RED);
            button_HIGH.setTextColor(Color.RED);
        }
        if(sound==9){
            buttonD.setTextColor(Color.RED);
            button_HIGH.setTextColor(Color.RED);
        }
        if(sound==10){
            buttonE.setTextColor(Color.RED);
            button_HIGH.setTextColor(Color.RED);
        }
        if(sound==11){
            buttonF.setTextColor(Color.RED);
            button_HIGH.setTextColor(Color.RED);
        }
        if(sound==12){
            buttonG.setTextColor(Color.RED);
            button_HIGH.setTextColor(Color.RED);
        }
        if(sound==13){
            buttonA.setTextColor(Color.RED);
            button_HIGH.setTextColor(Color.RED);
        }
        if(sound==14){
            buttonB.setTextColor(Color.RED);
            button_HIGH.setTextColor(Color.RED);
        }
        if(sound==-1){
            buttonC.setTextColor(Color.RED);
            button_LOW.setTextColor(Color.RED);
        }
        if(sound==-2){
            buttonD.setTextColor(Color.RED);
            button_LOW.setTextColor(Color.RED);
        }
        if(sound==-3){
            buttonE.setTextColor(Color.RED);
            button_LOW.setTextColor(Color.RED);
        }
        if(sound==-4){
            buttonF.setTextColor(Color.RED);
            button_LOW.setTextColor(Color.RED);
        }
        if(sound==-5){
            buttonG.setTextColor(Color.RED);
            button_LOW.setTextColor(Color.RED);
        }
        if(sound==-6){
            buttonA.setTextColor(Color.RED);
            button_LOW.setTextColor(Color.RED);
        }
        if(sound==-7){
            buttonB.setTextColor(Color.RED);
            button_LOW.setTextColor(Color.RED);
        }
    }

    public void UnUseSoundTool(int sound){
        buttonC=MainActivity.buttonC;
        buttonD=MainActivity.buttonD;
        buttonE=MainActivity.buttonE;
        buttonF=MainActivity.buttonF;
        buttonG=MainActivity.buttonG;
        buttonA=MainActivity.buttonA;
        buttonB=MainActivity.buttonB;
        button_HIGH=MainActivity.button_HIGH;
        button_LOW=MainActivity.button_LOW;

        if(sound==1){
            buttonC.setTextColor(Color.BLACK);
        }
        if(sound==2){
            buttonD.setTextColor(Color.BLACK);
        }
        if(sound==3){
            buttonE.setTextColor(Color.BLACK);
        }
        if(sound==4){
            buttonF.setTextColor(Color.BLACK);
        }
        if(sound==5){
            buttonG.setTextColor(Color.BLACK);
        }
        if(sound==6){
            buttonA.setTextColor(Color.BLACK);
        }
        if(sound==7){
            buttonB.setTextColor(Color.BLACK);
        }
        if(sound==8){
            buttonC.setTextColor(Color.BLACK);
            button_HIGH.setTextColor(Color.BLACK);
        }
        if(sound==9){
            buttonD.setTextColor(Color.BLACK);
            button_HIGH.setTextColor(Color.BLACK);
        }
        if(sound==10){
            buttonE.setTextColor(Color.BLACK);
            button_HIGH.setTextColor(Color.BLACK);
        }
        if(sound==11){
            buttonF.setTextColor(Color.BLACK);
            button_HIGH.setTextColor(Color.BLACK);
        }
        if(sound==12){
            buttonG.setTextColor(Color.BLACK);
            button_HIGH.setTextColor(Color.BLACK);
        }
        if(sound==13){
            buttonA.setTextColor(Color.BLACK);
            button_HIGH.setTextColor(Color.BLACK);
        }
        if(sound==14){
            buttonB.setTextColor(Color.BLACK);
            button_HIGH.setTextColor(Color.BLACK);
        }
        if(sound==-1){
            buttonC.setTextColor(Color.BLACK);
            button_LOW.setTextColor(Color.BLACK);
        }
        if(sound==-2){
            buttonD.setTextColor(Color.BLACK);
            button_LOW.setTextColor(Color.BLACK);
        }
        if(sound==-3){
            buttonE.setTextColor(Color.BLACK);
            button_LOW.setTextColor(Color.BLACK);
        }
        if(sound==-4){
            buttonF.setTextColor(Color.BLACK);
            button_LOW.setTextColor(Color.BLACK);
        }
        if(sound==-5){
            buttonG.setTextColor(Color.BLACK);
            button_LOW.setTextColor(Color.BLACK);
        }
        if(sound==-6){
            buttonA.setTextColor(Color.BLACK);
            button_LOW.setTextColor(Color.BLACK);
        }
        if(sound==-7){
            buttonB.setTextColor(Color.BLACK);
            button_LOW.setTextColor(Color.BLACK);
        }
    }

}
