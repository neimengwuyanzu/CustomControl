package com.customcontrol.zydev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //从XML文件导入的方式
//        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scaleanim)
        val alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alphaanim)
        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotateanim)
        val translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translateanim)
        val setAnimation = AnimationUtils.loadAnimation(this, R.anim.setanim)
        //代码动态生成的方式
//        var scaleAnimation:ScaleAnimation(0.5f,1.4f,0.5f,1.4f)
        //缩放
        scaleAnimBtn.setOnClickListener {
//            scaleAnimation.setInterpolator(this,android.R.anim.accelerate_decelerate_interpolator)
//            tv.startAnimation(scaleAnimation)
            tv.startAnimation(ScaleAnimation(0.0f,1.4f,0.0f,1.4f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f))

        }
        //透明度
        alphaAnimBtn.setOnClickListener {
            tv.startAnimation(alphaAnimation)
        }
        //旋转
        rotateAnimBtn.setOnClickListener {
            tv.startAnimation(rotateAnimation)
        }
        //平移
        translateAnimBtn.setOnClickListener {
            tv.startAnimation(translateAnimation)
        }
        setAnimBtn.setOnClickListener {
            tv.startAnimation(setAnimation)
        }
    }
}