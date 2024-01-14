package com.example.learningsample.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import com.example.learningsample.R
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val viewFlipper = findViewById<ViewFlipper>(R.id.view_flipper)

        val item1 = LayoutInflater.from(this).inflate(R.layout.item, viewFlipper, false).apply {
            setBackgroundColor(Color.parseColor("#80000000")) // 半透明灰色
        }
        val item2 = LayoutInflater.from(this).inflate(R.layout.item, viewFlipper, false).apply {
            setBackgroundColor(Color.parseColor("#FF3F51B5")) // 深蓝色
        }
        val item3 = LayoutInflater.from(this).inflate(R.layout.item, viewFlipper, false).apply {
            setBackgroundColor(Color.parseColor("#FFFF5722")) // 橙色
        }

        // 将视图添加到 ViewFlipper
        viewFlipper.addView(item1)
        viewFlipper.addView(item2)
        viewFlipper.addView(item3)

        val inAnimation = TranslateAnimation(0f, 0f, 100f, 0f).apply {
            duration = 500 // 动画持续时间为 500 毫秒
        }
        val outAnimation = TranslateAnimation(0f, 0f, 0f, -100f).apply {
            duration = 500 // 同样设置持续时间
        }

        viewFlipper.inAnimation = inAnimation
        viewFlipper.outAnimation = outAnimation

        button.setOnClickListener {
            if(viewFlipper.isFlipping)
                viewFlipper.stopFlipping()
            else
                viewFlipper.startFlipping()
        }
    }
}
