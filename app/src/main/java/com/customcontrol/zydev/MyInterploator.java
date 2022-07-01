package com.customcontrol.zydev;

import android.animation.TimeInterpolator;

/**
 * 自定义插值器
 */
public class MyInterploator implements TimeInterpolator {
    /**
     *
     * @param input 取值范围是0-1
     *                  0表示动画刚开始
     *                  1表示动画结束
     *                  0.5表示进行到一半
     * @return      返回值表示当前实际想要显示的进度
     *                  取值也可以超过1 也可以小于0
     *                      超过1表示已经超过目标值
     *                      小于0表示小于开始位置
     */
    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }
}
