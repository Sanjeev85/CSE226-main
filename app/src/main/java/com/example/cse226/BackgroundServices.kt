package com.example.cse226

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BackgroundServices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_services)

        val text = findViewById<TextView>(R.id.startService)
        text.setOnClickListener {
            if (text.text.toString().equals("Started")) {
                text.text = "Stopped"
                stopService(Intent(this, backgroundService::class.java))
            } else {
                text.text = "Started"
                startService(Intent(this, backgroundService::class.java))
            }
        }
    }
}