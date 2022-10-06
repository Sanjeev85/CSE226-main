package com.example.cse226

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class servicesExample : AppCompatActivity() {
    lateinit var start: Button
    lateinit var stop: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services_example)

        start = findViewById(R.id.start)
        stop = findViewById(R.id.stop)

        start.setOnClickListener {
            Log.e(this.toString(), "service start")
            startService(Intent(this, NewService::class.java))
        }
        stop.setOnClickListener {
            Log.e(this.toString(), "service end")
            startService(Intent(this, NewService::class.java))
        }
    }
}