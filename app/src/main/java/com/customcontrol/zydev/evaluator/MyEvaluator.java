package com.customcontrol.zydev.evaluator;

import android.animation.TypeEvaluator;

/**
 * Evaluator其实就是一个转换器，他能把小数进度转换成对应的数值位置
 */
public class MyEvaluator implements TypeEvaluator<Integer> {
    /**
     *
     * @param fraction 就是加速器中的返回值 表示当前动画的数值进度
     * @param startValue 对应ofint里的start
     * @param endValue 对应ofint里的end
     * @return
     */
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        /**
         * 增加200的移动距离
         */
//        return (int)(200+startInt+fraction*(endValue-startValue));
        /**
         * 倒序
         *      fraction * (endValue - startInt)表示动画实际运动的距离
         */
        return (int) (endValue - fraction * (endValue - startValue));
    }
}
