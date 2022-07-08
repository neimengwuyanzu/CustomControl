package com.customcontrol.zydev.evaluator;

import android.animation.TypeEvaluator;

import com.customcontrol.zydev.weight.Point;

public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int start = startValue.getRadius();
        int end = endValue.getRadius();
        int curValue = (int) (start+ fraction*(end-start));
        return new Point(curValue);
    }
}
