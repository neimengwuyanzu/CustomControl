package com.customcontrol.zydev;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.customcontrol.zydev.evaluator.CharEvaluator;
import com.customcontrol.zydev.weight.MyPointView;

public class ValueAnimActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn;
    private Button cancelBtn;
    private ValueAnimator animator;
    private MyPointView pointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_anim);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);
        cancelBtn = findViewById(R.id.cancel);
        pointView = findViewById(R.id.mypoint);



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

        tv.setOnClickListener(view -> {
            Toast.makeText(this,"点击",Toast.LENGTH_SHORT).show();
        });
    }

    private ValueAnimator doAnimation() {
        //位移
//        animator = ValueAnimator.ofInt(0,400);
        //渐变
//        animator = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        //变换字母
        animator = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
        animator.setDuration(10000);
        /**
         * 自定义的数值转换器里面加了200  所以动画会从200开始移动到400
         */
//        animator.setEvaluator(new MyEvaluator());
        animator.addUpdateListener(animation -> {
            //返回值的公式当前的值 = 100 + （400 - 100）* 显示进度
//            int curValue = (int)animation.getAnimatedValue();
            //left,top,right,bottom这四个点的坐标
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
         * ValueAnimation.RESTART表示正序重新开始，
         * ValueAnimation.REVERSE表示倒序重新开始
         */
//        animator.setRepeatMode(ValueAnimator.REVERSE);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setInterpolator(new MyInterploator());
        //根据时间递增进度
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
        return animator;
    }
}