package com.customcontrol.zydev;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.customcontrol.zydev.evaluator.CharEvaluator;
import com.customcontrol.zydev.weight.ArcSeekBar;
import com.customcontrol.zydev.weight.MyPointView;

public class ValueAnimActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn;
    private Button cancelBtn;
    private ValueAnimator animator;
    private MyPointView pointView;
    private Button btn_change_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_anim);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);
        cancelBtn = findViewById(R.id.cancel);
        pointView = findViewById(R.id.mypoint);
        btn_change_color = findViewById(R.id.btn_change_color);

        ArcSeekBar arcSeekBar = findViewById(R.id.asb);
        arcSeekBar.setOnChangeListener(new ArcSeekBar.OnChangeListener() {
            @Override
            public void onStartTrackingTouch(boolean isCanDrag) {

            }

            @Override
            public void onProgressChanged(float progress, float max, boolean fromUser) {
                arcSeekBar.setLabelText((int)progress+"");
            }

            @Override
            public void onStopTrackingTouch(boolean isCanDrag) {

            }

            @Override
            public void onSingleTapUp() {

            }
        });

//        arcSeekBar.setProgressColor(0xFF02C3D5,0xFF2DDDCA);
//        arcSeekBar.setProgressColor(Color.parseColor("#02C3D5"),Color.parseColor("#2DDDCA"));
//        int[] mShaderColors = new int[]{0xFF02C3D5,0xFF2DDDCA};
        float[] postions = {0f,1.0f};
//        Shader shader = new SweepGradient(arcSeekBar.getCircleCenterX(),arcSeekBar.getCircleCenterY(),mShaderColors,postions);
//        arcSeekBar.setShader(shader);
        Log.d("zyzyzy", "????????????"+Color.parseColor("#02C3D5"));
        Log.d("zyzyzy", "????????????"+Color.parseColor("#2DDDCA"));


        btn.setOnClickListener(view -> {
//            TranslateAnimation animation = new TranslateAnimation(Animation.ABSOLUTE,0,Animation.ABSOLUTE,400,
//                    Animation.ABSOLUTE,0,Animation.ABSOLUTE,400);
//            animation.setFillAfter(true);
//            animation.setDuration(1000);
//            tv.startAnimation(animation);
//            animator = doAnimation();
            pointView.doPointAnim();
        });

        cancelBtn.setOnClickListener(view -> {
            pointView.cancel();
//            animator.cancel();
//            animator.removeAllListeners();
        });

        btn_change_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arcSeekBar.changeRunImg();
                arcSeekBar.invalidate();
                arcSeekBar.forceLayout();
                arcSeekBar.requestLayout();
            }
        });

        tv.setOnClickListener(view -> {
            Toast.makeText(this,"??????",Toast.LENGTH_SHORT).show();
        });
    }

    private ValueAnimator doAnimation() {
        //??????
//        animator = ValueAnimator.ofInt(0,400);
        //??????
//        animator = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        //????????????
        animator = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
        animator.setDuration(10000);
        /**
         * ???????????????????????????????????????200  ??????????????????200???????????????400
         */
//        animator.setEvaluator(new MyEvaluator());
        animator.addUpdateListener(animation -> {
            //?????????????????????????????? = 100 + ???400 - 100???* ????????????
//            int curValue = (int)animation.getAnimatedValue();
            //left,top,right,bottom?????????????????????
//            tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
//            tv.setBackgroundColor(curValue);

            char text = (char)animation.getAnimatedValue();
            tv.setText(String.valueOf(text));
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.d("zyzyzy", "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.d("zyzyzy", "onAnimationEnd: ");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Log.d("zyzyzy", "onAnimationCancel: ");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.d("zyzyzy", "onAnimationRepeat: ");
            }
        });
        /**
         * ValueAnimation.RESTART???????????????????????????
         * ValueAnimation.REVERSE????????????????????????
         */
//        animator.setRepeatMode(ValueAnimator.REVERSE);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setInterpolator(new MyInterploator());
        //????????????????????????
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
        return animator;
    }

    private ObjectAnimator doObjectAnim(){

        return null;
    }
}