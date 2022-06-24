package com.customcontrol.zydev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scaleanim)
        val alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alphaanim)
        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotateanim)
        val translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translateanim)
        val setAnimation = AnimationUtils.loadAnimation(this, R.anim.setanim)
        //缩放
        scaleAnimBtn.setOnClickListener {
            tv.startAnimation(scaleAnimation)
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