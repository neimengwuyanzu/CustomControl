package com.customcontrol.zydev.evaluator;

import android.animation.TypeEvaluator;

public class CharEvaluator implements TypeEvaluator<Character> {
    /**
     *
     * @param fraction
     * @param startValue
     * @param endValue
     * @return  这个返回值就是animation.getAnimatedValue()获取到的值
     */
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt = (int)startValue;
        int endInt = (int)endValue;
        int curInt = (int) (startInt+fraction*(endInt - startInt));
        char result = (char)curInt;
        return result;
    }
}
