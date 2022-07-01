package com.customcontrol.zydev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class AnimActivity extends AppCompatActivity {

    private Button scaleAnimBtn;
    private Button alphaAnimBtn;
    private Button rotateAnimBtn;
    private Button translateAnimBtn;
    private Button setAnimBtn;
    private TextView tv;
//    private Animation sacleAnim;
//    private Animation alphaAnim;
//    private Animation rotateAnim;
//    private Animation translateAnim;
//    private Animation setAnim;
    private ScaleAnimation scaleAnim;
    private AlphaAnimation alphaAnim;
    private RotateAnimation rotateAnim;
    private TranslateAnimation translateAnim;
    private AnimationSet setAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        initView();
        setDefault();
        onclick();
    }

    private void setDefault() {
        //导入xml创建方式
//        sacleAnim = AnimationUtils.loadAnimation(this, R.anim.scaleanim);
//        alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alphaanim);
//        rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotateanim);
//        translateAnim = AnimationUtils.loadAnimation(this, R.anim.translateanim);
//        setAnim = AnimationUtils.loadAnimation(this, R.anim.setanim);
        //动态创建方式
        scaleAnim = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnim.setDuration(2000);
        scaleAnim.setInterpolator(new BounceInterpolator());

        alphaAnim = new AlphaAnimation(1.0f,0.1f);
        alphaAnim.setDuration(3000);
        alphaAnim.setFillBefore(true);
        rotateAnim = new RotateAnimation(0,-650,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnim.setDuration(3000);
        rotateAnim.setFillAfter(true);
        translateAnim = new TranslateAnimation(Animation.ABSOLUTE,0,Animation.ABSOLUTE,-80,Animation.ABSOLUTE,0,Animation.ABSOLUTE,0);
        translateAnim.setDuration(2000);
        translateAnim.setFillBefore(true);


        AlphaAnimation alphaSetAnim = new AlphaAnimation(1.0f,0.1f);
        ScaleAnimation scaleSetAnim = new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation rotateSetAnim = new RotateAnimation(0,720,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        setAnim = new AnimationSet(true);
        setAnim.addAnimation(alphaSetAnim);
        setAnim.addAnimation(scaleSetAnim);
        setAnim.addAnimation(rotateSetAnim);
        setAnim.setDuration(3000);
        setAnim.setFillAfter(true);
    }

    private void onclick() {
        scaleAnimBtn.setOnClickListener(view -> tv.startAnimation(scaleAnim));
        alphaAnimBtn.setOnClickListener(view -> tv.startAnimation(alphaAnim));
        rotateAnimBtn.setOnClickListener(view -> {
            tv.startAnimation(rotateAnim);
        });
        translateAnimBtn.setOnClickListener(view -> {
            tv.startAnimation(translateAnim);
        });
        setAnimBtn.setOnClickListener(view -> {
            tv.startAnimation(setAnim);
        });

    }

    private void initView() {
        tv = findViewById(R.id.tv);
        scaleAnimBtn = findViewById(R.id.scaleAnimBtn);
        alphaAnimBtn = findViewById(R.id.alphaAnimBtn);
        rotateAnimBtn = findViewById(R.id.rotateAnimBtn);
        translateAnimBtn = findViewById(R.id.translateAnimBtn);
        setAnimBtn = findViewById(R.id.setAnimBtn);
    }
}