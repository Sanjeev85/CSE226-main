package com.example.cse226

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Fan_drawable : AppCompatActivity() {
    lateinit var customViewFan: CustomViewFan
    lateinit var customViewDrawing: CustomViewDrawing
    lateinit var customDrawing: CustomDrawing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fan_drawable)

        val cb = findViewById<Button>(R.id.clear)
        customViewFan = findViewById<View>(R.id.cd) as CustomViewFan

//        cb.setOnClickListener {
//            customViewFan.clear()
//        }
    }
}