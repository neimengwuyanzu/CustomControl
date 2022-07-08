package com.customcontrol.zydev.weight;

import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.customcontrol.zydev.evaluator.PointEvaluator;

public class MyPointView extends View {
    private Point mCurPoint;
    private ValueAnimator animator;

    public MyPointView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCurPoint != null){
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,mCurPoint.getRadius(),paint);
        }
    }

    public void doPointAnim(){
        animator = ValueAnimator.ofObject(new PointEvaluator(),new Point(20),new Point(200));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mCurPoint = (Point) animator.getAnimatedValue();
                //强制刷新
                invalidate();
            }
        });
        animator.setDuration(1000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

    public void cancel(){
        animator.cancel();
        animator.removeAllListeners();
    }
}
