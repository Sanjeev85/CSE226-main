package com.example.cse226

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class foregroundServicess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foreground_servicess)
        val start = findViewById<Button>(R.id.startService1).setOnClickListener {
            val startIntent = Intent(this, ForegroundService1::class.java)
            startIntent.putExtra("inputExtra", "Foreground Service is running")
            ContextCompat.startForegroundService(this, startIntent)
        }
        val stop = findViewById<Button>(R.id.endService1).setOnClickListener {
            val stopIntent = Intent(this, ForegroundService1::class.java)
            stopService(stopIntent)
        }
    }
}